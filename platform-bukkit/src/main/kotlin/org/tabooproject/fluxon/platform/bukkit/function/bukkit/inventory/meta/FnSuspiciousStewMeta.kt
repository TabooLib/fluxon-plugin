package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.SuspiciousStewMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.inventory.meta.SuspiciousStewMeta"])
@PlatformSide(Platform.BUKKIT)
object FnSuspiciousStewMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SuspiciousStewMeta::class.java)
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
                .function("clearCustomEffects", 0) { it.target?.clearCustomEffects() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
