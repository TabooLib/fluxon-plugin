package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.Location
import org.bukkit.event.entity.EntityTeleportEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntityTeleportEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityTeleportEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("from", 0) { it.target?.from }
                .function("setFrom", 1) { it.target?.setFrom(it.getArgument(0) as Location) }
                .function("to", 0) { it.target?.to }
                .function("setTo", 1) { it.target?.setTo(it.getArgument(0) as Location) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityTeleportEvent.getHandlerList() }
        }
    }
}
