package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityPortalEnterEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEntityPortalEnterEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityPortalEnterEvent::class.java)
                .function("location", 0) { it.target?.location }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityPortalEnterEvent.getHandlerList() }
        }
    }
}
