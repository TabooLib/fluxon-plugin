package org.tabooproject.fluxon

import org.tabooproject.fluxon.interpreter.bytecode.FluxonClassLoader
import org.tabooproject.fluxon.parser.error.ParseException
import org.tabooproject.fluxon.runtime.Environment
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.RuntimeScriptBase
import org.tabooproject.fluxon.runtime.library.LibraryLoader
import org.tabooproject.fluxon.util.toScriptId
import org.tabooproject.fluxon.util.with
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.io.deepDelete
import taboolib.common.io.newFile
import taboolib.common.platform.function.getDataFolder
import taboolib.common.platform.function.info
import taboolib.common.platform.function.warning
import taboolib.platform.bukkit.Parallel
import java.io.File
import java.util.concurrent.ConcurrentHashMap
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@Requires(systemProperty = ["fluxon.hasFluxonPlugin=true"])
object FluxonLibrary {

    /**
     * 脚本类加载器
     *
     * 使用可替换的 ClassLoader，每次 reload 时创建新实例。
     * 旧的 ClassLoader 及其加载的所有类在失去引用后可被 GC 回收，
     * 避免 Metaspace 内存泄漏。
     */
    lateinit var classLoader: FluxonClassLoader
        private set

    /**
     * 脚本库加载器
     * 同样需要在 reload 时重建，因为它持有对 ClassLoader 的引用。
     */
    lateinit var libraryLoader: LibraryLoader
        private set

    // 脚本容器
    val scripts = ConcurrentHashMap<String, FluxonScript>()

    /**
     * 执行脚本库中的脚本
     * 自动释放
     *
     * @param name 脚本名称
     * @param vars 脚本变量
     */
    fun invoke(name: String, vars: Map<String, Any?>): Any? {
        val script = scripts[name]
        if (script == null) {
            warning("没有找到脚本 $name")
            return null
        }
        return script.invoke(vars = vars)
    }

    @OptIn(ExperimentalTime::class)
    @Parallel("fluxon_library", runOn = LifeCycle.LOAD)
    fun reload() {
        unload()
        // 创建新的 ClassLoader 和 LibraryLoader
        classLoader = FluxonClassLoader(FluxonLibrary::class.java.classLoader)
        libraryLoader = LibraryLoader(FluxonRuntime.getInstance(), classLoader)
        val time = measureTime {
            // 加载系统库
            getDataFolder().resolve("syslib").walk().forEach {
                if (it.extension == "fs") {
                    libraryLoader.load(it.toPath())
                }
            }
            // 加载自定义脚本文件
            getDataFolder().resolve("classes").deepDelete()
            scripts += compileFolder(getDataFolder().resolve("scripts"))
        }
        scripts.forEach { it.value.init() }
        info("已加载 ${libraryLoader.managedResults.size} 个系统库, ${scripts.size} 个脚本文件，耗时: $time")
    }

    fun unload() {
        scripts.forEach { it.value.unload() }
        scripts.clear()
        // 如果此时 ClassLoader 和 LibraryLoader 已初始化，则卸载已加载的库
        if (this::libraryLoader.isInitialized) {
            libraryLoader.unloadManagedResults()
        }
    }

    fun compileFolder(folder: File): Map<String, FluxonScript> {
        val scripts = HashMap<String, FluxonScript>()
        // 用于编译的全局环境
        val environment = FluxonRuntime.getInstance().newEnvironment()
        // 遍历所有脚本文件
        folder.walk().toList().parallelStream().forEach {
            val entry = compileFile(it, environment)
            if (entry != null) {
                synchronized(scripts) {
                    scripts[entry.key] = entry.value
                }
            }
        }
        return scripts
    }

    fun compileFile(file: File, environment: Environment): Map.Entry<String, FluxonScript>? {
        if (file.extension == "fs") {
            // 编译文件
            try {
                val className = "${file.nameWithoutExtension}_${System.currentTimeMillis()}"
                // 编译并创建实例
                val currentClassLoader = this.classLoader
                val result = Fluxon.compile(file.readText(), className, environment, currentClassLoader)
                val instance = result.createInstance(currentClassLoader) as RuntimeScriptBase
                // 输出 class 文件
                val id = file.toScriptId()
                newFile(getDataFolder().resolve("classes/$id/${result.className}.class")).writeBytes(result.mainClass)
                result.innerClasses.forEachIndexed { index, bytes ->
                    newFile(getDataFolder().resolve("classes/$id/${result.className}$$index.class")).writeBytes(bytes)
                }
                return id with FluxonScript(id, file, instance)
            } catch (ex: ParseException) {
                warning("编译脚本 ${file.path} 时发生错误:\n${ex.formatDiagnostic()}")
            } catch (ex: Throwable) {
                ex.printStackTrace()
            }
        }
        return null
    }

    /**
     * 加载单个脚本文件
     *
     * @param file 脚本文件
     * @param environment 运行环境
     * @return 加载结果
     */
    fun loadScriptFile(file: File, environment: Environment): LoadResult {
        val scriptId = file.toScriptId()
        // 检查是否已加载
        if (scripts.containsKey(scriptId)) {
            return LoadResult.ALREADY_LOADED
        }
        // 编译脚本
        val compiled = compileFile(file, environment) ?: return LoadResult.COMPILE_FAILED
        // 加载并初始化
        val (id, script) = compiled
        scripts[id] = script
        script.init()
        return LoadResult.SUCCESS
    }

    /**
     * 加载脚本结果
     */
    enum class LoadResult {
        SUCCESS,        // 加载成功
        ALREADY_LOADED, // 已加载
        COMPILE_FAILED  // 编译失败
    }
}