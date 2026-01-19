package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.vehicle

import org.bukkit.event.vehicle.VehicleEntityCollisionEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnVehicleEntityCollisionEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VehicleEntityCollisionEvent::class.java)
                .function("entity", 0) { it.target?.entity }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("isPickupCancelled", 0) { it.target?.isPickupCancelled }
                .function("setPickupCancelled", 1) { it.target?.setPickupCancelled(it.getBoolean(0)) }
                .function("isCollisionCancelled", 0) { it.target?.isCollisionCancelled }
                .function("setCollisionCancelled", 1) { it.target?.setCollisionCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { VehicleEntityCollisionEvent.getHandlerList() }
        }
    }
}
