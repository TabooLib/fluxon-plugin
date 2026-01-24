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
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnRegionAccessor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RegionAccessor::class.java)
                .function("getBiome", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        it.target?.getBiome(it.getArgument(0) as Location)
                    } else {
                        it.target?.getBiome(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                .syncFunction("setBiome", listOf(2, 4)) {
                    if (it.arguments.size == 2) {
                        it.target?.setBiome(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Biome
                        )
                    } else {
                        it.target?.setBiome(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            it.getArgument(3) as Biome
                        )
                    }
                }
                .function("getBlockState", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        it.target?.getBlockState(it.getArgument(0) as Location)
                    } else {
                        it.target?.getBlockState(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                .function("getBlockData", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        it.target?.getBlockData(it.getArgument(0) as Location)
                    } else {
                        it.target?.getBlockData(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                .function("getType", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        it.target?.getType(it.getArgument(0) as Location)
                    } else {
                        it.target?.getType(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                .syncFunction("setBlockData", listOf(2, 4)) {
                    if (it.arguments.size == 2) {
                        it.target?.setBlockData(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as BlockData
                        )
                    } else {
                        it.target?.setBlockData(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            it.getArgument(3) as BlockData
                        )
                    }
                }
                .syncFunction("setType", listOf(2, 4)) {
                    if (it.arguments.size == 2) {
                        it.target?.setType(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Material
                        )
                    } else {
                        it.target?.setType(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            it.getArgument(3) as Material
                        )
                    }
                }
                .syncFunction("generateTree", 3) {
                    it.target?.generateTree(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as java.util.Random,
                        it.getArgument(2) as org.bukkit.TreeType
                    )
                }
                .syncFunction("spawnEntity", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.spawnEntity(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as EntityType
                        )
                    } else {
                        it.target?.spawnEntity(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as EntityType,
                            it.getBoolean(2)
                        )
                    }
                }
                .function("entities", 0) { it.target?.entities }
                .function("livingEntities", 0) { it.target?.livingEntities }
                .function("entitiesByClasses", 0) { it.target?.getEntitiesByClasses() }
                .function("getHighestBlockYAt", listOf(1, 2, 3)) {
                    when (it.arguments.size) {
                        1 -> it.target?.getHighestBlockYAt(it.getArgument(0) as Location)
                        2 -> when (val var1 = it.getArgument(0)) {
                            is Int -> it.target?.getHighestBlockYAt(var1, it.getNumber(1).toInt())
                            is Location -> it.target?.getHighestBlockYAt(var1, it.getArgument(1) as HeightMap)
                            else -> throw IllegalArgumentException("参数 1 必须是 Int 或 Location 类型")
                        }

                        3 -> it.target?.getHighestBlockYAt(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getArgument(2) as HeightMap
                        )
                        else -> error("RegionAccessor#highestBlockYAt 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
        }
    }
}
