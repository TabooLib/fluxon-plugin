package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Turtle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnTurtle {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Turtle::class.java)
                .function("hasEgg", 0) { it.target?.hasEgg() }
                .function("isLayingEgg", 0) { it.target?.isLayingEgg }
        }
    }
}
