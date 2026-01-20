package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.SimplexOctaveGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSimplexOctaveGenerator {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimplexOctaveGenerator::class.java)
                .function("setScale", 1) { it.target?.setScale(it.getNumber(0).toDouble()) }
                .function("wScale", 0) { it.target?.wScale }
                .function("setWScale", 1) { it.target?.setWScale(it.getNumber(0).toDouble()) }
                .function("noise", listOf(6, 7)) {
                    if (it.arguments.size == 6) {
                        it.target?.noise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toDouble(),
                            it.getNumber(5).toDouble()
                        )
                    } else {
                        it.target?.noise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toDouble(),
                            it.getNumber(5).toDouble(),
                            it.getBoolean(6)
                        )
                    }
                }
        }
    }
}
