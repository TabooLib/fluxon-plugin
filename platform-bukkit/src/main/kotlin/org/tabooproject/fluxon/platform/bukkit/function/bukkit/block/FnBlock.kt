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


@Requires(classes = ["org.bukkit.block.Block"])
@PlatformSide(Platform.BUKKIT)
object FnBlock {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Block::class.java)
                .function("data", 0) { it.target?.data }
                .function("blockData", 0) { it.target?.blockData }
                .function("getRelative", listOf(1, 2, 3)) {
                    when (it.arguments.size) {
                        1 -> it.target?.getRelative(it.getArgument(0) as BlockFace)
                        2 -> it.target?.getRelative(
                            it.getArgument(0) as BlockFace,
                            it.getNumber(1).toInt()
                        )
                        3 -> it.target?.getRelative(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                        else -> error("Block#relative 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("type", 0) { it.target?.type }
                .function("lightLevel", 0) { it.target?.lightLevel }
                .function("lightFromSky", 0) { it.target?.lightFromSky }
                .function("lightFromBlocks", 0) { it.target?.lightFromBlocks }
                .function("world", 0) { it.target?.world }
                .function("x", 0) { it.target?.x }
                .function("y", 0) { it.target?.y }
                .function("z", 0) { it.target?.z }
                .function("location", 0) { it.target?.location }
                .function("getLocation", 1) { it.target?.getLocation(it.getArgument(0) as Location) }
                .function("chunk", 0) { it.target?.chunk }
                .function("setBlockData", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setBlockData(it.getArgument(0) as BlockData)
                    } else {
                        it.target?.setBlockData(
                            it.getArgument(0) as BlockData,
                            it.getBoolean(1)
                        )
                    }
                }
                .function("setType", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setType(it.getArgument(0) as Material)
                    } else {
                        it.target?.setType(it.getArgument(0) as Material, it.getBoolean(1))
                    }
                }
                .function("getFace", 1) { it.target?.getFace(it.getArgument(0) as Block) }
                .function("state", 0) { it.target?.state }
                .function("biome", 0) { it.target?.biome }
                .function("setBiome", 1) { it.target?.setBiome(it.getArgument(0) as Biome) }
                .function("isBlockPowered", 0) { it.target?.isBlockPowered }
                .function("isBlockIndirectlyPowered", 0) { it.target?.isBlockIndirectlyPowered }
                .function("isBlockFacePowered", 1) { it.target?.isBlockFacePowered(it.getArgument(0) as BlockFace) }
                .function(
                    "isBlockFaceIndirectlyPowered",
                    1
                ) { it.target?.isBlockFaceIndirectlyPowered(it.getArgument(0) as BlockFace) }
                .function("blockPower", 0) { it.target?.blockPower }
                .function("getBlockPower", 1) { it.target?.getBlockPower(it.getArgument(0) as BlockFace) }
                .function("isEmpty", 0) { it.target?.isEmpty }
                .function("isLiquid", 0) { it.target?.isLiquid }
                .function("temperature", 0) { it.target?.temperature }
                .function("humidity", 0) { it.target?.humidity }
                .function("pistonMoveReaction", 0) { it.target?.pistonMoveReaction }
                .function("breakNaturally", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.breakNaturally()
                    } else {
                        it.target?.breakNaturally(it.getArgument(0) as ItemStack)
                    }
                }
                .function("applyBoneMeal", 1) { it.target?.applyBoneMeal(it.getArgument(0) as BlockFace) }
                .function("drops", 0) { it.target?.drops }
                .function("getDrops", listOf(1, 2)) {
                    when (it.arguments.size) {
                        1 -> it.target?.getDrops(it.getArgument(0) as ItemStack)
                        2 -> it.target?.getDrops(
                            it.getArgument(0) as ItemStack,
                            it.getArgument(1) as Entity
                        )
                        else -> error("Block#getDrops 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("isPreferredTool", 1) { it.target?.isPreferredTool(it.getArgument(0) as ItemStack) }
                .function("getBreakSpeed", 1) { it.target?.getBreakSpeed(it.getArgument(0) as Player) }
                .function("isPassable", 0) { it.target?.isPassable }
                .function("rayTrace", 4) {
                    it.target?.rayTrace(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Vector,
                        it.getNumber(2).toDouble(),
                        it.getArgument(3) as FluidCollisionMode
                    )
                }
                .function("boundingBox", 0) { it.target?.boundingBox }
                .function("collisionShape", 0) { it.target?.collisionShape }
                .function("canPlace", 1) { it.target?.canPlace(it.getArgument(0) as BlockData) }
        }
    }
}
