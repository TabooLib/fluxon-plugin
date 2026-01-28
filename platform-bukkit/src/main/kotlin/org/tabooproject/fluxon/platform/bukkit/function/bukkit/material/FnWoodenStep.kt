package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.WoodenStep
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.WoodenStep"])
@PlatformSide(Platform.BUKKIT)
object FnWoodenStep {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WoodenStep::class.java)
                .function("isInverted", returns(Type.Z).noParams()) { it.target?.isInverted }
                .function("setInverted", returnsObject().params(Type.OBJECT)) { it.target?.setInverted(it.getBool(0)) }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
        }
    }
}
