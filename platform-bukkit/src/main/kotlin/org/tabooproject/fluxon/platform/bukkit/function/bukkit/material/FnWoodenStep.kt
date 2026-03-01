package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.WoodenStep
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

@Requires(classes = ["org.bukkit.material.WoodenStep"])
@PlatformSide(Platform.BUKKIT)
object FnWoodenStep {

    val TYPE = Type.fromClass(WoodenStep::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WoodenStep::class.java)
                .function("isInverted", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInverted ?: false) }
                .function("setInverted", returnsVoid().params(Type.Z)) { it.target?.setInverted(it.getBool(0)) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
