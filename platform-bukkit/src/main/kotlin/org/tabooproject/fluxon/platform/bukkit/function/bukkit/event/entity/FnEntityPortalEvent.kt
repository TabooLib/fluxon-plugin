package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityPortalEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.entity.EntityPortalEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityPortalEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityPortalEvent::class.java)
                .function("setSearchRadius", 1) { it.target?.setSearchRadius(it.getNumber(0).toInt()) }
                .function("searchRadius", 0) { it.target?.searchRadius }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityPortalEvent.getHandlerList() }
        }
    }
}
