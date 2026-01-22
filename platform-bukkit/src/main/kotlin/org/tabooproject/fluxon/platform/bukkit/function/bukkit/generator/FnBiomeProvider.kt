package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator

import org.bukkit.generator.BiomeParameterPoint
import org.bukkit.generator.BiomeProvider
import org.bukkit.generator.WorldInfo
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBiomeProvider {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BiomeProvider::class.java)
                .function("getBiome", listOf(4, 5)) {
                    if (it.arguments.size == 4) {
                        it.target?.getBiome(
                            it.getArgument(0) as WorldInfo,
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt()
                        )
                    } else {
                        it.target?.getBiome(
                            it.getArgument(0) as WorldInfo,
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt(),
                            it.getArgument(4) as BiomeParameterPoint
                        )
                    }
                }
                .function("getBiomes", 1) { it.target?.getBiomes(it.getArgument(0) as WorldInfo) }
        }
    }
}
