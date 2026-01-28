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
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.block.Block"])
@PlatformSide(Platform.BUKKIT)
object FnBlock {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Block::class.java)
                .function("data", returnsObject().noParams()) { it.target?.data }
                .function("blockData", returnsObject().noParams()) { it.target?.blockData }
                .function("getRelative", returnsObject().params(Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.getRelative(it.getRef(0) as BlockFace)
                        2 -> it.target?.getRelative(
                            it.getRef(0) as BlockFace,
                            it.getInt(1).toInt()
                        )
                        3 -> it.target?.getRelative(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                        else -> error("Block#relative 函数参数数量错误: ${"args"}")
                    }
                }
                .function("getRelative", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.getRelative(it.getRef(0) as BlockFace)
                        2 -> it.target?.getRelative(
                            it.getRef(0) as BlockFace,
                            it.getInt(1).toInt()
                        )
                        3 -> it.target?.getRelative(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                        else -> error("Block#relative 函数参数数量错误: ${"args"}")
                    }
                }
                .function("getRelative", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.getRelative(it.getRef(0) as BlockFace)
                        2 -> it.target?.getRelative(
                            it.getRef(0) as BlockFace,
                            it.getInt(1).toInt()
                        )
                        3 -> it.target?.getRelative(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                        else -> error("Block#relative 函数参数数量错误: ${"args"}")
                    }
                }
                .function("type", returnsObject().noParams()) { it.target?.type }
                .function("lightLevel", returnsObject().noParams()) { it.target?.lightLevel }
                .function("lightFromSky", returnsObject().noParams()) { it.target?.lightFromSky }
                .function("lightFromBlocks", returnsObject().noParams()) { it.target?.lightFromBlocks }
                .function("world", returnsObject().noParams()) { it.target?.world }
                .function("x", returnsObject().noParams()) { it.target?.x }
                .function("y", returnsObject().noParams()) { it.target?.y }
                .function("z", returnsObject().noParams()) { it.target?.z }
                .function("location", returnsObject().noParams()) { it.target?.location }
                .function("getLocation", returnsObject().params(Type.OBJECT)) { it.target?.getLocation(it.getRef(0) as Location) }
                .function("chunk", returnsObject().noParams()) { it.target?.chunk }
                .function("setBlockData", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.setBlockData(it.getRef(0) as BlockData)
                    } else {
                        it.target?.setBlockData(
                            it.getRef(0) as BlockData,
                            it.getBool(1)
                        )
                    }
                }
                .function("setBlockData", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.setBlockData(it.getRef(0) as BlockData)
                    } else {
                        it.target?.setBlockData(
                            it.getRef(0) as BlockData,
                            it.getBool(1)
                        )
                    }
                }
                .function("setType", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.setType(it.getRef(0) as Material)
                    } else {
                        it.target?.setType(it.getRef(0) as Material, it.getBool(1))
                    }
                }
                .function("setType", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.setType(it.getRef(0) as Material)
                    } else {
                        it.target?.setType(it.getRef(0) as Material, it.getBool(1))
                    }
                }
                .function("getFace", returnsObject().params(Type.OBJECT)) { it.target?.getFace(it.getRef(0) as Block) }
                .function("state", returnsObject().noParams()) { it.target?.state }
                .function("biome", returnsObject().noParams()) { it.target?.biome }
                .function("setBiome", returnsObject().params(Type.OBJECT)) { it.target?.setBiome(it.getRef(0) as Biome) }
                .function("isBlockPowered", returns(Type.Z).noParams()) { it.target?.isBlockPowered }
                .function("isBlockIndirectlyPowered", returns(Type.Z).noParams()) { it.target?.isBlockIndirectlyPowered }
                .function("isBlockFacePowered", returns(Type.Z).params(Type.OBJECT)) { it.target?.isBlockFacePowered(it.getRef(0) as BlockFace) }
                .function("isBlockFaceIndirectlyPowered", returns(Type.Z).params(Type.OBJECT)) { it.target?.isBlockFaceIndirectlyPowered(it.getRef(0) as BlockFace) }
                .function("blockPower", returnsObject().noParams()) { it.target?.blockPower }
                .function("getBlockPower", returnsObject().params(Type.OBJECT)) { it.target?.getBlockPower(it.getRef(0) as BlockFace) }
                .function("isEmpty", returns(Type.Z).noParams()) { it.target?.isEmpty }
                .function("isLiquid", returns(Type.Z).noParams()) { it.target?.isLiquid }
                .function("temperature", returnsObject().noParams()) { it.target?.temperature }
                .function("humidity", returnsObject().noParams()) { it.target?.humidity }
                .function("pistonMoveReaction", returnsObject().noParams()) { it.target?.pistonMoveReaction }
                .function("breakNaturally", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.breakNaturally()
                    } else {
                        it.target?.breakNaturally(it.getRef(0) as ItemStack)
                    }
                }
                .function("breakNaturally", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.breakNaturally()
                    } else {
                        it.target?.breakNaturally(it.getRef(0) as ItemStack)
                    }
                }
                .function("applyBoneMeal", returnsObject().params(Type.OBJECT)) { it.target?.applyBoneMeal(it.getRef(0) as BlockFace) }
                .function("drops", returnsObject().noParams()) { it.target?.drops }
                .function("getDrops", returnsObject().params(Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.getDrops(it.getRef(0) as ItemStack)
                        2 -> it.target?.getDrops(
                            it.getRef(0) as ItemStack,
                            it.getRef(1) as Entity
                        )
                        else -> error("Block#getDrops 函数参数数量错误: ${"args"}")
                    }
                }
                .function("getDrops", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.getDrops(it.getRef(0) as ItemStack)
                        2 -> it.target?.getDrops(
                            it.getRef(0) as ItemStack,
                            it.getRef(1) as Entity
                        )
                        else -> error("Block#getDrops 函数参数数量错误: ${"args"}")
                    }
                }
                .function("isPreferredTool", returns(Type.Z).params(Type.OBJECT)) { it.target?.isPreferredTool(it.getRef(0) as ItemStack) }
                .function("getBreakSpeed", returnsObject().params(Type.OBJECT)) { it.target?.getBreakSpeed(it.getRef(0) as Player) }
                .function("isPassable", returns(Type.Z).noParams()) { it.target?.isPassable }
                .function("rayTrace", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.rayTrace(
                        it.getRef(0) as Location,
                        it.getRef(1) as Vector,
                        it.getAsDouble(2),
                        it.getRef(3) as FluidCollisionMode
                    )
                }
                .function("boundingBox", returnsObject().noParams()) { it.target?.boundingBox }
                .function("collisionShape", returnsObject().noParams()) { it.target?.collisionShape }
                .function("canPlace", returns(Type.Z).params(Type.OBJECT)) { it.target?.canPlace(it.getRef(0) as BlockData) }
        }
    }
}
