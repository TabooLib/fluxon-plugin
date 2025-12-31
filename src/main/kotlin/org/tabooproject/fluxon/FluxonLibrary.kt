package org.tabooproject.fluxon

import org.tabooproject.fluxon.interpreter.bytecode.FluxonClassLoader
import org.tabooproject.fluxon.parser.error.ParseException
import org.tabooproject.fluxon.runtime.Environment
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.RuntimeScriptBase
import org.tabooproject.fluxon.runtime.library.LibraryLoader
import org.tabooproject.fluxon.util.with
import taboolib.common.LifeCycle
import taboolib.common.io.deepDelete
import taboolib.common.io.newFile
import taboolib.common.platform.function.getDataFolder
import taboolib.common.platform.function.info
import taboolib.common.platform.function.warning
import taboolib.platform.bukkit.Parallel
import java.io.File
import java.util.concurrent.ConcurrentHashMap
import kotlin.time.measureTime

object FluxonLibrary {

    // 脚本类加载器
    val classLoader = FluxonClassLoader(FluxonLibrary::class.java.classLoader)
    // 脚本库加载器
    val libraryLoader = LibraryLoader(FluxonRuntime.getInstance(), classLoader)
    // 脚本容器
    val scripts = ConcurrentHashMap<String, FluxonScript>()

    @Parallel("fluxon_library", runOn = LifeCycle.LOAD)
    fun reload() {
        unload()
        val time = measureTime {
            // 加载系统库
            getDataFolder().resolve("syslib").walk().forEach {
                if (it.extension == "fs") {
                    libraryLoader.load(it.toPath())
                }
            }
            // 加载自定义脚本文件
            scripts += compileFolder(getDataFolder().resolve("scripts"))
        }
        info("已加载 ${libraryLoader.managedResults.size} 个系统库, ${scripts.size} 个脚本文件，耗时: $time")
    }

    fun unload () {
        scripts.forEach { it.value.unload() }
        scripts.clear()
        libraryLoader.unloadManagedResults()
    }

    fun compileFolder(folder: File): Map<String, FluxonScript> {
        val scripts = HashMap<String, FluxonScript>()
        // 用于编译的全局环境
        val environment = FluxonRuntime.getInstance().newEnvironment()
        // 遍历所有脚本文件
        folder.resolve("classes").deepDelete()
        folder.walk().toList().parallelStream().forEach {
            val entry = compileFile(it, environment)
            if (entry != null) {
                scripts[entry.key] = entry.value
            }
        }
        return scripts
    }

    fun compileFile(file: File, environment: Environment): Map.Entry<String, FluxonScript>? {
        if (file.extension == "fs") {
            // 编译文件
            try {
                val className = "${file.nameWithoutExtension}_${System.currentTimeMillis()}"
                val result = Fluxon.compile(file.readText(), className, environment, FluxonLibrary::class.java.classLoader)
                val instance = result.createInstance(classLoader) as RuntimeScriptBase
                val id = file.path.substringAfter(getDataFolder().path).substringBeforeLast('.').replace("[/\\\\]".toRegex(), "_").drop(1)
                // 输出 class 文件
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
}