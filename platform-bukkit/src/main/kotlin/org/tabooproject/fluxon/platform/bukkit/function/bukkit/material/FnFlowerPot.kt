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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.FlowerPot"])
@PlatformSide(Platform.BUKKIT)
object FnFlowerPot {

    val TYPE = Type.fromClass(FlowerPot::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FlowerPot::class.java)
                .function("contents",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE).noParams()) { it.setReturnRef(it.target?.contents) }
                .function("setContents",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE)) { it.target?.setContents(it.getRef(0) as MaterialData) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
