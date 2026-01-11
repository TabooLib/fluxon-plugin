package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.DyeColor
import org.bukkit.material.Colorable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnColorable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Colorable::class.java)
                .function("color", 0) { it.target?.color }
                .function("setColor", 1) { it.target?.setColor(it.getArgument(0) as DyeColor) }
        }
    }
}
