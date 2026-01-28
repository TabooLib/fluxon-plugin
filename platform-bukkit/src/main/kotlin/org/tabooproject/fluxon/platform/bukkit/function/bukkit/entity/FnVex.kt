package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Vex
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Vex"])
@PlatformSide(Platform.BUKKIT)
object FnVex {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vex::class.java)
                .function("isCharging", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCharging) }
                .function("setCharging", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCharging(it.getBool(0))) }
                .function("bound", returnsObject().noParams()) { it.setReturnRef(it.target?.bound) }
                .function("setBound", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBound(it.getRef(0) as Location)) }
                .function("lifeTicks", returnsObject().noParams()) { it.setReturnRef(it.target?.lifeTicks) }
                .function("setLifeTicks", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLifeTicks(it.getInt(0).toInt())) }
                .function("hasLimitedLife", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasLimitedLife()) }
        }
    }
}
