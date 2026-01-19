package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.OctaveGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnOctaveGenerator {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OctaveGenerator::class.java)
                .function("setScale", 1) { it.target?.setScale(it.getNumber(0).toDouble()) }
                .function("xScale", 0) { it.target?.getXScale() }
                .function("setXScale", 1) { it.target?.setXScale(it.getNumber(0).toDouble()) }
                .function("yScale", 0) { it.target?.getYScale() }
                .function("setYScale", 1) { it.target?.setYScale(it.getNumber(0).toDouble()) }
                .function("zScale", 0) { it.target?.getZScale() }
                .function("setZScale", 1) { it.target?.setZScale(it.getNumber(0).toDouble()) }
                .function("octaves", 0) { it.target?.getOctaves() }
                .function("noise", 3) {
                    it.target?.noise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                .function("noise", 4) {
                    when (val var4 = it.getArgument(3)) {
                        is Boolean -> it.target?.noise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            var4
                        )

                        is Double -> it.target?.noise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            var4
                        )

                        else -> throw IllegalArgumentException("第四个参数必须是 Boolean 或 Double 类型")
                    }
                }
                .function("noise", 5) {
                    when (val var5 = it.getArgument(4)) {
                        is Boolean -> it.target?.noise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble(),
                            var5
                        )

                        is Double -> it.target?.noise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble(),
                            var5
                        )

                        else -> throw IllegalArgumentException("第五个参数必须是 Boolean 或 Double 类型")
                    }
                }
                .function("noise", 6) {
                    it.target?.noise(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toDouble(),
                        it.getNumber(4).toDouble(),
                        it.getBoolean(5)
                    )
                }
        }
    }
}
