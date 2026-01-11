package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.bukkit.metadata.Metadatable

import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMetadatable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Metadatable::class.java)
                .function("setMetadata", 2) { TODO() }
                .function("metadata", 1) { TODO() }
                .function("hasMetadata", 1) { TODO() }
                .function("removeMetadata", 2) { TODO() }
        }
    }
}
