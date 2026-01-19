package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.HeightMap
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.RegionAccessor
import org.bukkit.block.Biome
import org.bukkit.block.data.BlockData
import org.bukkit.entity.EntityType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnRegionAccessor {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RegionAccessor::class.java)
                .syncFunction("biome", 1) { it.target?.getBiome(it.getArgument(0) as Location) }
                .syncFunction("biome", 3) {
                    it.target?.getBiome(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .syncFunction("setBiome", 2) {
                    it.target?.setBiome(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Biome
                    )
                }
                .syncFunction("setBiome", 4) {
                    it.target?.setBiome(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt(),
                        it.getArgument(3) as Biome
                    )
                }
                .syncFunction("blockState", 1) { it.target?.getBlockState(it.getArgument(0) as Location) }
                .syncFunction("blockState", 3) {
                    it.target?.getBlockState(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .syncFunction("blockData", 1) { it.target?.getBlockData(it.getArgument(0) as Location) }
                .syncFunction("blockData", 3) {
                    it.target?.getBlockData(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .syncFunction("type", 1) { it.target?.getType(it.getArgument(0) as Location) }
                .syncFunction("type", 3) {
                    it.target?.getType(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .syncFunction("setBlockData", 2) {
                    it.target?.setBlockData(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as BlockData
                    )
                }
                .syncFunction("setBlockData", 4) {
                    it.target?.setBlockData(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt(),
                        it.getArgument(3) as BlockData
                    )
                }
                .syncFunction("setType", 2) {
                    it.target?.setType(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Material
                    )
                }
                .syncFunction("setType", 4) {
                    it.target?.setType(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt(),
                        it.getArgument(3) as Material
                    )
                }
                .syncFunction("generateTree", 3) {
                    it.target?.generateTree(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as java.util.Random,
                        it.getArgument(2) as org.bukkit.TreeType
                    )
                }
                .syncFunction("spawnEntity", 2) {
                    it.target?.spawnEntity(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as EntityType
                    )
                }
                .syncFunction("spawnEntity", 3) {
                    it.target?.spawnEntity(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as EntityType,
                        it.getBoolean(2)
                    )
                }
                .syncFunction("entities", 0) { it.target?.entities }
                .syncFunction("livingEntities", 0) { it.target?.livingEntities }
                .syncFunction("entitiesByClasses", 0) { it.target?.getEntitiesByClasses() }
                .syncFunction("highestBlockYAt", 2) {
                    when (val var1 = it.getArgument(0)) {
                        is Int -> it.target?.getHighestBlockYAt(var1, it.getNumber(1).toInt())
                        is Location -> it.target?.getHighestBlockYAt(var1, it.getArgument(1) as HeightMap)
                        else -> throw IllegalArgumentException("参数1必须是 Int 或 Location 类型")
                    }
                }
                .syncFunction("highestBlockYAt", 1) { it.target?.getHighestBlockYAt(it.getArgument(0) as Location) }
                .syncFunction("highestBlockYAt", 3) {
                    it.target?.getHighestBlockYAt(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getArgument(2) as HeightMap
                    )
                }
        }
    }
}
