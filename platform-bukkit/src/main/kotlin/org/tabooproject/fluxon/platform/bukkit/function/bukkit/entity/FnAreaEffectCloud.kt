package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Color
import org.bukkit.Particle
import org.bukkit.entity.AreaEffectCloud
import org.bukkit.potion.PotionData
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import org.bukkit.projectiles.ProjectileSource
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.AreaEffectCloud"])
@PlatformSide(Platform.BUKKIT)
object FnAreaEffectCloud {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AreaEffectCloud::class.java)
                .function("duration", 0) { it.target?.duration }
                .function("setDuration", 1) { it.target?.setDuration(it.getNumber(0).toInt()) }
                .function("waitTime", 0) { it.target?.waitTime }
                .function("setWaitTime", 1) { it.target?.setWaitTime(it.getNumber(0).toInt()) }
                .function("reapplicationDelay", 0) { it.target?.reapplicationDelay }
                .function("setReapplicationDelay", 1) { it.target?.setReapplicationDelay(it.getNumber(0).toInt()) }
                .function("durationOnUse", 0) { it.target?.durationOnUse }
                .function("setDurationOnUse", 1) { it.target?.setDurationOnUse(it.getNumber(0).toInt()) }
                .function("radius", 0) { it.target?.radius }
                .function("setRadius", 1) { it.target?.setRadius(it.getNumber(0).toFloat()) }
                .function("radiusOnUse", 0) { it.target?.radiusOnUse }
                .function("setRadiusOnUse", 1) { it.target?.setRadiusOnUse(it.getNumber(0).toFloat()) }
                .function("radiusPerTick", 0) { it.target?.radiusPerTick }
                .function("setRadiusPerTick", 1) { it.target?.setRadiusPerTick(it.getNumber(0).toFloat()) }
                .function("particle", 0) { it.target?.particle }
                .function("setParticle", 1) { it.target?.setParticle(it.getArgument(0) as Particle) }
                .function("setBasePotionData", 1) { it.target?.setBasePotionData(it.getArgument(0) as PotionData) }
                .function("basePotionData", 0) { it.target?.basePotionData }
                .function("setBasePotionType", 1) { it.target?.setBasePotionType(it.getArgument(0) as PotionType) }
                .function("basePotionType", 0) { it.target?.basePotionType }
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
                .function("color", 0) { it.target?.color }
                .function("setColor", 1) { it.target?.setColor(it.getArgument(0) as Color) }
                .function("source", 0) { it.target?.source }
                .function("setSource", 1) { it.target?.setSource(it.getArgument(0) as ProjectileSource) }
        }
    }
}
