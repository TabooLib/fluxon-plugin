package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Material
import org.bukkit.block.Biome
import org.bukkit.block.Block
import org.bukkit.block.data.BlockData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlock {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Block::class.java)
                .function("type", 0) { it.target?.type }
                .function("location", 0) { it.target?.location }
                .function("locationX", 0) { it.target?.x }
                .function("locationY", 0) { it.target?.y }
                .function("locationZ", 0) { it.target?.z }
                .function("world*", 0) { it.target?.world }
                .function("worldName", 0) { it.target?.world?.name }
                .function("isEmpty", 0) { it.target?.isEmpty }
                .function("isLiquid", 0) { it.target?.isLiquid }
                .function("isPassable", 0) { it.target?.isPassable }
                .function("biome", 0) { it.target?.biome }
                .syncFunction("setBiome", 1) { it.target?.apply { biome = it.getArgument(0) as Biome } }
                .function("drops", 0) { it.target?.drops }
                .function("lightLevel", 0) { it.target?.lightLevel }
                .function("lightFromSky", 0) { it.target?.lightFromSky }
                .function("lightFromBlocks", 0) { it.target?.lightFromBlocks }
                .function("blockData", 0) { it.target?.blockData }
                .syncFunction("setType", 1) { it.target?.apply { type = it.getArgument(0) as Material } }
                .syncFunction("setBlockData", 1) { it.target?.apply { blockData = it.getArgument(0) as BlockData } }
        }
    }
}
