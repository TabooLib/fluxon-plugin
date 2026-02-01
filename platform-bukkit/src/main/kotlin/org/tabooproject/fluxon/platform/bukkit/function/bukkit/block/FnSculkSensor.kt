package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.SculkSensor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.SculkSensor"])
@PlatformSide(Platform.BUKKIT)
object FnSculkSensor {

    val TYPE = Type.fromClass(SculkSensor::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkSensor::class.java)
                .function("lastVibrationFrequency", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lastVibrationFrequency ?: 0) }
                .function("setLastVibrationFrequency", returnsVoid().params(Type.I)) {
                    it.target?.setLastVibrationFrequency(
                        it.getInt(0).toInt()
                    )
                }
        }
    }
}
