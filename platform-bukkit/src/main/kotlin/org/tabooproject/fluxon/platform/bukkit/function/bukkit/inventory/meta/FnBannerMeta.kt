package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.block.banner.Pattern
import org.bukkit.inventory.meta.BannerMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBannerMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BannerMeta::class.java)
                .function("patterns", 0) { it.target?.patterns }
                .function("setPatterns", 1) { it.target?.setPatterns(it.getArgument(0) as List<Pattern>) }
                .function("addPattern", 1) { it.target?.addPattern(it.getArgument(0) as Pattern) }
                .function("pattern", 1) { it.target?.getPattern(it.getNumber(0).toInt()) }
                .function("removePattern", 1) { it.target?.removePattern(it.getNumber(0).toInt()) }
                .function("setPattern", 2) {
                    it.target?.setPattern(
                        it.getNumber(0).toInt(),
                        it.getArgument(1) as Pattern
                    )
                }
                .function("numberOfPatterns", 0) { it.target?.numberOfPatterns() }
        }
    }
}
