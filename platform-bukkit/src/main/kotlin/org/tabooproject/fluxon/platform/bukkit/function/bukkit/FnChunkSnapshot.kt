package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.ChunkSnapshot
import org.bukkit.block.Biome
import org.bukkit.block.data.BlockData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.ChunkSnapshot"])
@PlatformSide(Platform.BUKKIT)
object FnChunkSnapshot {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChunkSnapshot::class.java)
                .function("x", returnsObject().noParams()) { it.setReturnRef(it.target?.x) }
                .function("z", returnsObject().noParams()) { it.setReturnRef(it.target?.z) }
                .function("worldName", returnsObject().noParams()) { it.setReturnRef(it.target?.worldName) }
                .function("getBlockType", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getBlockType(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getBlockData", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getBlockData(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getData", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getData(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getBlockSkyLight", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getBlockSkyLight(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getBlockEmittedLight", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getBlockEmittedLight(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getHighestBlockYAt", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getHighestBlockYAt(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("getBiome", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.getBiome(it.getInt(0).toInt(), it.getInt(1).toInt())
                    } else {
                        it.target?.getBiome(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("getBiome", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.getBiome(it.getInt(0).toInt(), it.getInt(1).toInt())
                    } else {
                        it.target?.getBiome(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("getRawBiomeTemperature", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.getRawBiomeTemperature(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )
                    } else {
                        it.target?.getRawBiomeTemperature(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("getRawBiomeTemperature", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.getRawBiomeTemperature(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )
                    } else {
                        it.target?.getRawBiomeTemperature(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("captureFullTime", returnsObject().noParams()) { it.setReturnRef(it.target?.captureFullTime) }
                .function("isSectionEmpty", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.isSectionEmpty(it.getInt(0).toInt())) }
                .function("contains", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is BlockData -> it.target?.contains(var1)
                        is Biome -> it.target?.contains(var1)
                        else -> throw IllegalArgumentException("参数必须是 BlockData 或 Biome 类型")
                    })
                }
        }
    }
}
