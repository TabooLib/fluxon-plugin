package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.PerlinNoiseGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPerlinNoiseGenerator {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PerlinNoiseGenerator::class.java)
                // static
                .function("noise", 1) { PerlinNoiseGenerator.getNoise(it.getNumber(0).toDouble()) }
                // static
                .function("noise", 2) {
                    PerlinNoiseGenerator.getNoise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble()
                    )
                }
                // static
                .function("noise", 3) {
                    PerlinNoiseGenerator.getNoise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                // static
                .function("instance", 0) { PerlinNoiseGenerator.getInstance() }
                // static
                .function("noise", 4) {
                    PerlinNoiseGenerator.getNoise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toDouble()
                    )
                }
                // static
                .function("noise", 5) {
                    PerlinNoiseGenerator.getNoise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toDouble(),
                        it.getNumber(4).toDouble()
                    )
                }
                // static
                .function("noise", 6) {
                    PerlinNoiseGenerator.getNoise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toInt(),
                        it.getNumber(4).toDouble(),
                        it.getNumber(5).toDouble()
                    )
                }
        }
    }
}
