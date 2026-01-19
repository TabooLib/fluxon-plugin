package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Vehicle
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnVehicle {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vehicle::class.java)
                .function("velocity", 0) { it.target?.velocity }
                .function("setVelocity", 1) { it.target?.setVelocity(it.getArgument(0) as Vector) }
        }
    }
}
