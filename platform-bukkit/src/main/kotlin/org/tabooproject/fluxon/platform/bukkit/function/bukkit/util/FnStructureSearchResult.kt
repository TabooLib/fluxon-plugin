package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.StructureSearchResult
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnStructureSearchResult {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureSearchResult::class.java)
                .function("structure", 0) { it.target?.structure }
                .function("location", 0) { it.target?.location }
        }
    }
}
