package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Zoglin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnZoglin {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Zoglin::class.java)
                .function("isBaby", 0) { it.target?.isBaby }
                .function("setBaby", 1) { it.target?.setBaby(it.getBoolean(0)) }
        }
    }
}
