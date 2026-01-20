package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.ServerCommandEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnServerCommandEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServerCommandEvent::class.java)
                .function("command", 0) { it.target?.command }
                .function("setCommand", 1) { it.target?.setCommand(it.getString(0)!!) }
                .function("sender", 0) { it.target?.sender }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { ServerCommandEvent.getHandlerList() }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
        }
    }
}
