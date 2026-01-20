package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.vehicle

import org.bukkit.event.vehicle.VehicleMoveEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnVehicleMoveEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VehicleMoveEvent::class.java)
                .function("from", 0) { it.target?.from }
                .function("to", 0) { it.target?.to }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { VehicleMoveEvent.getHandlerList() }
        }
    }
}
