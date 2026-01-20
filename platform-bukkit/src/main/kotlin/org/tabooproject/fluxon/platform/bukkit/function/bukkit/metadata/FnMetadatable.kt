package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import taboolib.platform.util.getMetaFirstOrNull
import taboolib.platform.util.hasMeta
import taboolib.platform.util.removeMeta
import taboolib.platform.util.setMeta
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
                .function("setMeta", 2) {
                    it.target?.setMeta(it.getArgument(0)!!.toString(), it.getArgument(1)!!)
                }
                .function("removeMeta", 1) {
                    it.target?.removeMeta(it.getArgument(0)!!.toString())
                }
                .function("hasMeta", 1) {
                    it.target?.hasMeta(it.getArgument(0)!!.toString())
                }
                .function("getMeta", 1) {
                    it.target?.getMetaFirstOrNull(it.getArgument(0)!!.toString())?.value()
                }
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
