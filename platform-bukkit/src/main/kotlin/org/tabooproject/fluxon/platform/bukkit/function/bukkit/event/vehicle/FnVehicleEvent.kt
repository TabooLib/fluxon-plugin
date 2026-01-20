package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.vehicle

import org.bukkit.event.vehicle.VehicleEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnVehicleEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VehicleEvent::class.java)
                .function("vehicle", 0) { it.target?.getVehicle() }
        }
    }
}
