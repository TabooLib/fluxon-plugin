package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Explosive
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

@Requires(classes = ["org.bukkit.entity.Explosive"])
@PlatformSide(Platform.BUKKIT)
object FnExplosive {

    val TYPE = Type.fromClass(Explosive::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Explosive::class.java)
                .function("setYield", returnsVoid().params(Type.F)) { it.target?.setYield(it.getFloat(0)) }
                .function("yield", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.yield ?: 0f) }
                .function("setIsIncendiary", returnsVoid().params(Type.Z)) { it.target?.setIsIncendiary(it.getBool(0)) }
                .function("isIncendiary", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isIncendiary ?: false) }
        }
    }
}
