package org.tabooproject.fluxon

import org.tabooproject.fluxon.FluxonLibrary.loadScriptFile
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.tool.FunctionDumper
import org.tabooproject.fluxon.util.exceptFluxonCompletableFutureError
import org.tabooproject.fluxon.util.findScriptFile
import org.tabooproject.fluxon.util.tell
import org.tabooproject.fluxon.util.toScriptId
import taboolib.common.Requires
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*
import taboolib.common.platform.function.getDataFolder
import taboolib.common.util.execution
import taboolib.common5.Demand
import taboolib.expansion.createHelper
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@Requires(classes = ["!org.tabooproject.fluxon.ParseScript"])
@CommandHeader("fluxon", aliases = ["fn"])
object FluxonCommand {

    @CommandBody
    private val main = mainCommand {
        createHelper()
    }

    @Suppress("DuplicatedCode")
    @OptIn(ExperimentalTime::class)
    @CommandBody
    private val run = subCommand {
        dynamic("id") {
            suggest { FluxonLibrary.scripts.keys().toList() }
            dynamic("params") {
                exec<ProxyCommandSender> {
                    val params = Demand("0 ${ctx["params"]}".trim())
                    val vars = hashMapOf<String, Any?>()
                    params.tags.forEach { vars[it] = true }
                    params.dataMap.forEach { vars[it.key] = it.value }
                    val sender = sender
                    vars["sender"] = sender
                    val result: Any?
                    val time = measureTime {
                        result = FluxonLibrary.invoke(ctx["id"], vars)
                    }
                    sender.tell("执行结果: $result")
                    sender.tell("耗时: $time")
                }
            }
            exec<ProxyCommandSender> {
                val vars = hashMapOf<String, Any?>()
                val sender = sender
                vars["sender"] = sender
                val result: Any?
                val time = measureTime {
                    result = FluxonLibrary.invoke(ctx["id"], vars)
                }
                sender.tell("执行结果: $result")
                sender.tell("耗时: $time")
            }
        }
    }

    @CommandBody
    private val eval = subCommand {
        dynamic("script") {
            exec<ProxyCommandSender> {
                try {
                    val (result, time) = execution {
                        FluxonShell.invoke(ctx["script"], useCache = false) {
                            defineRootVariable("sender", sender)
                        }
                    }
                    result?.exceptFluxonCompletableFutureError()
                    sender.tell("Result: $result")
                    sender.tell("$time ms")
                } catch (ex: Throwable) {
                    sender.tell("Error: ${ex.message}")
                    ex.printStackTrace()
                }
            }
        }
    }

    @CommandBody
    private val list = subCommandExec<ProxyCommandSender> {
        sender.tell("已加载的 Fluxon 库文件:")
        FluxonLibrary.libraryLoader.managedResults.forEach { result ->
            sender.tell("- ${result.sourcePath}")
        }
        sender.tell("已加载的 Fluxon 脚本文件 (${FluxonLibrary.scripts.size}):")
        FluxonLibrary.scripts.forEach { (id, script) ->
            val timeDiff = System.currentTimeMillis() - script.timestamp
            val timeStr = when {
                timeDiff < 60000 -> "${timeDiff / 1000} 秒前"
                timeDiff < 3600000 -> "${timeDiff / 60000} 分钟前"
                else -> "${timeDiff / 3600000} 小时前"
            }
            val statusInfo = buildList {
                add("加载: $timeStr")
                if (script.resources.isNotEmpty()) add("资源: ${script.resources.size}")
                if (script.initialized != null) add("已初始化")
            }.joinToString(", ")
            sender.tell("- $id")
            sender.tell("  类型: ${script.instance.javaClass.simpleName}")
            sender.tell("  文件: ${script.scriptFile.path}")
            sender.tell("  状态: $statusInfo")
        }
    }

