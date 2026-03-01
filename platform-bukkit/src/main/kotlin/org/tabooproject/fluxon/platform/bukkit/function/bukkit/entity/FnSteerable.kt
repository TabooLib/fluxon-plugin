package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Steerable
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

@Requires(classes = ["org.bukkit.entity.Steerable"])
@PlatformSide(Platform.BUKKIT)
object FnSteerable {

    val TYPE = Type.fromClass(Steerable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Steerable::class.java)
                .function("hasSaddle", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasSaddle() ?: false) }
                .function("setSaddle", returnsVoid().params(Type.Z)) { it.target?.setSaddle(it.getBool(0)) }
                .function("boostTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.boostTicks ?: 0) }
                .function("setBoostTicks", returnsVoid().params(Type.I)) { it.target?.setBoostTicks(it.getInt(0).toInt()) }
                .function("currentBoostTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.currentBoostTicks ?: 0) }
                .function("setCurrentBoostTicks", returnsVoid().params(Type.I)) { it.target?.setCurrentBoostTicks(it.getInt(0).toInt()) }
                .function("steerMaterial",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.steerMaterial) }
        }
    }
}
