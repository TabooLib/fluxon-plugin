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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.AreaEffectCloud"])
@PlatformSide(Platform.BUKKIT)
object FnAreaEffectCloud {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AreaEffectCloud::class.java)
                .function("duration", returnsObject().noParams()) { it.target?.duration }
                .function("setDuration", returnsObject().params(Type.OBJECT)) { it.target?.setDuration(it.getInt(0).toInt()) }
                .function("waitTime", returnsObject().noParams()) { it.target?.waitTime }
                .function("setWaitTime", returnsObject().params(Type.OBJECT)) { it.target?.setWaitTime(it.getInt(0).toInt()) }
                .function("reapplicationDelay", returnsObject().noParams()) { it.target?.reapplicationDelay }
                .function("setReapplicationDelay", returnsObject().params(Type.OBJECT)) { it.target?.setReapplicationDelay(it.getInt(0).toInt()) }
                .function("durationOnUse", returnsObject().noParams()) { it.target?.durationOnUse }
                .function("setDurationOnUse", returnsObject().params(Type.OBJECT)) { it.target?.setDurationOnUse(it.getInt(0).toInt()) }
                .function("radius", returnsObject().noParams()) { it.target?.radius }
                .function("setRadius", returnsObject().params(Type.OBJECT)) { it.target?.setRadius(it.getFloat(0)) }
                .function("radiusOnUse", returnsObject().noParams()) { it.target?.radiusOnUse }
                .function("setRadiusOnUse", returnsObject().params(Type.OBJECT)) { it.target?.setRadiusOnUse(it.getFloat(0)) }
                .function("radiusPerTick", returnsObject().noParams()) { it.target?.radiusPerTick }
                .function("setRadiusPerTick", returnsObject().params(Type.OBJECT)) { it.target?.setRadiusPerTick(it.getFloat(0)) }
                .function("particle", returnsObject().noParams()) { it.target?.particle }
                .function("setParticle", returnsObject().params(Type.OBJECT)) { it.target?.setParticle(it.getRef(0) as Particle) }
                .function("setBasePotionData", returnsObject().params(Type.OBJECT)) { it.target?.setBasePotionData(it.getRef(0) as PotionData) }
                .function("basePotionData", returnsObject().noParams()) { it.target?.basePotionData }
                .function("setBasePotionType", returnsObject().params(Type.OBJECT)) { it.target?.setBasePotionType(it.getRef(0) as PotionType) }
                .function("basePotionType", returnsObject().noParams()) { it.target?.basePotionType }
                .function("hasCustomEffects", returns(Type.Z).noParams()) { it.target?.hasCustomEffects() }
                .function("customEffects", returnsObject().noParams()) { it.target?.customEffects }
                .function("addCustomEffect", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.addCustomEffect(
                        it.getRef(0) as PotionEffect,
                        it.getBool(1)
                    )
                }
                .function("removeCustomEffect", returnsObject().params(Type.OBJECT)) { it.target?.removeCustomEffect(it.getRef(0) as PotionEffectType) }
                .function("hasCustomEffect", returns(Type.Z).params(Type.OBJECT)) { it.target?.hasCustomEffect(it.getRef(0) as PotionEffectType) }
                .function("clearCustomEffects", returnsObject().noParams()) { it.target?.clearCustomEffects() }
                .function("color", returnsObject().noParams()) { it.target?.color }
                .function("setColor", returnsObject().params(Type.OBJECT)) { it.target?.setColor(it.getRef(0) as Color) }
                .function("source", returnsObject().noParams()) { it.target?.source }
                .function("setSource", returnsObject().params(Type.OBJECT)) { it.target?.setSource(it.getRef(0) as ProjectileSource) }
        }
    }
}
