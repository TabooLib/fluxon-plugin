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

object FnBlock {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Block::class.java)
                // 橙汁喵: 自定义语法, 这个语法并不在Bukkit中存在
                .function("locationX", 0) { it.target?.x }
                // 橙汁喵: 自定义语法, 这个语法并不在Bukkit中存在
                .function("locationY", 0) { it.target?.y }
                // 橙汁喵: 自定义语法, 这个语法并不在Bukkit中存在
                .function("locationZ", 0) { it.target?.z }
                // 橙汁喵: 自定义语法, 这个语法并不在Bukkit中存在
                .function("worldName", 0) { it.target?.world?.name }
                .function("data", 0) { it.target?.data }
                .function("blockData", 0) { it.target?.blockData }
                .function("relative", 3) {
                    it.target?.getRelative(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("relative", 1) { it.target?.getRelative(it.getArgument(0) as BlockFace) }
                .function("relative", 2) {
                    it.target?.getRelative(
                        it.getArgument(0) as BlockFace,
                        it.getNumber(1).toInt()
                    )
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
                .function("location", 1) { it.target?.getLocation(it.getArgument(0) as Location) }
                .function("chunk", 0) { it.target?.chunk }
                .function("setBlockData", 1) { it.target?.setBlockData(it.getArgument(0) as BlockData) }
                .function("setBlockData", 2) {
                    it.target?.setBlockData(
                        it.getArgument(0) as BlockData,
                        it.getBoolean(1)
                    )
                }
                .function("setType", 1) { it.target?.setType(it.getArgument(0) as Material) }
                .function("setType", 2) { it.target?.setType(it.getArgument(0) as Material, it.getBoolean(1)) }
                .function("face", 1) { it.target?.getFace(it.getArgument(0) as Block) }
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
                .function("blockPower", 1) { it.target?.getBlockPower(it.getArgument(0) as BlockFace) }
                .function("blockPower", 0) { it.target?.blockPower }
                .function("isEmpty", 0) { it.target?.isEmpty }
                .function("isLiquid", 0) { it.target?.isLiquid }
                .function("temperature", 0) { it.target?.temperature }
                .function("humidity", 0) { it.target?.humidity }
                .function("pistonMoveReaction", 0) { it.target?.pistonMoveReaction }
                .function("breakNaturally", 0) { it.target?.breakNaturally() }
                .function("breakNaturally", 1) { it.target?.breakNaturally(it.getArgument(0) as ItemStack) }
                .function("applyBoneMeal", 1) { it.target?.applyBoneMeal(it.getArgument(0) as BlockFace) }
                .function("drops", 0) { it.target?.drops }
                .function("drops", 1) { it.target?.getDrops(it.getArgument(0) as ItemStack) }
                .function("drops", 2) {
                    it.target?.getDrops(
                        it.getArgument(0) as ItemStack,
                        it.getArgument(1) as Entity
                    )
                }
                .function("isPreferredTool", 1) { it.target?.isPreferredTool(it.getArgument(0) as ItemStack) }
                .function("breakSpeed", 1) { it.target?.getBreakSpeed(it.getArgument(0) as Player) }
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
