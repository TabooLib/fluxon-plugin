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
                .function("biome", 1) { it.target?.getBiome(it.getArgument(0) as Location) }
                .function("biome", 3) {
                    it.target?.getBiome(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("setBiome", 2) {
                    it.target?.setBiome(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Biome
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
                .function("blockState", 1) { it.target?.getBlockState(it.getArgument(0) as Location) }
                .function("blockState", 3) {
                    it.target?.getBlockState(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("blockData", 1) { it.target?.getBlockData(it.getArgument(0) as Location) }
                .function("blockData", 3) {
                    it.target?.getBlockData(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("type", 1) { it.target?.getType(it.getArgument(0) as Location) }
                .function("type", 3) {
                    it.target?.getType(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("setBlockData", 2) {
                    it.target?.setBlockData(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as BlockData
                    )
                }
                .function("setBlockData", 4) {
                    it.target?.setBlockData(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt(),
                        it.getArgument(3) as BlockData
                    )
                }
                .function("setType", 2) {
                    it.target?.setType(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Material
                    )
                }
                .function("setType", 4) {
                    it.target?.setType(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt(),
                        it.getArgument(3) as Material
                    )
                }
                .function("generateTree", 3) {
                    // boolean generateTree(@NotNull Location var1, @NotNull Random var2, @NotNull TreeType var3)
                    // boolean generateTree(@NotNull Location var1, @NotNull Random var2, @NotNull TreeType var3, @Nullable Consumer<? super BlockState> var4)
                    // boolean generateTree(@NotNull Location var1, @NotNull Random var2, @NotNull TreeType var3, @Nullable Predicate<? super BlockState> var4)
                    TODO()
                }
                .function("spawnEntity", 2) {
                    it.target?.spawnEntity(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as EntityType
                    )
                }
                .function("spawnEntity", 3) {
                    it.target?.spawnEntity(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as EntityType,
                        it.getBoolean(2)
                    )
                }
                .function("entities", 0) { it.target?.entities }
                .function("livingEntities", 0) { it.target?.livingEntities }
                .function("entitiesByClasses", 0) { it.target?.getEntitiesByClasses() }
                .function("highestBlockYAt", 2) {
                    // int getHighestBlockYAt(int var1, int var2)
                    // int getHighestBlockYAt(@NotNull Location var1, @NotNull HeightMap var2)
                    TODO()
                }
                .function("highestBlockYAt", 1) { it.target?.getHighestBlockYAt(it.getArgument(0) as Location) }
                .function("highestBlockYAt", 3) {
                    it.target?.getHighestBlockYAt(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getArgument(2) as HeightMap
                    )
                }
        }
    }
}
