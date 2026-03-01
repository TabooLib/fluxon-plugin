package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.PolarBear"])
@PlatformSide(Platform.BUKKIT)
object FnPolarBear {

    val TYPE = Type.fromClass(org.bukkit.entity.PolarBear::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.entity.PolarBear::class.java)
                // .function("isStanding", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isStanding() ?: false) }
                // .function("setStanding", returnsVoid().params(Type.Z)) { it.target?.setStanding(it.getBool(0)) }
        }
    }
}
