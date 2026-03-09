package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.PerlinNoiseGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.noise.PerlinNoiseGenerator"])
@PlatformSide(Platform.BUKKIT)
object FnPerlinNoiseGenerator {

    val TYPE = Type.fromClass(PerlinNoiseGenerator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PerlinNoiseGenerator::class.java)
                // static
                .function("getNoise", returns(Type.D).params(Type.D)) {
                    it.setReturnDouble(PerlinNoiseGenerator.getNoise(it.getAsDouble(0)))
                }
                .function("getNoise", returns(Type.D).params(Type.D, Type.D)) {
                    it.setReturnDouble(PerlinNoiseGenerator.getNoise(
                        it.getAsDouble(0),
                        it.getAsDouble(1)
                    ))
                }
                .function("getNoise", returns(Type.D).params(Type.D, Type.D, Type.D)) {
                    it.setReturnDouble(PerlinNoiseGenerator.getNoise(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsDouble(2)
                    ))
                }
                .function("getNoise", returns(Type.D).params(Type.D, Type.I, Type.D, Type.D)) {
                    it.setReturnDouble(PerlinNoiseGenerator.getNoise(
                        it.getAsDouble(0),
                        it.getAsInt(1),
                        it.getAsDouble(2),
                        it.getAsDouble(3)
                    ))
                }
                .function("getNoise", returns(Type.D).params(Type.D, Type.D, Type.I, Type.D, Type.D)) {
                    it.setReturnDouble(PerlinNoiseGenerator.getNoise(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsInt(2),
                        it.getAsDouble(3),
                        it.getAsDouble(4)
                    ))
                }
                .function("getNoise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.I, Type.D, Type.D)) {
                    it.setReturnDouble(PerlinNoiseGenerator.getNoise(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsDouble(2),
                        it.getAsInt(3),
                        it.getAsDouble(4),
                        it.getAsDouble(5)
                    ))
                }
                // static
                .function("instance",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise.FnPerlinNoiseGenerator.TYPE).noParams()) {
                    it.setReturnRef(PerlinNoiseGenerator.getInstance())
                }
        }
    }
}
