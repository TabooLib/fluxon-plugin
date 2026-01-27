package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.entity.LivingEntity
import org.bukkit.potion.PotionEffect
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.potion.PotionEffect"])
@PlatformSide(Platform.BUKKIT)
object FnPotionEffect {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionEffect::class.java)
                .syncFunction("apply", 1) { it.target?.apply(it.getArgument(0) as LivingEntity) }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("amplifier", 0) { it.target?.amplifier }
                .function("duration", 0) { it.target?.duration }
                .function("isInfinite", 0) { it.target?.isInfinite }
                .function("isShorterThan", 1) { it.target?.isShorterThan(it.getArgument(0) as PotionEffect) }
                .function("type", 0) { it.target?.type }
                .function("isAmbient", 0) { it.target?.isAmbient }
                .function("hasParticles", 0) { it.target?.hasParticles() }
                .function("color", 0) { it.target?.color }
                .function("hasIcon", 0) { it.target?.hasIcon() }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
