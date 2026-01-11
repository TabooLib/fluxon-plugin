package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.SimplexNoiseGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSimplexNoiseGenerator {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimplexNoiseGenerator::class.java)
                // static
                .function("noise", 1) { SimplexNoiseGenerator.getNoise(it.getNumber(0).toDouble()) }
                // static
                .function("noise", 2) {
                    // static double getNoise(double xin, double yin)
                    // double noise(double xin, double yin)
                    TODO()
                }
                // static
                .function("noise", 3) {
                    // static double getNoise(double xin, double yin, double zin)
                    // double noise(double xin, double yin, double zin)
                    TODO()
                }
                // static
                .function("noise", 4) {
                    // static double getNoise(double x, double y, double z, double w)
                    // double noise(double x, double y, double z, double w)
                    TODO()
                }
                // static
                .function("instance", 0) { SimplexNoiseGenerator.getInstance() }
        }
    }
}
