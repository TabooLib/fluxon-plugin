package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.PluginCommand
import org.bukkit.command.TabCompleter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPluginCommand {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginCommand::class.java)
                .function("execute", 3) {
                    it.target?.execute(
                        it.getArgument(0) as CommandSender,
                        it.getString(1)!!,
                        it.getArgument(2) as Array<String>
                    )
                }
                .function("setExecutor", 1) { it.target?.setExecutor(it.getArgument(0) as CommandExecutor) }
                .function("executor", 0) { it.target?.executor }
                .function("setTabCompleter", 1) { it.target?.setTabCompleter(it.getArgument(0) as TabCompleter) }
                .function("tabCompleter", 0) { it.target?.tabCompleter }
                .function("plugin", 0) { it.target?.plugin }
                .function("tabComplete", 3) {
                    it.target?.tabComplete(
                        it.getArgument(0) as CommandSender,
                        it.getString(1)!!,
                        it.getArgument(2) as Array<String>
                    )
                }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
