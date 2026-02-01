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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.generator.ChunkGenerator"])
@PlatformSide(Platform.BUKKIT)
object FnChunkGenerator {

    val TYPE = Type.fromClass(ChunkGenerator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChunkGenerator::class.java)
                .function("generateNoise", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I, Type.I, Type.OBJECT)) {
                    it.target?.generateNoise(
                        it.getRef(0) as WorldInfo,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt(),
                        it.getRef(4) as ChunkGenerator.ChunkData
                    )
                }
                .function("generateSurface", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I, Type.I, Type.OBJECT)) {
                    it.target?.generateSurface(
                        it.getRef(0) as WorldInfo,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt(),
                        it.getRef(4) as ChunkGenerator.ChunkData
                    )
                }
                .function("generateBedrock", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I, Type.I, Type.OBJECT)) {
                    it.target?.generateBedrock(
                        it.getRef(0) as WorldInfo,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt(),
                        it.getRef(4) as ChunkGenerator.ChunkData
                    )
                }
                .function("generateCaves", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I, Type.I, Type.OBJECT)) {
                    it.target?.generateCaves(
                        it.getRef(0) as WorldInfo,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt(),
                        it.getRef(4) as ChunkGenerator.ChunkData
                    )
                }
                .function("getDefaultBiomeProvider", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getDefaultBiomeProvider(it.getRef(0) as WorldInfo)) }
                .function("getBaseHeight", returns(Type.I).params(Type.OBJECT, Type.OBJECT, Type.I, Type.I, Type.OBJECT)) {
                    it.setReturnInt(it.target?.getBaseHeight(
                        it.getRef(0) as WorldInfo,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt(),
                        it.getRef(4) as HeightMap
                    ) ?: 0)
                }
                .function("generateChunkData", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.I, Type.I, Type.OBJECT)) {
                    it.setReturnRef(it.target?.generateChunkData(
                        it.getRef(0) as World,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt(),
                        it.getRef(4) as ChunkGenerator.BiomeGrid
                    ))
                }
                .function("canSpawn", returns(Type.Z).params(Type.OBJECT, Type.I, Type.I)) {
                    it.setReturnBool(it.target?.canSpawn(
                        it.getRef(0) as World,
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ) ?: false)
                }
                .function("getDefaultPopulators", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getDefaultPopulators(it.getRef(0) as World)) }
                .function("getFixedSpawnLocation", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getFixedSpawnLocation(
                        it.getRef(0) as World,
                        it.getRef(1) as Random
                    ))
                }
                .function("isParallelCapable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isParallelCapable ?: false) }
                .function("shouldGenerateNoise", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.shouldGenerateNoise() ?: false)
                }
                .function("shouldGenerateNoise", returns(Type.Z).params(Type.OBJECT, Type.OBJECT, Type.I, Type.I)) {
                    it.setReturnBool(it.target?.shouldGenerateNoise(
                        it.getRef(0) as WorldInfo,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt()
                    ) ?: false)
                }
                .function("shouldGenerateSurface", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.shouldGenerateSurface() ?: false)
                }
                .function("shouldGenerateSurface", returns(Type.Z).params(Type.OBJECT, Type.OBJECT, Type.I, Type.I)) {
                    it.setReturnBool(it.target?.shouldGenerateSurface(
                        it.getRef(0) as WorldInfo,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt()
                    ) ?: false)
                }
                .function("shouldGenerateBedrock", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.shouldGenerateBedrock() ?: false) }
                .function("shouldGenerateCaves", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.shouldGenerateCaves() ?: false)
                }
                .function("shouldGenerateCaves", returns(Type.Z).params(Type.OBJECT, Type.OBJECT, Type.I, Type.I)) {
                    it.setReturnBool(it.target?.shouldGenerateCaves(
                        it.getRef(0) as WorldInfo,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt()
                    ) ?: false)
                }
                .function("shouldGenerateDecorations", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.shouldGenerateDecorations() ?: false)
                }
                .function("shouldGenerateDecorations", returns(Type.Z).params(Type.OBJECT, Type.OBJECT, Type.I, Type.I)) {
                    it.setReturnBool(it.target?.shouldGenerateDecorations(
                        it.getRef(0) as WorldInfo,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt()
                    ) ?: false)
                }
                .function("shouldGenerateMobs", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.shouldGenerateMobs() ?: false)
                }
                .function("shouldGenerateMobs", returns(Type.Z).params(Type.OBJECT, Type.OBJECT, Type.I, Type.I)) {
                    it.setReturnBool(it.target?.shouldGenerateMobs(
                        it.getRef(0) as WorldInfo,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt()
                    ) ?: false)
                }
                .function("shouldGenerateStructures", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.shouldGenerateStructures() ?: false)
                }
                .function("shouldGenerateStructures", returns(Type.Z).params(Type.OBJECT, Type.OBJECT, Type.I, Type.I)) {
                    it.setReturnBool(it.target?.shouldGenerateStructures(
                        it.getRef(0) as WorldInfo,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt()
                    ) ?: false)
                }
        }
    }
}

