package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.Color
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionData
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPotionMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionMeta::class.java)
                .function("setBasePotionData", 1) { it.target?.setBasePotionData(it.getArgument(0) as PotionData) }
                .function("basePotionData", 0) { it.target?.basePotionData }
                .function("setBasePotionType", 1) { it.target?.setBasePotionType(it.getArgument(0) as PotionType) }
                .function("basePotionType", 0) { it.target?.basePotionType }
                .function("hasBasePotionType", 0) { it.target?.hasBasePotionType() }
                .function("hasCustomEffects", 0) { it.target?.hasCustomEffects() }
                .function("customEffects", 0) { it.target?.customEffects }
                .function("addCustomEffect", 2) {
                    it.target?.addCustomEffect(
                        it.getArgument(0) as PotionEffect,
                        it.getBoolean(1)
                    )
                }
                .function(
                    "removeCustomEffect",
                    1
                ) { it.target?.removeCustomEffect(it.getArgument(0) as PotionEffectType) }
                .function("hasCustomEffect", 1) { it.target?.hasCustomEffect(it.getArgument(0) as PotionEffectType) }
                .function("setMainEffect", 1) { it.target?.setMainEffect(it.getArgument(0) as PotionEffectType) }
                .function("clearCustomEffects", 0) { it.target?.clearCustomEffects() }
                .function("hasColor", 0) { it.target?.hasColor() }
                .function("color", 0) { it.target?.color }
                .function("setColor", 1) { it.target?.setColor(it.getArgument(0) as Color) }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
