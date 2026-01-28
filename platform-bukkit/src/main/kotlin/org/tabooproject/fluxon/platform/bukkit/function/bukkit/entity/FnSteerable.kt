package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Steerable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Steerable"])
@PlatformSide(Platform.BUKKIT)
object FnSteerable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Steerable::class.java)
                .function("hasSaddle", returns(Type.Z).noParams()) { it.target?.hasSaddle() }
                .function("setSaddle", returnsObject().params(Type.OBJECT)) { it.target?.setSaddle(it.getBool(0)) }
                .function("boostTicks", returnsObject().noParams()) { it.target?.boostTicks }
                .function("setBoostTicks", returnsObject().params(Type.OBJECT)) { it.target?.setBoostTicks(it.getInt(0).toInt()) }
                .function("currentBoostTicks", returnsObject().noParams()) { it.target?.currentBoostTicks }
                .function("setCurrentBoostTicks", returnsObject().params(Type.OBJECT)) { it.target?.setCurrentBoostTicks(it.getInt(0).toInt()) }
                .function("steerMaterial", returnsObject().noParams()) { it.target?.steerMaterial }
        }
    }
}
