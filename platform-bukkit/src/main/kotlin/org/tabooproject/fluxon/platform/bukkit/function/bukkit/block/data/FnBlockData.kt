package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import org.bukkit.block.BlockSupport
import org.bukkit.block.data.BlockData
import org.bukkit.block.structure.Mirror
import org.bukkit.block.structure.StructureRotation
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundGroup
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockSupport
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnPistonMoveReaction
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.structure.FnMirror
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.structure.FnStructureRotation
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.block.data.BlockData"])
@PlatformSide(Platform.BUKKIT)
object FnBlockData {

    val TYPE = Type.fromClass(BlockData::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockData::class.java)
                // .function("isRandomlyTicked", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRandomlyTicked ?: false) }
                .function("material", returns(FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.material) }
                .function("asString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.asString) }
                .function("getAsString", returns(Type.STRING).params(Type.Z)) { it.setReturnRef(it.target?.getAsString(it.getBool(0))) }
                .function("merge", returns(TYPE).params(TYPE)) { it.setReturnRef(it.target?.merge(it.getRef(0) as BlockData)) }
                .function("matches", returns(Type.Z).params(TYPE)) { it.setReturnBool(it.target?.matches(it.getRef(0) as BlockData) ?: false) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("soundGroup", returns(FnSoundGroup.TYPE).noParams()) { it.setReturnRef(it.target?.soundGroup) }
                .function("lightEmission", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lightEmission ?: 0) }
                .function("isOccluding", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOccluding ?: false) }
                .function("requiresCorrectToolForDrops", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.requiresCorrectToolForDrops() ?: false) }
                .function("isPreferredTool", returns(Type.Z).params(FnItemStack.TYPE)) { it.setReturnBool(it.target?.isPreferredTool(it.getRef(0) as ItemStack) ?: false) }
                .function("pistonMoveReaction", returns(FnPistonMoveReaction.TYPE).noParams()) { it.setReturnRef(it.target?.pistonMoveReaction) }
                .function("isSupported", returns(Type.Z).params(FnBlock.TYPE)) {
                    it.setReturnBool(it.target?.isSupported(it.getRef(0) as Block) ?: false)
                }
                .function("isSupported", returns(Type.Z).params(FnLocation.TYPE)) {
                    it.setReturnBool(it.target?.isSupported(it.getRef(0) as Block) ?: false)
                }
                .function("isFaceSturdy", returns(Type.Z).params(FnBlockFace.TYPE, FnBlockSupport.TYPE)) {
                    it.setReturnBool(it.target?.isFaceSturdy(
                        it.getRef(0) as BlockFace,
                        it.getRef(1) as BlockSupport
                    ) ?: false)
                }
                .function("isFaceSturdy", returns(Type.Z).params(FnBlockFace.TYPE, Type.STRING)) {
                    it.setReturnBool(FnBlockSupport.enumValue(it.getString(1))?.let { p1 ->
                        it.target?.isFaceSturdy(
                            it.getRef(0) as BlockFace,
                            p1
                        )
                    } ?: false)
                }
                .function("isFaceSturdy", returns(Type.Z).params(Type.STRING, FnBlockSupport.TYPE)) {
                    it.setReturnBool(FnBlockFace.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.isFaceSturdy(
                            p0,
                            it.getRef(1) as BlockSupport
                        )
                    } ?: false)
                }
                .function("isFaceSturdy", returns(Type.Z).params(Type.STRING, Type.STRING)) {
                    val face = FnBlockFace.enumValue(it.getString(0)) ?: return@function
                    val support = FnBlockSupport.enumValue(it.getString(1)) ?: return@function
                    it.setReturnBool(it.target?.isFaceSturdy(face, support) ?: false)
                }
                .function("mapColor", returns(FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.mapColor) }
                .function("placementMaterial", returns(FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.placementMaterial) }
                .function("rotate", returnsVoid().params(FnStructureRotation.TYPE)) { it.target?.rotate(it.getRef(0) as StructureRotation) }
                .function("mirror", returnsVoid().params(FnMirror.TYPE)) { it.target?.mirror(it.getRef(0) as Mirror) }
                .function("copyTo", returnsVoid().params(TYPE)) { it.target?.copyTo(it.getRef(0) as BlockData) }
        }
    }
}
