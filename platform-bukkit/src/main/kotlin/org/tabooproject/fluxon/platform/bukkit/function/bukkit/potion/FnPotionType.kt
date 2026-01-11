package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPotionType {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionType::class.java)
                .function("effectType", 0) {
                    // PotionEffectType getEffectType()
                    // PotionEffectType getEffectType()
                    TODO()
                }
                .function("potionEffects", 0) {
                    // List<PotionEffect> getPotionEffects()
                    // List<PotionEffect> getPotionEffects()
                    TODO()
                }
                .function("isInstant", 0) {
                    // boolean isInstant()
                    // boolean isInstant()
                    TODO()
                }
                .function("isUpgradeable", 0) {
                    // boolean isUpgradeable()
                    // boolean isUpgradeable()
                    TODO()
                }
                .function("isExtendable", 0) {
                    // boolean isExtendable()
                    // boolean isExtendable()
                    TODO()
                }
                .function("maxLevel", 0) {
                    // int getMaxLevel()
                    // int getMaxLevel()
                    TODO()
                }
                // static
                .function("byEffect", 1) { PotionType.getByEffect(it.getArgument(0) as PotionEffectType) }
                .function("key", 0) { it.target?.key }
        }
    }
}
