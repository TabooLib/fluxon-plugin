package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Zoglin
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

@Requires(classes = ["org.bukkit.entity.Zoglin"])
@PlatformSide(Platform.BUKKIT)
object FnZoglin {

    val TYPE = Type.fromClass(Zoglin::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Zoglin::class.java)
                .function("isBaby", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBaby ?: false) }
                .function("setBaby", returnsVoid().params(Type.Z)) { it.target?.setBaby(it.getBool(0)) }
        }
    }
}
