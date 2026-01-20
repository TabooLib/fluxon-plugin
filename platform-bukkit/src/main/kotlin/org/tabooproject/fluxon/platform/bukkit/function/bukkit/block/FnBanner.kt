package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.DyeColor
import org.bukkit.block.Banner
import org.bukkit.block.banner.Pattern
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBanner {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Banner::class.java)
                .function("baseColor", 0) { it.target?.baseColor }
                .function("setBaseColor", 1) { it.target?.setBaseColor(it.getArgument(0) as DyeColor) }
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
