package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator

import org.bukkit.HeightMap
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Biome
import org.bukkit.block.data.BlockData
import org.bukkit.generator.ChunkGenerator
import org.bukkit.generator.WorldInfo
import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnChunkGenerator {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChunkGenerator::class.java)
                .function("generateNoise", 5) {
                    it.target?.generateNoise(
                        it.getArgument(0) as WorldInfo,
                        it.getArgument(1) as Random,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt(),
                        it.getArgument(4) as ChunkGenerator.ChunkData
                    )
                }
                .function("generateSurface", 5) {
                    it.target?.generateSurface(
                        it.getArgument(0) as WorldInfo,
                        it.getArgument(1) as Random,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt(),
                        it.getArgument(4) as ChunkGenerator.ChunkData
                    )
                }
                .function("generateBedrock", 5) {
                    it.target?.generateBedrock(
                        it.getArgument(0) as WorldInfo,
                        it.getArgument(1) as Random,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt(),
                        it.getArgument(4) as ChunkGenerator.ChunkData
                    )
                }
                .function("generateCaves", 5) {
                    it.target?.generateCaves(
                        it.getArgument(0) as WorldInfo,
                        it.getArgument(1) as Random,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt(),
                        it.getArgument(4) as ChunkGenerator.ChunkData
                    )
                }
                .function(
                    "defaultBiomeProvider",
                    1
                ) { it.target?.getDefaultBiomeProvider(it.getArgument(0) as WorldInfo) }
                .function("baseHeight", 5) {
                    it.target?.getBaseHeight(
                        it.getArgument(0) as WorldInfo,
                        it.getArgument(1) as Random,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt(),
                        it.getArgument(4) as HeightMap
                    )
                }
                .function("generateChunkData", 5) {
                    it.target?.generateChunkData(
                        it.getArgument(0) as World,
                        it.getArgument(1) as Random,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt(),
                        it.getArgument(4) as ChunkGenerator.BiomeGrid
                    )
                }
                .function("canSpawn", 3) {
                    it.target?.canSpawn(
                        it.getArgument(0) as World,
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("defaultPopulators", 1) { it.target?.getDefaultPopulators(it.getArgument(0) as World) }
                .function("fixedSpawnLocation", 2) {
                    it.target?.getFixedSpawnLocation(
                        it.getArgument(0) as World,
                        it.getArgument(1) as Random
                    )
                }
                .function("isParallelCapable", 0) { it.target?.isParallelCapable }
                .function("shouldGenerateNoise", listOf(0, 4)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.shouldGenerateNoise()
                    } else {
                        it.target?.shouldGenerateNoise(
                            it.getArgument(0) as WorldInfo,
                            it.getArgument(1) as Random,
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt()
                        )
                    }
                }
                .function("shouldGenerateSurface", listOf(0, 4)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.shouldGenerateSurface()
                    } else {
                        it.target?.shouldGenerateSurface(
                            it.getArgument(0) as WorldInfo,
                            it.getArgument(1) as Random,
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt()
                        )
                    }
                }
                .function("shouldGenerateBedrock", 0) { it.target?.shouldGenerateBedrock() }
                .function("shouldGenerateCaves", listOf(0, 4)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.shouldGenerateCaves()
                    } else {
                        it.target?.shouldGenerateCaves(
                            it.getArgument(0) as WorldInfo,
                            it.getArgument(1) as Random,
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt()
                        )
                    }
                }
                .function("shouldGenerateDecorations", listOf(0, 4)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.shouldGenerateDecorations()
                    } else {
                        it.target?.shouldGenerateDecorations(
                            it.getArgument(0) as WorldInfo,
                            it.getArgument(1) as Random,
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt()
                        )
                    }
                }
                .function("shouldGenerateMobs", listOf(0, 4)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.shouldGenerateMobs()
                    } else {
                        it.target?.shouldGenerateMobs(
                            it.getArgument(0) as WorldInfo,
                            it.getArgument(1) as Random,
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt()
                        )
                    }
                }
                .function("shouldGenerateStructures", listOf(0, 4)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.shouldGenerateStructures()
                    } else {
                        it.target?.shouldGenerateStructures(
                            it.getArgument(0) as WorldInfo,
                            it.getArgument(1) as Random,
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt()
                        )
                    }
                }

            registerExtension(ChunkGenerator.ChunkData::class.java)
                .function("minHeight", 0) { it.target?.minHeight }
                .function("maxHeight", 0) { it.target?.maxHeight }
                .function("biome", 3) {
                    it.target?.getBiome(it.getNumber(0).toInt(), it.getNumber(1).toInt(), it.getNumber(2).toInt())
                }
                .function("setBlock", 4) {
                    when (val var4 = it.getArgument(3)) {
                        is Material -> it.target?.setBlock(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            var4
                        )

                        is MaterialData -> it.target?.setBlock(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            var4
                        )

                        is BlockData -> it.target?.setBlock(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            var4
                        )

                        else -> throw IllegalArgumentException("参数4必须是 Material, MaterialData, 或 BlockData 类型")
                    }
                }
                .function("setRegion", 7) {
                    when (val var7 = it.getArgument(6)) {
                        is Material -> it.target?.setRegion(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt(),
                            it.getNumber(4).toInt(),
                            it.getNumber(5).toInt(),
                            var7
                        )

                        is MaterialData -> it.target?.setRegion(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt(),
                            it.getNumber(4).toInt(),
                            it.getNumber(5).toInt(),
                            var7
                        )

                        is BlockData -> it.target?.setRegion(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt(),
                            it.getNumber(4).toInt(),
                            it.getNumber(5).toInt(),
                            var7
                        )

                        else -> throw IllegalArgumentException("参数7必须是 Material, MaterialData, 或 BlockData 类型")
                    }
                }
                .function("type", 3) {
                    it.target?.getType(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("typeAndData", 3) {
                    it.target?.getTypeAndData(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("blockData", 3) {
                    it.target?.getBlockData(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("data", 3) {
                    it.target?.getData(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }

            registerExtension(ChunkGenerator.BiomeGrid::class.java)
                .function("biome", 2) { it.target?.getBiome(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .function("setBiome", listOf(3, 4)) {
                    if (it.arguments.size == 3) {
                        it.target?.setBiome(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getArgument(2) as Biome
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
        }
    }
}
