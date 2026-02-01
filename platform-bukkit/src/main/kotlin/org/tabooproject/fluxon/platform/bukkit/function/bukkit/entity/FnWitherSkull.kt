package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.WitherSkull
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

@Requires(classes = ["org.bukkit.entity.WitherSkull"])
@PlatformSide(Platform.BUKKIT)
object FnWitherSkull {

    val TYPE = Type.fromClass(WitherSkull::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WitherSkull::class.java)
                .function("setCharged", returnsVoid().params(Type.Z)) { it.target?.setCharged(it.getBool(0)) }
                .function("isCharged", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCharged ?: false) }
        }
    }
}
