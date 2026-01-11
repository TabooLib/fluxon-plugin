package org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement

import org.bukkit.advancement.Advancement
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnAdvancement {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Advancement::class.java)
                .function("criteria", 0) { it.target?.criteria }
                .function("display", 0) { it.target?.display }
        }
    }
}
