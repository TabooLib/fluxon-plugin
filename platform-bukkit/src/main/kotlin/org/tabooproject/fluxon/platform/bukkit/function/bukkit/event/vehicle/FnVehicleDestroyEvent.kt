package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.vehicle

import org.bukkit.event.vehicle.VehicleDestroyEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnVehicleDestroyEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VehicleDestroyEvent::class.java)
                .function("attacker", 0) { it.target?.attacker }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { VehicleDestroyEvent.getHandlerList() }
        }
    }
}
