package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.SimpleCommandMap
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSimpleCommandMap {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimpleCommandMap::class.java)
                .function("setFallbackCommands", 0) { it.target?.setFallbackCommands() }
                .function("registerAll", 2) {
                    it.target?.registerAll(
                        it.getString(0)!!,
                        it.getArgument(1) as List<Command>
                    )
                }
                .function("register", 2) { it.target?.register(it.getString(0)!!, it.getArgument(1) as Command) }
                .function("register", 3) {
                    it.target?.register(
                        it.getString(0)!!,
                        it.getString(1)!!,
                        it.getArgument(2) as Command
                    )
                }
                .function("dispatch", 2) { it.target?.dispatch(it.getArgument(0) as CommandSender, it.getString(1)!!) }
                .function("command", 1) { it.target?.getCommand(it.getString(0)!!) }
                .function("tabComplete", 2) {
                    it.target?.tabComplete(
                        it.getArgument(0) as CommandSender,
                        it.getString(1)!!
                    )
                }
                .function("tabComplete", 3) {
                    it.target?.tabComplete(
                        it.getArgument(0) as CommandSender,
                        it.getString(1)!!,
                        it.getArgument(2) as Location
                    )
                }
                .function("commands", 0) { it.target?.commands }
                .function("registerServerAliases", 0) { it.target?.registerServerAliases() }
        }
    }
}
