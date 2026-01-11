package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Vibration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnVibration {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vibration::class.java)
                .function("origin", 0) { it.target?.origin }
                .function("destination", 0) { it.target?.destination }
                .function("arrivalTime", 0) { it.target?.arrivalTime }

            registerExtension(Vibration.Destination.EntityDestination::class.java)
                .function("entity", 0) { it.target?.entity }

            registerExtension(Vibration.Destination.BlockDestination::class.java)
                .function("location", 0) { it.target?.location }
                .function("block", 0) { it.target?.block }
        }
    }
}
