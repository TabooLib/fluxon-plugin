package org.tabooproject.fluxon.platform.bukkit.function

import org.bukkit.command.CommandSender
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.adaptCommandSender
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FunctionCommandSender {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandSender::class.java)
                .function("name", 0) { it.target?.name }
                .function("sendMessage", 1) { it.target?.sendMessage(it.getString(0)) }
                .syncFunction("performCommand", 1) {
                    adaptCommandSender(it.target!!).performCommand(it.getString(0)!!)
                }
        }
    }
}