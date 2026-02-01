package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Step
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.material.Step"])
@PlatformSide(Platform.BUKKIT)
object FnStep {

    val TYPE = Type.fromClass(Step::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Step::class.java)
                .function("textures", returnsObject().noParams()) { it.setReturnRef(it.target?.textures) }
                .function("isInverted", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInverted ?: false) }
                .function("setInverted", returnsVoid().params(Type.Z)) { it.target?.setInverted(it.getBool(0)) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
