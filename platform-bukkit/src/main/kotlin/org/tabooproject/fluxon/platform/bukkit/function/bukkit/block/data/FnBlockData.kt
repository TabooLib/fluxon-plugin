package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.Location
import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import org.bukkit.block.BlockSupport
import org.bukkit.block.data.BlockData
import org.bukkit.block.structure.Mirror
import org.bukkit.block.structure.StructureRotation
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.BlockData"])
@PlatformSide(Platform.BUKKIT)
object FnBlockData {

    val TYPE = Type.fromClass(BlockData::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockData::class.java)
                // .function("isRandomlyTicked", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRandomlyTicked ?: false) }
                .function("material", returnsObject().noParams()) { it.setReturnRef(it.target?.material) }
                .function("asString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.asString) }
                .function("getAsString", returns(Type.STRING).params(Type.Z)) { it.setReturnRef(it.target?.getAsString(it.getBool(0))) }
                .function("merge", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.merge(it.getRef(0) as BlockData)) }
                .function("matches", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.matches(it.getRef(0) as BlockData) ?: false) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("soundGroup", returnsObject().noParams()) { it.setReturnRef(it.target?.soundGroup) }
                .function("lightEmission", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lightEmission ?: 0) }
                .function("isOccluding", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOccluding ?: false) }
                .function("requiresCorrectToolForDrops", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.requiresCorrectToolForDrops() ?: false) }
                .function("isPreferredTool", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.isPreferredTool(it.getRef(0) as ItemStack) ?: false) }
                .function("pistonMoveReaction", returnsObject().noParams()) { it.setReturnRef(it.target?.pistonMoveReaction) }
                .function("isSupported", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is Block -> it.target?.isSupported(var1)
                        is Location -> it.target?.isSupported(var1)
                        else -> throw IllegalArgumentException("参数必须是 Block 或 Location 类型")
                    } ?: false)
                }
                .function("isFaceSturdy", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnBool(it.target?.isFaceSturdy(
                        it.getRef(0) as BlockFace,
                        it.getRef(1) as BlockSupport
                    ) ?: false)
                }
                .function("mapColor", returnsObject().noParams()) { it.setReturnRef(it.target?.mapColor) }
                .function("placementMaterial", returnsObject().noParams()) { it.setReturnRef(it.target?.placementMaterial) }
                .function("rotate", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.rotate(it.getRef(0) as StructureRotation)) }
                .function("mirror", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.mirror(it.getRef(0) as Mirror)) }
                .function("copyTo", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.copyTo(it.getRef(0) as BlockData)) }
        }
    }
}
