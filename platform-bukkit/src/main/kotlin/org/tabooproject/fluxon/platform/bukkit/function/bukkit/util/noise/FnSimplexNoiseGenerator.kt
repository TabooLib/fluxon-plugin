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
                    SimplexNoiseGenerator.getNoise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble()
                    )
                }
                // static
                .function("noise", 3) {
                    SimplexNoiseGenerator.getNoise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                // static
                .function("noise", 4) {
                    SimplexNoiseGenerator.getNoise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toDouble()
                    )
                }
                // static
                .function("instance", 0) { SimplexNoiseGenerator.getInstance() }
        }
    }
}
