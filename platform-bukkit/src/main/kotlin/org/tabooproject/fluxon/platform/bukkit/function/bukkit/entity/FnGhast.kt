package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Ghast
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnGhast {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ghast::class.java)
                .function("isCharging", 0) { it.target?.isCharging }
                .function("setCharging", 1) { it.target?.setCharging(it.getBoolean(0)) }
        }
    }
}
