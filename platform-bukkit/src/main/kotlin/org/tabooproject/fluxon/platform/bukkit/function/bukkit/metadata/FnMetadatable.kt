package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.bukkit.metadata.MetadataValue
import org.bukkit.metadata.Metadatable
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMetadatable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Metadatable::class.java)
                .function("setMetadata", 2) {
                    it.target?.setMetadata(
                        it.getString(0)!!,
                        it.getArgument(1) as MetadataValue
                    )
                }
                .function("metadata", 1) { it.target?.getMetadata(it.getString(0)!!) }
                .function("hasMetadata", 1) { it.target?.hasMetadata(it.getString(0)!!) }
                .function("removeMetadata", 2) {
                    it.target?.removeMetadata(
                        it.getString(0)!!,
                        it.getArgument(1) as Plugin
                    )
                }
        }
    }
}
