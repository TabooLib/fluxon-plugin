package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.CommandSender
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.adaptCommandSender
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCommandSender {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandSender::class.java)
                .syncFunction("performCommand", 1) { adaptCommandSender(it.target!!).performCommand(it.getString(0)!!) }
                .function("sendMessage", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.sendMessage(it.getString(0))
                    } else {
                        it.target?.sendMessage(
                            UUID.fromString(it.getString(0)),
                            it.getString(1)
                        )
                    }
                }
                .function("server", 0) { it.target?.server }
                .function("name", 0) { it.target?.name }
        }
    }
}
