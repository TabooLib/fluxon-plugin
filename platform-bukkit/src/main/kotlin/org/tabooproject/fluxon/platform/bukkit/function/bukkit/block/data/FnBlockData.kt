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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockData::class.java)
//                .function("isRandomlyTicked", returns(Type.Z).noParams()) { it.target?.isRandomlyTicked }
                .function("material", returnsObject().noParams()) { it.target?.material }
                .function("asString", returnsObject().noParams()) { it.target?.asString }
                .function("getAsString", returnsObject().params(Type.OBJECT)) { it.target?.getAsString(it.getBool(0)) }
                .function("merge", returnsObject().params(Type.OBJECT)) { it.target?.merge(it.getRef(0) as BlockData) }
                .function("matches", returnsObject().params(Type.OBJECT)) { it.target?.matches(it.getRef(0) as BlockData) }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
                .function("soundGroup", returnsObject().noParams()) { it.target?.soundGroup }
                .function("lightEmission", returnsObject().noParams()) { it.target?.lightEmission }
                .function("isOccluding", returns(Type.Z).noParams()) { it.target?.isOccluding }
                .function("requiresCorrectToolForDrops", returnsObject().noParams()) { it.target?.requiresCorrectToolForDrops() }
                .function("isPreferredTool", returns(Type.Z).params(Type.OBJECT)) { it.target?.isPreferredTool(it.getRef(0) as ItemStack) }
                .function("pistonMoveReaction", returnsObject().noParams()) { it.target?.pistonMoveReaction }
                .function("isSupported", returns(Type.Z).params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is Block -> it.target?.isSupported(var1)
                        is Location -> it.target?.isSupported(var1)
                        else -> throw IllegalArgumentException("参数必须是 Block 或 Location 类型")
                    }
                }
                .function("isFaceSturdy", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.isFaceSturdy(
                        it.getRef(0) as BlockFace,
                        it.getRef(1) as BlockSupport
                    )
                }
                .function("mapColor", returnsObject().noParams()) { it.target?.mapColor }
                .function("placementMaterial", returnsObject().noParams()) { it.target?.placementMaterial }
                .function("rotate", returnsObject().params(Type.OBJECT)) { it.target?.rotate(it.getRef(0) as StructureRotation) }
                .function("mirror", returnsObject().params(Type.OBJECT)) { it.target?.mirror(it.getRef(0) as Mirror) }
                .function("copyTo", returnsObject().params(Type.OBJECT)) { it.target?.copyTo(it.getRef(0) as BlockData) }
        }
    }
}
