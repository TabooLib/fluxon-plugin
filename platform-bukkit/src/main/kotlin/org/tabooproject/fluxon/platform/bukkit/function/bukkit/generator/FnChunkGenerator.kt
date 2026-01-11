package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator

import org.bukkit.HeightMap
import org.bukkit.World
import org.bukkit.block.Biome
import org.bukkit.generator.ChunkGenerator
import org.bukkit.generator.WorldInfo
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*

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
                .function("shouldGenerateNoise", 0) { it.target?.shouldGenerateNoise() }
                .function("shouldGenerateNoise", 4) {
                    it.target?.shouldGenerateNoise(
                        it.getArgument(0) as WorldInfo,
                        it.getArgument(1) as Random,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt()
                    )
                }
                .function("shouldGenerateSurface", 0) { it.target?.shouldGenerateSurface() }
                .function("shouldGenerateSurface", 4) {
                    it.target?.shouldGenerateSurface(
                        it.getArgument(0) as WorldInfo,
                        it.getArgument(1) as Random,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt()
                    )
                }
                .function("shouldGenerateBedrock", 0) { it.target?.shouldGenerateBedrock() }
                .function("shouldGenerateCaves", 0) { it.target?.shouldGenerateCaves() }
                .function("shouldGenerateCaves", 4) {
                    it.target?.shouldGenerateCaves(
                        it.getArgument(0) as WorldInfo,
                        it.getArgument(1) as Random,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt()
                    )
                }
                .function("shouldGenerateDecorations", 0) { it.target?.shouldGenerateDecorations() }
                .function(
                    "shouldGenerateDecorations",
                    4
                ) {
                    it.target?.shouldGenerateDecorations(
                        it.getArgument(0) as WorldInfo,
                        it.getArgument(1) as Random,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt()
                    )
                }
                .function("shouldGenerateMobs", 0) { it.target?.shouldGenerateMobs() }
                .function("shouldGenerateMobs", 4) {
                    it.target?.shouldGenerateMobs(
                        it.getArgument(0) as WorldInfo,
                        it.getArgument(1) as Random,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt()
                    )
                }
                .function("shouldGenerateStructures", 0) { it.target?.shouldGenerateStructures() }
                .function(
                    "shouldGenerateStructures",
                    4
                ) {
                    it.target?.shouldGenerateStructures(
                        it.getArgument(0) as WorldInfo,
                        it.getArgument(1) as Random,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt()
                    )
                }

            registerExtension(ChunkGenerator.ChunkData::class.java)
                .function("minHeight", 0) { it.target?.minHeight }
                .function("maxHeight", 0) { it.target?.maxHeight }
                .function("biome", 3) {
                    // Biome getBiome(int var1, int var2, int var3)
                    // Biome getBiome(int var1, int var2, int var3)
                    TODO()
                }
                .function("setBlock", 4) {
                    // void setBlock(int var1, int var2, int var3, @NotNull Material var4)
                    // void setBlock(int var1, int var2, int var3, @NotNull MaterialData var4)
                    // void setBlock(int var1, int var2, int var3, @NotNull BlockData var4)
                    TODO()
                }
                .function("setRegion", 7) {
                    // void setRegion(int var1, int var2, int var3, int var4, int var5, int var6, @NotNull Material var7)
                    // void setRegion(int var1, int var2, int var3, int var4, int var5, int var6, @NotNull MaterialData var7)
                    // void setRegion(int var1, int var2, int var3, int var4, int var5, int var6, @NotNull BlockData var7)
                    TODO()
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
                .function("setBiome", 3) {
                    it.target?.setBiome(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getArgument(2) as Biome
                    )
                }
                .function("setBiome", 4) {
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
