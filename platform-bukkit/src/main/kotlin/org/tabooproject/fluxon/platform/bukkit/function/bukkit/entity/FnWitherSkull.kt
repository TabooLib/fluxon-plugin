package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.WitherSkull
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnWitherSkull {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WitherSkull::class.java)
                .function("setCharged", 1) { it.target?.setCharged(it.getBoolean(0)) }
                .function("isCharged", 0) { it.target?.isCharged }
        }
    }
}
