package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.ChunkSnapshot
import org.bukkit.block.Biome
import org.bukkit.block.data.BlockData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
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
                .function("biome", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.getBiome(it.getNumber(0).toInt(), it.getNumber(1).toInt())
                    } else {
                        it.target?.getBiome(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                .function("rawBiomeTemperature", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.getRawBiomeTemperature(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt()
                        )
                    } else {
                        it.target?.getRawBiomeTemperature(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                .function("captureFullTime", 0) { it.target?.captureFullTime }
                .function("isSectionEmpty", 1) { it.target?.isSectionEmpty(it.getNumber(0).toInt()) }
                .function("contains", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is BlockData -> it.target?.contains(var1)
                        is Biome -> it.target?.contains(var1)
                        else -> throw IllegalArgumentException("参数必须是 BlockData 或 Biome 类型")
                    }
                }
        }
    }
}
