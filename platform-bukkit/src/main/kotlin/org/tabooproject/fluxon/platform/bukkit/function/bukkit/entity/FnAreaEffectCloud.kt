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
                .function("duration", returnsObject().noParams()) { it.setReturnRef(it.target?.duration) }
                .function("setDuration", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDuration(it.getInt(0).toInt())) }
                .function("waitTime", returnsObject().noParams()) { it.setReturnRef(it.target?.waitTime) }
                .function("setWaitTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setWaitTime(it.getInt(0).toInt())) }
                .function("reapplicationDelay", returnsObject().noParams()) { it.setReturnRef(it.target?.reapplicationDelay) }
                .function("setReapplicationDelay", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setReapplicationDelay(it.getInt(0).toInt())) }
                .function("durationOnUse", returnsObject().noParams()) { it.setReturnRef(it.target?.durationOnUse) }
                .function("setDurationOnUse", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDurationOnUse(it.getInt(0).toInt())) }
                .function("radius", returnsObject().noParams()) { it.setReturnRef(it.target?.radius) }
                .function("setRadius", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRadius(it.getFloat(0))) }
                .function("radiusOnUse", returnsObject().noParams()) { it.setReturnRef(it.target?.radiusOnUse) }
                .function("setRadiusOnUse", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRadiusOnUse(it.getFloat(0))) }
                .function("radiusPerTick", returnsObject().noParams()) { it.setReturnRef(it.target?.radiusPerTick) }
                .function("setRadiusPerTick", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRadiusPerTick(it.getFloat(0))) }
                .function("particle", returnsObject().noParams()) { it.setReturnRef(it.target?.particle) }
                .function("setParticle", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setParticle(it.getRef(0) as Particle)) }
                .function("setBasePotionData", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBasePotionData(it.getRef(0) as PotionData)) }
                .function("basePotionData", returnsObject().noParams()) { it.setReturnRef(it.target?.basePotionData) }
                .function("setBasePotionType", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBasePotionType(it.getRef(0) as PotionType)) }
                .function("basePotionType", returnsObject().noParams()) { it.setReturnRef(it.target?.basePotionType) }
                .function("hasCustomEffects", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasCustomEffects()) }
                .function("customEffects", returnsObject().noParams()) { it.setReturnRef(it.target?.customEffects) }
                .function("addCustomEffect", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.addCustomEffect(
                        it.getRef(0) as PotionEffect,
                        it.getBool(1)
                    ))
                }
                .function("removeCustomEffect", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeCustomEffect(it.getRef(0) as PotionEffectType)) }
                .function("hasCustomEffect", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.hasCustomEffect(it.getRef(0) as PotionEffectType)) }
                .function("clearCustomEffects", returnsObject().noParams()) { it.setReturnRef(it.target?.clearCustomEffects()) }
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setColor(it.getRef(0) as Color)) }
                .function("source", returnsObject().noParams()) { it.setReturnRef(it.target?.source) }
                .function("setSource", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSource(it.getRef(0) as ProjectileSource)) }
        }
    }
}
