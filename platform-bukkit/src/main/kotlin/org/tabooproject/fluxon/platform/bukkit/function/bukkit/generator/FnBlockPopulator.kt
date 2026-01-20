package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator

import org.bukkit.Chunk
import org.bukkit.World
import org.bukkit.generator.BlockPopulator
import org.bukkit.generator.LimitedRegion
import org.bukkit.generator.WorldInfo
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBlockPopulator {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPopulator::class.java)
                .function("populate", listOf(3, 5)) {
                    if (it.arguments.size == 3) {
                        it.target?.populate(
                            it.getArgument(0) as World,
                            it.getArgument(1) as Random,
                            it.getArgument(2) as Chunk
                        )
                    } else {
                        it.target?.populate(
                            it.getArgument(0) as WorldInfo,
                            it.getArgument(1) as Random,
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt(),
                            it.getArgument(4) as LimitedRegion
                        )
                    }
                }
        }
    }
}
