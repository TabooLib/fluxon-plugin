package org.tabooproject.fluxon.platform.bukkit.function.bukkit.structure

import org.bukkit.structure.Palette
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPalette {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Palette::class.java)
                .function("blocks", 0) { it.target?.blocks }
                .function("blockCount", 0) { it.target?.blockCount }
        }
    }
}
