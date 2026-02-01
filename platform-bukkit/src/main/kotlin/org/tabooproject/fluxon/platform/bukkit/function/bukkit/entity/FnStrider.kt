package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Strider
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

@Requires(classes = ["org.bukkit.entity.Strider"])
@PlatformSide(Platform.BUKKIT)
object FnStrider {

    val TYPE = Type.fromClass(Strider::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Strider::class.java)
                .function("isShivering", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isShivering ?: false) }
                .function("setShivering", returnsVoid().params(Type.Z)) { it.target?.setShivering(it.getBool(0)) }
        }
    }
}
