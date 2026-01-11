package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandMap
import org.bukkit.command.CommandSender
import org.spigotmc.CustomTimingsHandler
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCommand {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Command::class.java)
                .function("timings", 0) { it.target?.timings }
                .function("setTimings", 1) { it.target?.timings = it.getArgument(0) as CustomTimingsHandler }
                .function("execute", 3) {
                    it.target?.execute(
                        it.getArgument(0) as CommandSender,
                        it.getString(1)!!,
                        it.getArgument(2) as Array<String>,
                    )
                }
                .function("tabComplete", 3) {
                    it.target?.tabComplete(
                        it.getArgument(0) as CommandSender,
                        it.getString(1)!!,
                        it.getArgument(2) as Array<String>,
                    )
                }
                .function("tabComplete", 4) {
                    it.target?.tabComplete(
                        it.getArgument(0) as CommandSender,
                        it.getString(1)!!,
                        it.getArgument(2) as Array<String>,
                        it.getArgument(3) as Location
                    )
                }
                .function("name", 0) { it.target?.name }
                .function("setName", 1) { it.target?.setName(it.getString(0)!!) }
                .function("permission", 0) { it.target?.permission }
                .function("setPermission", 1) { it.target?.setPermission(it.getString(0)) }
                .function("testPermission", 1) { it.target?.testPermission(it.getArgument(0) as CommandSender) }
                .function(
                    "testPermissionSilent",
                    1
                ) { it.target?.testPermissionSilent(it.getArgument(0) as CommandSender) }
                .function("label", 0) { it.target?.label }
                .function("setLabel", 1) { it.target?.setLabel(it.getString(0)!!) }
                .function("register", 1) { it.target?.register(it.getArgument(0) as CommandMap) }
                .function("unregister", 1) { it.target?.unregister(it.getArgument(0) as CommandMap) }
                .function("isRegistered", 0) { it.target?.isRegistered }
                .function("aliases", 0) { it.target?.aliases }
                .function("permissionMessage", 0) { it.target?.permissionMessage }
                .function("description", 0) { it.target?.getDescription() }
                .function("usage", 0) { it.target?.usage }
                .function("setAliases", 1) { it.target?.setAliases(it.getArgument(0) as List<String>) }
                .function("setDescription", 1) { it.target?.setDescription(it.getString(0)!!) }
                .function("setPermissionMessage", 1) { it.target?.setPermissionMessage(it.getString(0)) }
                .function("setUsage", 1) { it.target?.setUsage(it.getString(0)!!) }
                .function(
                    "broadcastCommandMessage",
                    2
                ) { Command.broadcastCommandMessage(it.getArgument(0) as CommandSender, it.getString(1)!!) }
                .function(
                    "broadcastCommandMessage",
                    3
                ) {
                    Command.broadcastCommandMessage(
                        it.getArgument(0) as CommandSender,
                        it.getString(1)!!,
                        it.getBoolean(2)
                    )
                }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
