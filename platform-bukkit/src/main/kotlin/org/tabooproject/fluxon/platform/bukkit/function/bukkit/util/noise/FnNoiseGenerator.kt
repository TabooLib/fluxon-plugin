package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.NoiseGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.noise.NoiseGenerator"])
@PlatformSide(Platform.BUKKIT)
object FnNoiseGenerator {

    val TYPE = Type.fromClass(NoiseGenerator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NoiseGenerator::class.java)
                // static
                .function("floor", returns(Type.I).params(Type.D)) {
                    it.setReturnInt(NoiseGenerator.floor(it.getAsDouble(0)))
                }
                .function("noise", returns(Type.D).params(Type.D)) {
                    it.setReturnDouble(it.target?.noise(it.getAsDouble(0)) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getAsDouble(0),
                        it.getAsDouble(1)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsDouble(2)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.I, Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getAsDouble(0),
                        it.getAsInt(1),
                        it.getAsDouble(2),
                        it.getAsDouble(3)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.I, Type.D, Type.D, Type.Z)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getAsDouble(0),
                        it.getAsInt(1),
                        it.getAsDouble(2),
                        it.getAsDouble(3),
                        it.getBool(4)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.I, Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsInt(2),
                        it.getAsDouble(3),
                        it.getAsDouble(4)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.I, Type.D, Type.D, Type.Z)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsInt(2),
                        it.getAsDouble(3),
                        it.getAsDouble(4),
                        it.getBool(5)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.I, Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsDouble(2),
                        it.getAsInt(3),
                        it.getAsDouble(4),
                        it.getAsDouble(5)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.I, Type.D, Type.D, Type.Z)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsDouble(2),
                        it.getAsInt(3),
                        it.getAsDouble(4),
                        it.getAsDouble(5),
                        it.getBool(6)
                    ) ?: 0.0)
                }
        }
    }
}
