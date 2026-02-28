package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.FluidCollisionMode
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Biome
import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import org.bukkit.block.data.BlockData
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunk
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFluidCollisionMode
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnRayTraceResult
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVoxelShape
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.util.StandardTypes
import taboolib.library.xseries.XMaterial
import kotlin.jvm.optionals.getOrNull


@Requires(classes = ["org.bukkit.block.Block"])
@PlatformSide(Platform.BUKKIT)
object FnBlock {

    val TYPE = Type.fromClass(Block::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Block::class.java)
                .function("data", returns(Type.I).noParams()) { it.setReturnRef(it.target?.data?.toInt()) }
                .function("blockData", returns(FnBlockData.TYPE).noParams()) { it.setReturnRef(it.target?.blockData) }
                .function("getRelative", returns(TYPE).params(FnBlockFace.TYPE)) {
                    it.setReturnRef(it.target?.getRelative(it.getRef(0) as BlockFace))
                }
                .function("getRelative", returns(TYPE).params(Type.STRING)) {
                    FnBlockFace.enumValue(it.getString(0))?.let { p0 -> it.setReturnRef(it.target?.getRelative(p0)) }
                }
                .function("getRelative", returns(TYPE).params(FnBlockFace.TYPE, Type.I)) {
                    it.setReturnRef(it.target?.getRelative(
                        it.getRef(0) as BlockFace,
                        it.getInt(1)
                    ))
                }
                .function("getRelative", returns(TYPE).params(Type.STRING, Type.I)) {
                    FnBlockFace.enumValue(it.getString(0))?.let { p0 ->
                        it.setReturnRef(it.target?.getRelative(
                            p0,
                            it.getInt(1)
                        ))
                    }
                }
                .function("getRelative", returns(TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getRelative(
                        it.getInt(0),
                        it.getInt(1),
                        it.getInt(2)
                    ))
                }
                .function("type", returns(FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
                .function("lightLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lightLevel?.toInt() ?: 0) }
                .function("lightFromSky", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lightFromSky?.toInt() ?: 0) }
                .function("lightFromBlocks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lightFromBlocks?.toInt() ?: 0) }
                .function("world", returns(FnWorld.TYPE).noParams()) { it.setReturnRef(it.target?.world) }
                .function("x", returns(Type.I).noParams()) { it.setReturnInt(it.target?.x ?: 0) }
                .function("y", returns(Type.I).noParams()) { it.setReturnInt(it.target?.y ?: 0) }
                .function("z", returns(Type.I).noParams()) { it.setReturnInt(it.target?.z ?: 0) }
                .function("location", returns(FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.location) }
                .function("getLocation", returns(FnLocation.TYPE).params(FnLocation.TYPE)) { it.setReturnRef(it.target?.getLocation(it.getRef(0) as Location)) }
                .function("chunk", returns(FnChunk.TYPE).noParams()) { it.setReturnRef(it.target?.chunk) }
                .function("setBlockData", returnsVoid().params(FnBlockData.TYPE)) {
                    it.target?.setBlockData(it.getRef(0) as BlockData)
                }
                .function("setBlockData", returnsVoid().params(FnBlockData.TYPE, Type.Z)) {
                    it.target?.setBlockData(it.getRef(0) as BlockData, it.getBool(1))
                }
                .function("setType", returnsVoid().params(FnMaterial.TYPE)) {
                    it.target?.setType(it.getRef(0) as Material)
                }
                .function("setType", returnsVoid().params(Type.STRING)) {
                    FnMaterial.enumValue(it.getString(0))?.let { p0 -> it.target?.setType(p0) }
                }
                .function("setType", returnsVoid().params(FnMaterial.TYPE, Type.Z)) {
                    it.target?.setType(it.getRef(0) as Material, it.getBool(1))
                }
                .function("setType", returnsVoid().params(Type.STRING, Type.Z)) {
                    FnMaterial.enumValue(it.getString(0))?.let { p0 -> it.target?.setType(p0, it.getBool(1)) }
                }
                .function("getFace", returns(FnBlockFace.TYPE).params(FnBlock.TYPE)) { it.setReturnRef(it.target?.getFace(it.getRef(0) as Block)) }
                .function("state", returns(FnBlockState.TYPE).noParams()) { it.setReturnRef(it.target?.state) }
                .function("biome", returns(FnBiome.TYPE).noParams()) { it.setReturnRef(it.target?.biome) }
                .function("setBiome", returnsVoid().params(FnBiome.TYPE)) { it.target?.setBiome(it.getRef(0) as Biome) }
                .function("setBiome", returnsVoid().params(Type.STRING)) { FnBiome.enumValue(it.getString(0))?.let { p0 -> it.target?.setBiome(p0) } }
                .function("isBlockPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBlockPowered ?: false) }
                .function("isBlockIndirectlyPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBlockIndirectlyPowered ?: false) }
                .function("isBlockFacePowered", returns(Type.Z).params(FnBlockFace.TYPE)) {
                    it.setReturnBool(it.target?.isBlockFacePowered(it.getRef(0) as BlockFace) ?: false)
                }
                .function("isBlockFacePowered", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(FnBlockFace.enumValue(it.getString(0))?.let { p0 -> it.target?.isBlockFacePowered(p0) }
                        ?: false)
                }
                .function("isBlockFaceIndirectlyPowered", returns(Type.Z).params(FnBlockFace.TYPE)) {
                    it.setReturnBool(it.target?.isBlockFaceIndirectlyPowered(it.getRef(0) as BlockFace) ?: false)
                }
                .function("isBlockFaceIndirectlyPowered", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(FnBlockFace.enumValue(it.getString(0))?.let { p0 -> it.target?.isBlockFaceIndirectlyPowered(p0) }
                        ?: false)
                }
                .function("blockPower", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blockPower ?: 0) }
                .function("getBlockPower", returns(Type.I).params(FnBlockFace.TYPE)) {
                    it.setReturnInt(it.target?.getBlockPower(it.getRef(0) as BlockFace) ?: 0)
                }
                .function("getBlockPower", returns(Type.I).params(Type.STRING)) {
                    it.setReturnInt(FnBlockFace.enumValue(it.getString(0))?.let { p0 -> it.target?.getBlockPower(p0) }
                        ?: 0)
                }
                .function("isEmpty", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEmpty ?: false) }
                .function("isLiquid", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLiquid ?: false) }
                .function("temperature", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.temperature ?: 0.0) }
                .function("humidity", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.humidity ?: 0.0) }
                .function("pistonMoveReaction", returns(FnPistonMoveReaction.TYPE).noParams()) { it.setReturnRef(it.target?.pistonMoveReaction) }
                .function("breakNaturally", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.breakNaturally() ?: false)
                }
                .function("breakNaturally", returns(Type.Z).params(FnItemStack.TYPE)) {
                    it.setReturnBool(it.target?.breakNaturally(it.getRef(0) as ItemStack) ?: false)
                }
                .function("applyBoneMeal", returns(Type.Z).params(FnBlockFace.TYPE)) {
                    it.setReturnBool(it.target?.applyBoneMeal(it.getRef(0) as BlockFace) ?: false)
                }
                .function("applyBoneMeal", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(FnBlockFace.enumValue(it.getString(0))?.let { p0 -> it.target?.applyBoneMeal(p0) }
                        ?: false)
                }
                .function("drops", returns(StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.drops) }
                .function("getDrops", returns(StandardTypes.COLLECTION).params(FnItemStack.TYPE)) {
                    it.setReturnRef(it.target?.getDrops(it.getRef(0) as ItemStack))
                }
                .function("getDrops", returns(StandardTypes.COLLECTION).params(FnItemStack.TYPE, FnEntity.TYPE)) {
                    it.setReturnRef(it.target?.getDrops(
                        it.getRef(0) as ItemStack,
                        it.getRef(1) as Entity
                    ))
                }
                .function("isPreferredTool", returns(Type.Z).params(FnItemStack.TYPE)) {
                    it.setReturnBool(it.target?.isPreferredTool(it.getRef(0) as ItemStack) ?: false)
                }
                .function("getBreakSpeed", returns(Type.F).params(FnPlayer.TYPE)) {
                    it.setReturnFloat(it.target?.getBreakSpeed(it.getRef(0) as Player) ?: 0.0f)
                }
                .function("isPassable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPassable ?: false) }
                .function("rayTrace", returns(FnRayTraceResult.TYPE).params(FnLocation.TYPE, FnVector.TYPE, Type.D,
                    FnFluidCollisionMode.TYPE)) {
                    it.setReturnRef(it.target?.rayTrace(
                        it.getRef(0) as Location,
                        it.getRef(1) as Vector,
                        it.getDouble(2),
                        it.getRef(3) as FluidCollisionMode
                    ))
                }
                .function("rayTrace", returns(FnRayTraceResult.TYPE).params(FnLocation.TYPE, FnVector.TYPE, Type.D,
                    Type.STRING)) {
                    FnFluidCollisionMode.enumValue(it.getString(3))?.let { p3 ->
                        it.setReturnRef(it.target?.rayTrace(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getDouble(2),
                            p3
                        ))
                    }
                }
                .function("boundingBox", returns(FnBoundingBox.TYPE).noParams()) { it.setReturnRef(it.target?.boundingBox) }
                .function("collisionShape", returns(FnVoxelShape.TYPE).noParams()) { it.setReturnRef(it.target?.collisionShape) }
                .function("canPlace", returns(Type.Z).params(FnBlockData.TYPE)) {
                    it.setReturnBool(it.target?.canPlace(it.getRef(0) as BlockData) ?: false)
                }
        }
    }
}
