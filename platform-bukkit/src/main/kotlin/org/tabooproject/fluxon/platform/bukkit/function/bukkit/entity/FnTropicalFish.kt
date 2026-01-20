package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.DyeColor
import org.bukkit.entity.TropicalFish
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnTropicalFish {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TropicalFish::class.java)
                .function("patternColor", 0) { it.target?.patternColor }
                .function("setPatternColor", 1) { it.target?.setPatternColor(it.getArgument(0) as DyeColor) }
                .function("bodyColor", 0) { it.target?.bodyColor }
                .function("setBodyColor", 1) { it.target?.setBodyColor(it.getArgument(0) as DyeColor) }
                .function("pattern", 0) { it.target?.pattern }
                .function("setPattern", 1) { it.target?.setPattern(it.getArgument(0) as TropicalFish.Pattern) }
        }
    }
}
