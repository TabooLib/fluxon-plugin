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
                    it.setReturnInt(NoiseGenerator.floor(it.getDouble(0)))
                }
                .function("noise", returns(Type.D).params(Type.D)) {
                    it.setReturnDouble(it.target?.noise(it.getDouble(0)) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getDouble(1)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.I, Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getInt(1),
                        it.getDouble(2),
                        it.getDouble(3)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.I, Type.D, Type.D, Type.Z)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getInt(1),
                        it.getDouble(2),
                        it.getDouble(3),
                        it.getBool(4)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.I, Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getInt(2),
                        it.getDouble(3),
                        it.getDouble(4)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.I, Type.D, Type.D, Type.Z)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getInt(2),
                        it.getDouble(3),
                        it.getDouble(4),
                        it.getBool(5)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.I, Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getInt(3),
                        it.getDouble(4),
                        it.getDouble(5)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.I, Type.D, Type.D, Type.Z)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getInt(3),
                        it.getDouble(4),
                        it.getDouble(5),
                        it.getBool(6)
                    ) ?: 0.0)
                }
        }
    }
}
