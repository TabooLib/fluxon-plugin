package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Leaves
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Leaves"])
@PlatformSide(Platform.BUKKIT)
object FnLeaves {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Leaves::class.java)
                .function("isDecaying", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isDecaying) }
                .function("setDecaying", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDecaying(it.getBool(0))) }
                .function("isDecayable", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isDecayable) }
                .function("setDecayable", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDecayable(it.getBool(0))) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
