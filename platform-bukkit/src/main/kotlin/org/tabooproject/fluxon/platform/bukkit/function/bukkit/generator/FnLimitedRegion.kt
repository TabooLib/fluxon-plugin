package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator

import org.bukkit.Location
import org.bukkit.generator.LimitedRegion
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnLimitedRegion {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LimitedRegion::class.java)
                .function("buffer", 0) { it.target?.buffer }
                .function("isInRegion", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        it.target?.isInRegion(it.getArgument(0) as Location)
                    } else {
                        it.target?.isInRegion(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                .function("tileEntities", 0) { it.target?.tileEntities }
        }
    }
}