@Requires(classes = ["org.bukkit.generator.ChunkGenerator.ChunkData"])
@PlatformSide(Platform.BUKKIT)
object FnChunkGeneratorChunkData {

    val TYPE = Type.fromClass(ChunkGenerator.ChunkData::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChunkGenerator.ChunkData::class.java)
                .function("minHeight", returns(Type.I).noParams()) { it.setReturnInt(it.target?.minHeight ?: 0) }
                .function("maxHeight", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxHeight ?: 0) }
                .function("getBiome", returnsObject().params(Type.I, Type.I, Type.I)) { it.setReturnRef(it.target?.getBiome(it.getInt(0).toInt(), it.getInt(1).toInt(), it.getInt(2).toInt())) }
                .function("setBlock", returnsVoid().params(Type.I, Type.I, Type.I, Type.OBJECT)) {
                    when (val var4 = it.getRef(3)) {
                        is Material -> it.target?.setBlock(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            var4
                        )

                        is MaterialData -> it.target?.setBlock(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            var4
                        )

                        is BlockData -> it.target?.setBlock(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            var4
                        )

                        else -> throw IllegalArgumentException("参数 4 必须是 Material, MaterialData, 或 BlockData 类型")
                    }
                }
                .function("setRegion", returnsVoid().params(Type.I, Type.I, Type.I, Type.I, Type.I, Type.I, Type.OBJECT)) {
                    when (val var7 = it.getRef(6)) {
                        is Material -> it.target?.setRegion(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt(),
                            it.getInt(4).toInt(),
                            it.getInt(5).toInt(),
                            var7
                        )

                        is MaterialData -> it.target?.setRegion(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt(),
                            it.getInt(4).toInt(),
                            it.getInt(5).toInt(),
                            var7
                        )

                        is BlockData -> it.target?.setRegion(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt(),
                            it.getInt(4).toInt(),
                            it.getInt(5).toInt(),
                            var7
                        )

                        else -> throw IllegalArgumentException("参数 7 必须是 Material, MaterialData, 或 BlockData 类型")
                    }
                }
                .function("getType", returnsObject().params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getType(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getTypeAndData", returnsObject().params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getTypeAndData(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getBlockData", returnsObject().params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBlockData(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getData", returnsObject().params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getData(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
        }
    }
}

@Requires(classes = ["org.bukkit.generator.ChunkGenerator.BiomeGrid"])
@PlatformSide(Platform.BUKKIT)
object FnChunkGeneratorBiomeGrid {

    val TYPE = Type.fromClass(ChunkGenerator.BiomeGrid::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChunkGenerator.BiomeGrid::class.java)
                .function("getBiome", returnsObject().params(Type.I, Type.I)) { it.setReturnRef(it.target?.getBiome(it.getInt(0).toInt(), it.getInt(1).toInt())) }
                .function("setBiome", returnsVoid().params(Type.I, Type.I, Type.OBJECT)) {
                    it.target?.setBiome(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getRef(2) as Biome
                    )
                }
                .function("setBiome", returnsVoid().params(Type.I, Type.I, Type.I, Type.OBJECT)) {
                    it.target?.setBiome(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getRef(3) as Biome
                    )
                }
        }
    }
}
