package org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement

import org.bukkit.advancement.AdvancementDisplayType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnAdvancementDisplayType {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AdvancementDisplayType::class.java)
                .function("color", 0) { it.target?.color }
        }
    }
}
