package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Leaves
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Leaves"])
@PlatformSide(Platform.BUKKIT)
object FnLeaves {

    val TYPE = Type.fromClass(Leaves::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Leaves::class.java)
                .function("isDecaying", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDecaying ?: false) }
                .function("setDecaying", returnsVoid().params(Type.Z)) { it.target?.setDecaying(it.getBool(0)) }
                .function("isDecayable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDecayable ?: false) }
                .function("setDecayable", returnsVoid().params(Type.Z)) { it.target?.setDecayable(it.getBool(0)) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
