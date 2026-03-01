package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.entity.LivingEntity
import org.bukkit.potion.PotionEffect
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.potion.PotionEffect"])
@PlatformSide(Platform.BUKKIT)
object FnPotionEffect {

    val TYPE = Type.fromClass(PotionEffect::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionEffect::class.java)
                .syncFunction("apply",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE)) {
                    it.setReturnBool(it.target?.apply(it.getRef(0) as LivingEntity) ?: false)
                }
                .function("amplifier", returns(Type.I).noParams()) { it.setReturnInt(it.target?.amplifier ?: 0) }
                .function("duration", returns(Type.I).noParams()) { it.setReturnInt(it.target?.duration ?: 0) }
                .function("isInfinite", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInfinite ?: false) }
                .function("isShorterThan",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffect.TYPE)) {
                    it.setReturnBool(it.target?.isShorterThan(it.getRef(0) as PotionEffect) ?: false)
                }
                .function("type", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffectType.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
                .function("isAmbient", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAmbient ?: false) }
                .function("hasParticles", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasParticles() ?: false) }
                .function("color", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("hasIcon", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasIcon() ?: false) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
