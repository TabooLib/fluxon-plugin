package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.CocoaPlant
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
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
                .function("size", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnCocoaPlantCocoaPlantSize.TYPE).noParams()) { it.setReturnRef(it.target?.size) }
                .function("setSize", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnCocoaPlantCocoaPlantSize.TYPE)) {
                    it.target?.setSize(it.getRef(0) as CocoaPlant.CocoaPlantSize)
                }
                .function("setSize", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnCocoaPlantCocoaPlantSize.enumValue(it.getString(0))?.let { p0 -> it.target?.setSize(p0) } }
                .function("attachedFace",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.attachedFace) }
                .function("setFacingDirection",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE)) {
                    it.target?.setFacingDirection(it.getRef(0) as BlockFace)
                }
                .function("facing",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.facing) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
