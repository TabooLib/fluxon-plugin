package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.NoiseGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnNoiseGenerator {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NoiseGenerator::class.java)
                // static
                .function("floor", 1) { NoiseGenerator.floor(it.getNumber(0).toDouble()) }
                .function("noise", listOf(1, 2, 3, 4, 5, 6, 7)) {
                    when (it.arguments.size) {
                        1 -> it.target?.noise(it.getNumber(0).toDouble())
                        2 -> it.target?.noise(it.getNumber(0).toDouble(), it.getNumber(1).toDouble())
                        3 -> it.target?.noise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble()
                        )

                        4 -> it.target?.noise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble()
                        )

                        5 -> when (val var2 = it.getArgument(1)) {
                            is Int -> it.target?.noise(
                                it.getNumber(0).toDouble(),
                                var2,
                                it.getNumber(2).toDouble(),
                                it.getNumber(3).toDouble(),
                                it.getBoolean(4)
                            )

                            is Double -> it.target?.noise(
                                it.getNumber(0).toDouble(),
                                var2,
                                it.getNumber(2).toInt(),
                                it.getNumber(3).toDouble(),
                                it.getNumber(4).toDouble()
                            )

                            else -> throw IllegalArgumentException("第二个参数必须是 Int 或 Double 类型")
                        }

                        6 -> when (val var3 = it.getArgument(2)) {
                            is Int -> it.target?.noise(
                                it.getNumber(0).toDouble(),
                                it.getNumber(1).toDouble(),
                                var3,
                                it.getNumber(3).toDouble(),
                                it.getNumber(4).toDouble(),
                                it.getBoolean(5)
                            )

                            is Double -> it.target?.noise(
                                it.getNumber(0).toDouble(),
                                it.getNumber(1).toDouble(),
                                var3,
                                it.getNumber(3).toInt(),
                                it.getNumber(4).toDouble(),
                                it.getNumber(5).toDouble()
                            )

                            else -> throw IllegalArgumentException("第三个参数必须是 Int 或 Double 类型")
                        }

                        7 -> it.target?.noise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toInt(),
                            it.getNumber(4).toDouble(),
                            it.getNumber(5).toDouble(),
                            it.getBoolean(6)
                        )
                        else -> error("NoiseGenerator#noise 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
        }
    }
}
