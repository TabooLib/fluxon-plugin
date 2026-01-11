package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Chest
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnChest {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Chest::class.java)
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