    @CommandBody
    private val extensions = subCommandExec<ProxyCommandSender> {
        val entries = FluxonRuntime.getInstance().extensionFunctions.entries.sortedByDescending { it.value.size }
        sender.tell("当前扩展函数: (根据重复的函数名排序)")
        if (entries.size < 30) {
            entries.forEach {
                sender.tell("- ${it.key} ${it.value.keys.map { c -> c.simpleName }} (${it.value.size})")
            }
        } else {
            entries.take(30).forEach {
                sender.tell("- ${it.key} ${it.value.keys.map { c -> c.simpleName }} (${it.value.size})")
            }
            sender.tell("... 省略 ${entries.size - 20} 个 ...")
        }
        // 统计多候选类型的扩展函数总数
        val multiTypeCount = entries.count { it.value.size > 1 }
        sender.tell("多候选类型的扩展函数 $multiTypeCount 个")
        // 统计单个候选类型的扩展函数总数
        val singleTypeCount = entries.count { it.value.size == 1 }
        sender.tell("单候选类型的扩展函数: $singleTypeCount 个")
    }

    @CommandBody
    private val dump = subCommandExec<ProxyCommandSender> {
        FunctionDumper().dumpToFile("fluxon-functions.json")
        sender.tell("已将 Fluxon 函数列表导出到 fluxon-functions.json 文件。")
    }

    @CommandBody
    private val load = subCommand {
        dynamic("filename", optional = true) {
            suggest {
                getDataFolder().resolve("scripts").walk()
                    .filter { it.extension == "fs" }
                    .map { it.toScriptId() }
                    .toList()
            }
            exec<ProxyCommandSender> {
                val filename = ctx["filename"]
                val scriptsFolder = getDataFolder().resolve("scripts")
                val targetFile = findScriptFile(scriptsFolder, filename)
                if (targetFile == null) {
                    sender.tell("未找到脚本文件: $filename")
                } else {
                    val environment = FluxonRuntime.getInstance().newEnvironment()
                    when (loadScriptFile(targetFile, environment)) {
                        FluxonLibrary.LoadResult.SUCCESS -> sender.tell("脚本 ${targetFile.toScriptId()} 已加载。")
                        FluxonLibrary.LoadResult.ALREADY_LOADED -> sender.tell("脚本 ${targetFile.toScriptId()} 已加载，请先使用 unload 卸载或使用 reload 重载。")
                        FluxonLibrary.LoadResult.COMPILE_FAILED -> sender.tell("编译脚本 $filename 失败。")
                    }
                }
            }
        }
        exec<ProxyCommandSender> {
            val scriptsFolder = getDataFolder().resolve("scripts")
            val environment = FluxonRuntime.getInstance().newEnvironment()
            var loadedCount = 0
            var skippedCount = 0
            scriptsFolder.walk().forEach { file ->
                if (file.extension == "fs") {
                    when (loadScriptFile(file, environment)) {
                        FluxonLibrary.LoadResult.SUCCESS -> loadedCount++
                        FluxonLibrary.LoadResult.ALREADY_LOADED -> skippedCount++
                        FluxonLibrary.LoadResult.COMPILE_FAILED -> {} // 编译失败时 FluxonLibrary 已输出错误
                    }
                }
            }
            sender.tell("已加载 $loadedCount 个新脚本，跳过 $skippedCount 个已加载的脚本。")
        }
    }

    @CommandBody
    private val unload = subCommand {
        dynamic("id", optional = true) {
            suggest { FluxonLibrary.scripts.keys().toList() }
            exec<ProxyCommandSender> {
                val id = ctx["id"]
                val script = FluxonLibrary.scripts[id]
                if (script == null) {
                    sender.tell("脚本 $id 不存在。")
                } else {
                    script.unload()
                    FluxonLibrary.scripts.remove(id)
                    sender.tell("脚本 $id 已卸载。")
                }
            }
        }
        exec<ProxyCommandSender> {
            val count = FluxonLibrary.scripts.size
            FluxonLibrary.scripts.forEach { it.value.unload() }
            FluxonLibrary.scripts.clear()
            sender.tell("已卸载 $count 个脚本（系统库未卸载）。")
        }
    }

    @CommandBody
    private val reload = subCommand {
        dynamic("id", optional = true) {
            suggest { FluxonLibrary.scripts.keys().toList() }
            exec<ProxyCommandSender> {
                val id = ctx["id"]
                val script = FluxonLibrary.scripts[id]
                if (script == null) {
                    sender.tell("脚本 $id 不存在。")
                } else {
                    script.reload()
                    sender.tell("脚本 $id 重载完成。")
                }
            }
        }
        exec<ProxyCommandSender> {
            FluxonLibrary.reload()
            sender.tell("重载完成。")
        }
    }
}