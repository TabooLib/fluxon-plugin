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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.generator.BiomeParameterPoint"])
@PlatformSide(Platform.BUKKIT)
object FnBiomeParameterPoint {

    val TYPE = Type.fromClass(BiomeParameterPoint::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BiomeParameterPoint::class.java)
                .function("temperature",returns(Type.D).noParams()) { it.setReturnRef(it.target?.temperature) }
                .function("maxTemperature",returns(Type.D).noParams()) { it.setReturnRef(it.target?.maxTemperature) }
                .function("minTemperature",returns(Type.D).noParams()) { it.setReturnRef(it.target?.minTemperature) }
                .function("humidity",returns(Type.D).noParams()) { it.setReturnRef(it.target?.humidity) }
                .function("maxHumidity",returns(Type.D).noParams()) { it.setReturnRef(it.target?.maxHumidity) }
                .function("minHumidity",returns(Type.D).noParams()) { it.setReturnRef(it.target?.minHumidity) }
                .function("continentalness",returns(Type.D).noParams()) { it.setReturnRef(it.target?.continentalness) }
                .function("maxContinentalness",returns(Type.D).noParams()) { it.setReturnRef(it.target?.maxContinentalness) }
                .function("minContinentalness",returns(Type.D).noParams()) { it.setReturnRef(it.target?.minContinentalness) }
                .function("erosion",returns(Type.D).noParams()) { it.setReturnRef(it.target?.erosion) }
                .function("maxErosion",returns(Type.D).noParams()) { it.setReturnRef(it.target?.maxErosion) }
                .function("minErosion",returns(Type.D).noParams()) { it.setReturnRef(it.target?.minErosion) }
                .function("depth",returns(Type.D).noParams()) { it.setReturnRef(it.target?.depth) }
                .function("maxDepth",returns(Type.D).noParams()) { it.setReturnRef(it.target?.maxDepth) }
                .function("minDepth",returns(Type.D).noParams()) { it.setReturnRef(it.target?.minDepth) }
                .function("weirdness",returns(Type.D).noParams()) { it.setReturnRef(it.target?.weirdness) }
                .function("maxWeirdness",returns(Type.D).noParams()) { it.setReturnRef(it.target?.maxWeirdness) }
                .function("minWeirdness",returns(Type.D).noParams()) { it.setReturnRef(it.target?.minWeirdness) }
        }
    }
}
