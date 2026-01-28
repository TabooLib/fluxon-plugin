package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Explosive
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Explosive"])
@PlatformSide(Platform.BUKKIT)
object FnExplosive {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Explosive::class.java)
                .function("setYield", returnsObject().params(Type.OBJECT)) { it.target?.setYield(it.getFloat(0)) }
                .function("yield", returnsObject().noParams()) { it.target?.yield }
                .function("setIsIncendiary", returnsObject().params(Type.OBJECT)) { it.target?.setIsIncendiary(it.getBool(0)) }
                .function("isIncendiary", returns(Type.Z).noParams()) { it.target?.isIncendiary }
        }
    }
}
