package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.FlowerPot
import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.FlowerPot"])
@PlatformSide(Platform.BUKKIT)
object FnFlowerPot {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FlowerPot::class.java)
                .function("contents", returnsObject().noParams()) { it.setReturnRef(it.target?.contents) }
                .function("setContents", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setContents(it.getRef(0) as MaterialData)) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
