package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import ink.ptms.adyeshach.taboolib.platform.util.getMetaFirstOrNull
import ink.ptms.adyeshach.taboolib.platform.util.hasMeta
import ink.ptms.adyeshach.taboolib.platform.util.removeMeta
import ink.ptms.adyeshach.taboolib.platform.util.setMeta
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
                // 橙汁喵: 自定义语法, 这个语法并不在Bukkit中存在
                .function("setMeta", 2) {
                    it.target?.setMeta(it.getArgument(0)!!.toString(), it.getArgument(1)!!)
                }
                // 橙汁喵: 自定义语法, 这个语法并不在Bukkit中存在
                .function("removeMeta", 1) {
                    it.target?.removeMeta(it.getArgument(0)!!.toString())
                }
                // 橙汁喵: 自定义语法, 这个语法并不在Bukkit中存在
                .function("hasMeta", 1) {
                    it.target?.hasMeta(it.getArgument(0)!!.toString())
                }
                // 橙汁喵: 自定义语法, 这个语法并不在Bukkit中存在
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
