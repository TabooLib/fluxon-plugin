package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.vehicle

import org.bukkit.event.vehicle.VehicleBlockCollisionEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnVehicleBlockCollisionEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VehicleBlockCollisionEvent::class.java)
                .function("block", 0) { it.target?.block }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { VehicleBlockCollisionEvent.getHandlerList() }
        }
    }
}
