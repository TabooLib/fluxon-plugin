package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Fluid
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnFluid {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Fluid::class.java)
                .function("key", 0) { it.target?.key }
        }
    }
}
