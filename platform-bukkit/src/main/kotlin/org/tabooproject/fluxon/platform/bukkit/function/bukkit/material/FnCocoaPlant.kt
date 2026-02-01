package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.CocoaPlant
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

@Requires(classes = ["org.bukkit.material.CocoaPlant"])
@PlatformSide(Platform.BUKKIT)
object FnCocoaPlant {

    val TYPE = Type.fromClass(CocoaPlant::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CocoaPlant::class.java)
                .function("size", returnsObject().noParams()) { it.setReturnRef(it.target?.size) }
                .function("setSize", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setSize(it.getRef(0) as CocoaPlant.CocoaPlantSize)
                }
                .function("attachedFace", returnsObject().noParams()) { it.setReturnRef(it.target?.attachedFace) }
                .function("setFacingDirection", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setFacingDirection(it.getRef(0) as BlockFace)
                }
                .function("facing", returnsObject().noParams()) { it.setReturnRef(it.target?.facing) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
