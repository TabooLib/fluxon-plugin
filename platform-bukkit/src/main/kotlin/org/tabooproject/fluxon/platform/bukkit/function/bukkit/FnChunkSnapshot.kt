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

    val TYPE = Type.fromClass(ChunkSnapshot::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChunkSnapshot::class.java)
                .function("x", returns(Type.I).noParams()) { it.setReturnInt(it.target?.x ?: 0) }
                .function("z", returns(Type.I).noParams()) { it.setReturnInt(it.target?.z ?: 0) }
                .function("worldName", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.worldName) }
                .function("getBlockType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBlockType(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getBlockData",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBlockData(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getData", returns(Type.I).params(Type.I, Type.I, Type.I)) {
                    it.setReturnInt(it.target?.getData(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ) ?: 0)
                }
                .function("getBlockSkyLight", returns(Type.I).params(Type.I, Type.I, Type.I)) {
                    it.setReturnInt(it.target?.getBlockSkyLight(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ) ?: 0)
                }
                .function("getBlockEmittedLight", returns(Type.I).params(Type.I, Type.I, Type.I)) {
                    it.setReturnInt(it.target?.getBlockEmittedLight(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ) ?: 0)
                }
                .function("getHighestBlockYAt", returns(Type.I).params(Type.I, Type.I)) {
                    it.setReturnInt(it.target?.getHighestBlockYAt(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ) ?: 0)
                }
                .function("getBiome",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.TYPE).params(Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBiome(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("getBiome",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBiome(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getRawBiomeTemperature", returns(Type.D).params(Type.I, Type.I)) {
                    it.setReturnDouble(it.target?.getRawBiomeTemperature(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    )?.toDouble() ?: 0.0)
                }
                .function("getRawBiomeTemperature", returns(Type.D).params(Type.I, Type.I, Type.I)) {
                    it.setReturnDouble(it.target?.getRawBiomeTemperature(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    )?.toDouble() ?: 0.0)
                }
                .function("captureFullTime", returns(Type.J).noParams()) { it.setReturnLong(it.target?.captureFullTime ?: 0L) }
                .function("isSectionEmpty", returns(Type.Z).params(Type.I)) {
                    it.setReturnBool(it.target?.isSectionEmpty(it.getInt(0).toInt()) ?: false)
                }
                .function("contains",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is BlockData -> it.target?.contains(var1)
                        is Biome -> it.target?.contains(var1)
                        else -> throw IllegalArgumentException("参数必须是 BlockData 或 Biome 类型")
                    } ?: false)
                }
        }
    }
}
