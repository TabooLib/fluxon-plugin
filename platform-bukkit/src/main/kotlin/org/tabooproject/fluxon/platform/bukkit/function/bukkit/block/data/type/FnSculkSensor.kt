package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.SculkSensor
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.SculkSensor"])
@PlatformSide(Platform.BUKKIT)
object FnSculkSensor {

    val TYPE = Type.fromClass(SculkSensor::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkSensor::class.java)
                .function("phase", returns(FnSculkSensorPhase.TYPE).noParams()) { it.setReturnRef(it.target?.phase) }
                .function("setPhase", returnsVoid().params(FnSculkSensorPhase.TYPE)) { it.target?.setPhase(it.getRef(0) as SculkSensor.Phase) }
                .function("setPhase", returnsVoid().params(Type.STRING)) { FnSculkSensorPhase.enumValue(it.getString(0))?.let { p0 -> it.target?.setPhase(p0) } }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.SculkSensor.Phase"])
@PlatformSide(Platform.BUKKIT)
object FnSculkSensorPhase : FnEnumGetter<SculkSensor.Phase>() {

    override val enumClass: Class<SculkSensor.Phase> = SculkSensor.Phase::class.java
}