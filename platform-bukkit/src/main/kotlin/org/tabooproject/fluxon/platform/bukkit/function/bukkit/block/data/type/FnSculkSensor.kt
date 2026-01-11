package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.SculkSensor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSculkSensor {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkSensor::class.java)
                .function("phase", 0) { it.target?.phase }
                .function("setPhase", 1) { it.target?.setPhase(it.getArgument(0) as SculkSensor.Phase) }
        }
    }
}
