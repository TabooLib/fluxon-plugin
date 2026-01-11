package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.ChunkSnapshot
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnChunkSnapshot {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChunkSnapshot::class.java)
                .function("x", 0) { it.target?.x }
                .function("z", 0) { it.target?.z }
                .function("worldName", 0) { it.target?.worldName }
                .function("blockType", 3) {
                    it.target?.getBlockType(
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
                .function("blockSkyLight", 3) {
                    it.target?.getBlockSkyLight(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("blockEmittedLight", 3) {
                    it.target?.getBlockEmittedLight(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("highestBlockYAt", 2) {
                    it.target?.getHighestBlockYAt(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("biome", 2) { it.target?.getBiome(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .function("biome", 3) {
                    it.target?.getBiome(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("rawBiomeTemperature", 2) {
                    it.target?.getRawBiomeTemperature(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("rawBiomeTemperature", 3) {
                    it.target?.getRawBiomeTemperature(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("captureFullTime", 0) { it.target?.captureFullTime }
                .function("isSectionEmpty", 1) { it.target?.isSectionEmpty(it.getNumber(0).toInt()) }
                .function("contains", 1) {
                    // boolean contains(@NotNull BlockData var1)
                    // boolean contains(@NotNull Biome var1)
                    TODO()
                }
        }
    }
}
