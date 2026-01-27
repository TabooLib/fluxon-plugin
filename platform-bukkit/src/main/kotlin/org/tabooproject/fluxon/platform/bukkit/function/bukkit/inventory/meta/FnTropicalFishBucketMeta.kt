package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.DyeColor
import org.bukkit.entity.TropicalFish
import org.bukkit.inventory.meta.TropicalFishBucketMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.inventory.meta.TropicalFishBucketMeta"])
@PlatformSide(Platform.BUKKIT)
object FnTropicalFishBucketMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TropicalFishBucketMeta::class.java)
                .function("patternColor", 0) { it.target?.patternColor }
                .function("setPatternColor", 1) { it.target?.setPatternColor(it.getArgument(0) as DyeColor) }
                .function("bodyColor", 0) { it.target?.bodyColor }
                .function("setBodyColor", 1) { it.target?.setBodyColor(it.getArgument(0) as DyeColor) }
                .function("setPattern", 1) { it.target?.setPattern(it.getArgument(0) as TropicalFish.Pattern) }
                .function("hasVariant", 0) { it.target?.hasVariant() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
