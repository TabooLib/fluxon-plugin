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

@Requires(classes = ["org.bukkit.generator.BiomeProvider"])
@PlatformSide(Platform.BUKKIT)
object FnBiomeProvider {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BiomeProvider::class.java)
                .function("getBiome", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 4) {
                        it.target?.getBiome(
                            it.getRef(0) as WorldInfo,
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt()
                        )
                    } else {
                        it.target?.getBiome(
                            it.getRef(0) as WorldInfo,
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt(),
                            it.getRef(4) as BiomeParameterPoint
                        )
                    })
                }
                .function("getBiome", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 4) {
                        it.target?.getBiome(
                            it.getRef(0) as WorldInfo,
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt()
                        )
                    } else {
                        it.target?.getBiome(
                            it.getRef(0) as WorldInfo,
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt(),
                            it.getRef(4) as BiomeParameterPoint
                        )
                    })
                }
                .function("getBiomes", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getBiomes(it.getRef(0) as WorldInfo)) }
        }
    }
}
