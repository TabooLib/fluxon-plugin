package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Keyed
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnKeyed {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Keyed::class.java)
                .function("key", 0) { it.target?.key }
        }
    }
}
