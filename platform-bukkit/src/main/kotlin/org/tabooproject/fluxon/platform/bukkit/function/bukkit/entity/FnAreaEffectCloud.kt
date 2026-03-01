package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Color
import org.bukkit.Particle
import org.bukkit.entity.AreaEffectCloud
import org.bukkit.potion.PotionData
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import org.bukkit.projectiles.ProjectileSource
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.projectiles.FnProjectileSource
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.AreaEffectCloud"])
@PlatformSide(Platform.BUKKIT)
object FnAreaEffectCloud {

    val TYPE = Type.fromClass(AreaEffectCloud::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AreaEffectCloud::class.java)
                .function("duration", returns(Type.I).noParams()) { it.setReturnInt(it.target?.duration ?: 0) }
                .function("setDuration", returnsVoid().params(Type.I)) { it.target?.setDuration(it.getInt(0)) }
                .function("waitTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.waitTime ?: 0) }
                .function("setWaitTime", returnsVoid().params(Type.I)) { it.target?.setWaitTime(it.getInt(0)) }
                .function("reapplicationDelay", returns(Type.I).noParams()) { it.setReturnInt(it.target?.reapplicationDelay ?: 0) }
                .function("setReapplicationDelay", returnsVoid().params(Type.I)) { it.target?.setReapplicationDelay(it.getInt(0)) }
                .function("durationOnUse", returns(Type.I).noParams()) { it.setReturnInt(it.target?.durationOnUse ?: 0) }
                .function("setDurationOnUse", returnsVoid().params(Type.I)) { it.target?.setDurationOnUse(it.getInt(0)) }
                .function("radius", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.radius ?: 0f) }
                .function("setRadius", returnsVoid().params(Type.F)) { it.target?.setRadius(it.getFloat(0)) }
                .function("radiusOnUse", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.radiusOnUse ?: 0f) }
                .function("setRadiusOnUse", returnsVoid().params(Type.F)) { it.target?.setRadiusOnUse(it.getFloat(0)) }
                .function("radiusPerTick", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.radiusPerTick ?: 0f) }
                .function("setRadiusPerTick", returnsVoid().params(Type.F)) { it.target?.setRadiusPerTick(it.getFloat(0)) }
                .function("particle",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE).noParams()) { it.setReturnRef(it.target?.particle) }
                .function("setParticle",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE)) { it.target?.setParticle(it.getRef(0) as Particle) }
                .function("setBasePotionData",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionData.TYPE)) { it.target?.setBasePotionData(it.getRef(0) as PotionData) }
                .function("basePotionData",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionData.TYPE).noParams()) { it.setReturnRef(it.target?.basePotionData) }
                .function("setBasePotionType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionType.TYPE)) { it.target?.setBasePotionType(it.getRef(0) as PotionType) }
                .function("basePotionType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionType.TYPE).noParams()) { it.setReturnRef(it.target?.basePotionType) }
                .function("hasCustomEffects", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasCustomEffects() ?: false) }
                .function("customEffects", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.customEffects) }
                .function("addCustomEffect",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffect.TYPE, Type.Z)) {
                    it.setReturnBool(it.target?.addCustomEffect(
                        it.getRef(0) as PotionEffect,
                        it.getBool(1)
                    ) ?: false)
                }
                .function("removeCustomEffect",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffectType.TYPE)) { it.setReturnBool(it.target?.removeCustomEffect(it.getRef(0) as PotionEffectType) ?: false) }
                .function("hasCustomEffect",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffectType.TYPE)) { it.setReturnBool(it.target?.hasCustomEffect(it.getRef(0) as PotionEffectType) ?: false) }
                .function("clearCustomEffects", returnsVoid().noParams()) { it.target?.clearCustomEffects() }
                .function("color",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE)) { it.target?.setColor(it.getRef(0) as Color) }
                .function("source", returns(FnProjectileSource.TYPE).noParams()) { it.setReturnRef(it.target?.source) }
                .function("setSource", returnsVoid().params(FnProjectileSource.TYPE)) { it.target?.setSource(it.getRef(0) as ProjectileSource) }
        }
    }
}
