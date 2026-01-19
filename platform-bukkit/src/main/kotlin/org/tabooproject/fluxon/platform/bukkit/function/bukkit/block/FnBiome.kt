package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Biome
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBiome {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Biome::class.java)
                .function("key", 0) { it.target?.key }
        }
    }
}
