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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionEffect::class.java)
                .syncFunction("apply", returnsObject().params(Type.OBJECT)) { it.target?.apply(it.getRef(0) as LivingEntity) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.target?.equals(it.getRef(0)) }
                .function("amplifier", returnsObject().noParams()) { it.target?.amplifier }
                .function("duration", returnsObject().noParams()) { it.target?.duration }
                .function("isInfinite", returns(Type.Z).noParams()) { it.target?.isInfinite }
                .function("isShorterThan", returns(Type.Z).params(Type.OBJECT)) { it.target?.isShorterThan(it.getRef(0) as PotionEffect) }
                .function("type", returnsObject().noParams()) { it.target?.type }
                .function("isAmbient", returns(Type.Z).noParams()) { it.target?.isAmbient }
                .function("hasParticles", returns(Type.Z).noParams()) { it.target?.hasParticles() }
                .function("color", returnsObject().noParams()) { it.target?.color }
                .function("hasIcon", returns(Type.Z).noParams()) { it.target?.hasIcon() }
                .function("hashCode", returns(Type.I).noParams()) { it.target?.hashCode() }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
        }
    }
}
