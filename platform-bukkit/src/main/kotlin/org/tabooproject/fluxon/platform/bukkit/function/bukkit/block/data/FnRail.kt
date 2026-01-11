package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Rail
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnRail {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rail::class.java)
                .function("shape", 0) { it.target?.shape }
                .function("setShape", 1) { it.target?.setShape(it.getArgument(0) as Rail.Shape) }
                .function("shapes", 0) { it.target?.shapes }
        }
    }
}
