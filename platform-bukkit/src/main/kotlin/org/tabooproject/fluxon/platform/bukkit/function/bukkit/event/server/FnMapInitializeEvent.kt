package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.MapInitializeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMapInitializeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapInitializeEvent::class.java)
                .function("map", 0) { it.target?.map }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { MapInitializeEvent.getHandlerList() }
        }
    }
}
