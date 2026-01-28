package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator

import org.bukkit.generator.BiomeParameterPoint
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.generator.BiomeParameterPoint"])
@PlatformSide(Platform.BUKKIT)
object FnBiomeParameterPoint {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BiomeParameterPoint::class.java)
                .function("temperature", returnsObject().noParams()) { it.target?.temperature }
                .function("maxTemperature", returnsObject().noParams()) { it.target?.maxTemperature }
                .function("minTemperature", returnsObject().noParams()) { it.target?.minTemperature }
                .function("humidity", returnsObject().noParams()) { it.target?.humidity }
                .function("maxHumidity", returnsObject().noParams()) { it.target?.maxHumidity }
                .function("minHumidity", returnsObject().noParams()) { it.target?.minHumidity }
                .function("continentalness", returnsObject().noParams()) { it.target?.continentalness }
                .function("maxContinentalness", returnsObject().noParams()) { it.target?.maxContinentalness }
                .function("minContinentalness", returnsObject().noParams()) { it.target?.minContinentalness }
                .function("erosion", returnsObject().noParams()) { it.target?.erosion }
                .function("maxErosion", returnsObject().noParams()) { it.target?.maxErosion }
                .function("minErosion", returnsObject().noParams()) { it.target?.minErosion }
                .function("depth", returnsObject().noParams()) { it.target?.depth }
                .function("maxDepth", returnsObject().noParams()) { it.target?.maxDepth }
                .function("minDepth", returnsObject().noParams()) { it.target?.minDepth }
                .function("weirdness", returnsObject().noParams()) { it.target?.weirdness }
                .function("maxWeirdness", returnsObject().noParams()) { it.target?.maxWeirdness }
                .function("minWeirdness", returnsObject().noParams()) { it.target?.minWeirdness }
        }
    }
}
