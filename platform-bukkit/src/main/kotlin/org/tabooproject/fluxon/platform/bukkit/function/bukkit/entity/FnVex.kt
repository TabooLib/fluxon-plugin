package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Vex
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

@Requires(classes = ["org.bukkit.entity.Vex"])
@PlatformSide(Platform.BUKKIT)
object FnVex {

    val TYPE = Type.fromClass(Vex::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vex::class.java)
                .function("isCharging", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCharging ?: false) }
                .function("setCharging", returnsVoid().params(Type.Z)) { it.target?.setCharging(it.getBool(0)) }
                .function("bound",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.bound) }
                .function("setBound",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.target?.setBound(it.getRef(0) as Location) }
                .function("lifeTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lifeTicks ?: 0) }
                .function("setLifeTicks", returnsVoid().params(Type.I)) { it.target?.setLifeTicks(it.getInt(0).toInt()) }
                .function("hasLimitedLife", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasLimitedLife() ?: false) }
        }
    }
}
