package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.SmoothBrick
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSmoothBrick {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SmoothBrick::class.java)
                .function("textures", 0) { it.target?.textures }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
