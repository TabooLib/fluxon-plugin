package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.World
import org.bukkit.block.BlockType
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.BlockType"])
@PlatformSide(Platform.BUKKIT)
object FnBlockType {

    val TYPE = Type.fromClass(BlockType::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockType::class.java)
                .function("typed", returns(FnBlockTypeTyped.TYPE).noParams()) { it.setReturnRef(it.target?.typed()) }
                .function("hasItemType", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasItemType() ?: false) }
                .function("itemType", returns(FnItemType.TYPE).noParams()) { it.setReturnRef(it.target?.itemType) }
                .function("createBlockData", returns(FnBlockData.TYPE).noParams()) { it.setReturnRef(it.target?.createBlockData()) }
                .function("createBlockData", returns(FnBlockData.TYPE).params(Type.STRING)) {
                    it.setReturnRef(it.target?.createBlockData(it.getString(0)))
                }
                .function("isSolid", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSolid ?: false) }
                .function("isFlammable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFlammable ?: false) }
                .function("isBurnable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBurnable ?: false) }
                .function("isOccluding", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOccluding ?: false) }
                .function("hasGravity", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasGravity() ?: false) }
                .function("isInteractable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInteractable ?: false) }
                .function("hardness", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.hardness ?: 0.0f) }
                .function("blastResistance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.blastResistance ?: 0.0f) }
                .function("slipperiness", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.slipperiness ?: 0.0f) }
                .function("isAir", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAir ?: false) }
                .function("isEnabledByFeature", returns(Type.Z).params(FnWorld.TYPE)) {
                    it.setReturnBool(it.target?.isEnabledByFeature(it.getRef(0) as World) ?: false)
                }
                .function("asMaterial", returns(FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.asMaterial()) }
                .function("blockDataClass", returns(Type.CLASS).noParams()) { it.setReturnRef(it.target?.blockDataClass) }
        }
    }
}

@Requires(classes = ["org.bukkit.block.BlockType\$Typed"])
@PlatformSide(Platform.BUKKIT)
object FnBlockTypeTyped {

    val TYPE = Type.fromClass(BlockType.Typed::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockType.Typed::class.java)
                .function("blockDataClass", returns(Type.CLASS).noParams()) { it.setReturnRef(it.target?.blockDataClass) }
                .function("createBlockData", returns(FnBlockData.TYPE).noParams()) { it.setReturnRef(it.target?.createBlockData()) }
                .function("createBlockData", returns(FnBlockData.TYPE).params(Type.STRING)) {
                    it.setReturnRef((it.target as? BlockType.Typed<*>)?.createBlockData(it.getString(0)))
                }
        }
    }
}
