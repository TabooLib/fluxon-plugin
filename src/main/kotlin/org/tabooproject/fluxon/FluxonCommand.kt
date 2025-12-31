package org.tabooproject.fluxon

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.tool.FunctionDumper
import org.tabooproject.fluxon.util.exceptFluxonCompletableFutureError
import org.tabooproject.fluxon.util.tell
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.CommandHeader
import taboolib.common.platform.command.mainCommand
import taboolib.common.platform.command.subCommand
import taboolib.common.platform.command.subCommandExec
import taboolib.common.util.execution
import taboolib.expansion.createHelper
import kotlin.collections.component1
import kotlin.collections.component2

@CommandHeader("fluxon", aliases = ["fn"])
object FluxonCommand {

    @CommandBody
    private val main = mainCommand {
        createHelper()
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
        sender.tell("已加载的 Fluxon 脚本文件:")
        FluxonLibrary.scripts.forEach { (id, script) ->
            sender.tell("- $id (${script.javaClass.simpleName})")
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
    val dump = subCommandExec<ProxyCommandSender> {
        FunctionDumper().dumpToFile("fluxon-functions.json")
        sender.tell("已将 Fluxon 函数列表导出到 fluxon-functions.json 文件。")
    }

    @CommandBody
    private val reload = subCommandExec<ProxyCommandSender> {
        FluxonLibrary.reload()
        sender.tell("重载完成。")
    }
}