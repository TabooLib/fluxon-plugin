package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.BiomeSearchResult
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBiomeSearchResult {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BiomeSearchResult::class.java)
                .function("biome", 0) { it.target?.biome }
                .function("location", 0) { it.target?.location }
        }
    }
}
