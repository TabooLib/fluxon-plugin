package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.PerlinNoiseGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.util.noise.PerlinNoiseGenerator"])
@PlatformSide(Platform.BUKKIT)
object FnPerlinNoiseGenerator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PerlinNoiseGenerator::class.java)
                // static
                .function("getNoise", listOf(1, 2, 3, 4, 5, 6)) {
                    when (it.arguments.size) {
                        1 -> PerlinNoiseGenerator.getNoise(it.getNumber(0).toDouble())
                        2 -> PerlinNoiseGenerator.getNoise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble()
                        )

                        3 -> PerlinNoiseGenerator.getNoise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble()
                        )

                        4 -> PerlinNoiseGenerator.getNoise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble()
                        )

                        5 -> PerlinNoiseGenerator.getNoise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toDouble()
                        )

                        6 -> PerlinNoiseGenerator.getNoise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toInt(),
                            it.getNumber(4).toDouble(),
                            it.getNumber(5).toDouble()
                        )
                        else -> error("PerlinNoiseGenerator#noise 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                // static
                .function("instance", 0) { PerlinNoiseGenerator.getInstance() }
        }
    }
}
