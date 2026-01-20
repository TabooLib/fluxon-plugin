package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.SculkSensor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSculkSensor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkSensor::class.java)
                .function("lastVibrationFrequency", 0) { it.target?.lastVibrationFrequency }
                .function("setLastVibrationFrequency", 1) {
                    it.target?.setLastVibrationFrequency(
                        it.getNumber(0).toInt()
                    )
                }
        }
    }
}
