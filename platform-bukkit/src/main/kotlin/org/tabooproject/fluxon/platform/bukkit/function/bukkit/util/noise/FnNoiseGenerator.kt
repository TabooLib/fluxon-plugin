package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.NoiseGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnNoiseGenerator {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NoiseGenerator::class.java)
                // static
                .function("floor", 1) { NoiseGenerator.floor(it.getNumber(0).toDouble()) }
                .function("noise", 1) { it.target?.noise(it.getNumber(0).toDouble()) }
                .function("noise", 2) { it.target?.noise(it.getNumber(0).toDouble(), it.getNumber(1).toDouble()) }
                .function("noise", 3) {
                    it.target?.noise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                .function("noise", 4) {
                    it.target?.noise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toDouble()
                    )
                }
                .function("noise", 5) {
                    // double noise(double x, int octaves, double frequency, double amplitude, boolean normalized)
                    // double noise(double x, double y, int octaves, double frequency, double amplitude)
                    TODO()
                }
                .function("noise", 6) {
                    // double noise(double x, double y, int octaves, double frequency, double amplitude, boolean normalized)
                    // double noise(double x, double y, double z, int octaves, double frequency, double amplitude)
                    TODO()
                }
                .function("noise", 7) {
                    it.target?.noise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toInt(),
                        it.getNumber(4).toDouble(),
                        it.getNumber(5).toDouble(),
                        it.getBoolean(6)
                    )
                }
        }
    }
}
