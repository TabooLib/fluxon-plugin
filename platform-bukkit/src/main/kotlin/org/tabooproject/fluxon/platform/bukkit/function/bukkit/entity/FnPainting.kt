package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Art
import org.bukkit.entity.Painting
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPainting {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Painting::class.java)
                .function("art", 0) { it.target?.art }
                .function("setArt", 1) { it.target?.setArt(it.getArgument(0) as Art) }
                .function("setArt", 2) { it.target?.setArt(it.getArgument(0) as Art, it.getBoolean(1)) }
        }
    }
}
