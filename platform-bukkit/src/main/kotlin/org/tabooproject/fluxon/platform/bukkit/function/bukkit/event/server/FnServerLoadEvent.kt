package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.ServerLoadEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnServerLoadEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServerLoadEvent::class.java)
                .function("type", 0) { it.target?.type }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { ServerLoadEvent.getHandlerList() }
        }
    }
}
