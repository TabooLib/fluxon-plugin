package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.BookMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBookMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BookMeta::class.java)
                .function("hasTitle", 0) { it.target?.hasTitle() }
                .function("title", 0) { it.target?.title }
                .function("setTitle", 1) { it.target?.setTitle(it.getString(0)) }
                .function("hasAuthor", 0) { it.target?.hasAuthor() }
                .function("author", 0) { it.target?.author }
                .function("setAuthor", 1) { it.target?.setAuthor(it.getString(0)) }
                .function("hasGeneration", 0) { it.target?.hasGeneration() }
                .function("generation", 0) { it.target?.generation }
                .function("setGeneration", 1) { it.target?.setGeneration(it.getArgument(0) as BookMeta.Generation) }
                .function("clone", 0) { it.target?.clone() }
                .function("getPage", 1) { it.target?.getPage(it.getNumber(0).toInt()) }
                .function("setPage", 2) { it.target?.setPage(it.getNumber(0).toInt(), it.getString(1)!!) }
                .function("pages", 0) { it.target?.pages }
                .function("setPages", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.setPages(*(it.arguments as Array<String>))
                    } else {
                        it.target?.setPages(it.getArgument(0) as List<String>)
                    }
                }
                .function("addPage", 0) { it.target?.addPage(*(it.arguments as Array<String>)) }
        }
    }
}
