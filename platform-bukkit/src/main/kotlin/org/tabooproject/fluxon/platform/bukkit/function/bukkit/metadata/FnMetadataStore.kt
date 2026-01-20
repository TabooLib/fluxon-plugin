package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.bukkit.metadata.MetadataStore
import org.bukkit.metadata.MetadataValue
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMetadataStore {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MetadataStore::class.java)
                .function("setMetadata", 3) {
                    (it.target as? MetadataStore<Any>)?.setMetadata(
                        it.getArgument(0)!!,
                        it.getString(1)!!,
                        it.getArgument(2) as MetadataValue
                    )
                }
                .function("metadata", 2) {
                    (it.target as? MetadataStore<Any>)?.getMetadata(
                        it.getArgument(0)!!,
                        it.getString(1)!!
                    )
                }
                .function("hasMetadata", 2) {
                    (it.target as? MetadataStore<Any>)?.hasMetadata(
                        it.getArgument(0)!!,
                        it.getString(1)!!
                    )
                }
                .function("removeMetadata", 3) {
                    (it.target as? MetadataStore<Any>)?.removeMetadata(
                        it.getArgument(0)!!,
                        it.getString(1)!!,
                        it.getArgument(2) as Plugin
                    )
                }
                .function("invalidateAll", 1) { it.target?.invalidateAll(it.getArgument(0) as Plugin) }
        }
    }
}
