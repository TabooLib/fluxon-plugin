package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityCreatePortalEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntityCreatePortalEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityCreatePortalEvent::class.java)
                .function("entity", 0) { it.target?.getEntity() }
                .function("blocks", 0) { it.target?.blocks }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("portalType", 0) { it.target?.portalType }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityCreatePortalEvent.getHandlerList() }
        }
    }
}
