package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.MushroomCow
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMushroomCow {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MushroomCow::class.java)
                .function("hasEffectsForNextStew", 0) { it.target?.hasEffectsForNextStew() }
                .function("effectsForNextStew", 0) { it.target?.effectsForNextStew }
                .function("addEffectToNextStew", 2) {
                    it.target?.addEffectToNextStew(
                        it.getArgument(0) as PotionEffect,
                        it.getBoolean(1)
                    )
                }
                .function(
                    "removeEffectFromNextStew",
                    1
                ) { it.target?.removeEffectFromNextStew(it.getArgument(0) as PotionEffectType) }
                .function(
                    "hasEffectForNextStew",
                    1
                ) { it.target?.hasEffectForNextStew(it.getArgument(0) as PotionEffectType) }
                .function("clearEffectsForNextStew", 0) { it.target?.clearEffectsForNextStew() }
                .function("variant", 0) { it.target?.variant }
                .function("setVariant", 1) { it.target?.setVariant(it.getArgument(0) as MushroomCow.Variant) }
        }
    }
}
