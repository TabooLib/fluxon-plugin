package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator

import org.bukkit.generator.BiomeParameterPoint
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.generator.BiomeParameterPoint"])
@PlatformSide(Platform.BUKKIT)
object FnBiomeParameterPoint {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BiomeParameterPoint::class.java)
                .function("temperature", 0) { it.target?.temperature }
                .function("maxTemperature", 0) { it.target?.maxTemperature }
                .function("minTemperature", 0) { it.target?.minTemperature }
                .function("humidity", 0) { it.target?.humidity }
                .function("maxHumidity", 0) { it.target?.maxHumidity }
                .function("minHumidity", 0) { it.target?.minHumidity }
                .function("continentalness", 0) { it.target?.continentalness }
                .function("maxContinentalness", 0) { it.target?.maxContinentalness }
                .function("minContinentalness", 0) { it.target?.minContinentalness }
                .function("erosion", 0) { it.target?.erosion }
                .function("maxErosion", 0) { it.target?.maxErosion }
                .function("minErosion", 0) { it.target?.minErosion }
                .function("depth", 0) { it.target?.depth }
                .function("maxDepth", 0) { it.target?.maxDepth }
                .function("minDepth", 0) { it.target?.minDepth }
                .function("weirdness", 0) { it.target?.weirdness }
                .function("maxWeirdness", 0) { it.target?.maxWeirdness }
                .function("minWeirdness", 0) { it.target?.minWeirdness }
        }
    }
}
