package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.WritableBookMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnWritableBookMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WritableBookMeta::class.java)
                .function("hasPages", 0) { it.target?.hasPages() }
                .function("page", 1) { it.target?.getPage(it.getNumber(0).toInt()) }
                .function("setPage", 2) { it.target?.setPage(it.getNumber(0).toInt(), it.getString(1)!!) }
                .function("pages", 0) { it.target?.pages }
                .function("setPages", 1) { it.target?.setPages(it.getArgument(0) as List<String>) }
                .function("setPages", 0) { it.target?.setPages() }
                .function("addPage", 0) { it.target?.addPage() }
                .function("pageCount", 0) { it.target?.pageCount }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
