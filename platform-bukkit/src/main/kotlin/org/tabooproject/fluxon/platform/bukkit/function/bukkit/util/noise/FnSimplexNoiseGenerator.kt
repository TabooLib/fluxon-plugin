package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.SimplexNoiseGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSimplexNoiseGenerator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimplexNoiseGenerator::class.java)
                // static
                .function("noise", listOf(1, 2, 3, 4)) {
                    when (it.arguments.size) {
                        1 -> SimplexNoiseGenerator.getNoise(it.getNumber(0).toDouble())
                        2 -> SimplexNoiseGenerator.getNoise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble()
                        )

                        3 -> SimplexNoiseGenerator.getNoise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble()
                        )

                        4 -> SimplexNoiseGenerator.getNoise(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble()
                        )
                        else -> error("SimplexNoiseGenerator#noise 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                // static
                .function("instance", 0) { SimplexNoiseGenerator.getInstance() }
        }
    }
}
