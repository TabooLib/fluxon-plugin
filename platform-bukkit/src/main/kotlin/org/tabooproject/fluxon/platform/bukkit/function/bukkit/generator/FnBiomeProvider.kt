package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator

import org.bukkit.generator.BiomeParameterPoint
import org.bukkit.generator.BiomeProvider
import org.bukkit.generator.WorldInfo
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.generator.BiomeProvider"])
@PlatformSide(Platform.BUKKIT)
object FnBiomeProvider {

    val TYPE = Type.fromClass(BiomeProvider::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BiomeProvider::class.java)
                .function("getBiome",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnWorldInfo.TYPE, Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBiome(
                        it.getRef(0) as WorldInfo,
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt()
                    ))
                }
                .function("getBiome",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnWorldInfo.TYPE, Type.I, Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnBiomeParameterPoint.TYPE)) {
                    it.setReturnRef(it.target?.getBiome(
                        it.getRef(0) as WorldInfo,
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt(),
                        it.getRef(4) as BiomeParameterPoint
                    ))
                }
                .function("getBiomes",returns(Type.LIST).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnWorldInfo.TYPE)) { it.setReturnRef(it.target?.getBiomes(it.getRef(0) as WorldInfo)) }
        }
    }
}
