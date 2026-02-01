package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.DyeColor
import org.bukkit.material.Wool
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

@Requires(classes = ["org.bukkit.material.Wool"])
@PlatformSide(Platform.BUKKIT)
object FnWool {

    val TYPE = Type.fromClass(Wool::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wool::class.java)
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsVoid().params(Type.OBJECT)) { it.target?.setColor(it.getRef(0) as DyeColor) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
