package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Cauldron
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Cauldron"])
@PlatformSide(Platform.BUKKIT)
object FnCauldron {

    val TYPE = Type.fromClass(Cauldron::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cauldron::class.java)
                .function("isFull", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFull ?: false) }
                .function("isEmpty", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEmpty ?: false) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
