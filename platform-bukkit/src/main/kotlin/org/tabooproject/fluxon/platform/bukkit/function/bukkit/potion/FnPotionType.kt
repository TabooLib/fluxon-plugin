package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.potion.PotionType"])
@PlatformSide(Platform.BUKKIT)
object FnPotionType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionType::class.java)
                .function("effectType", 0) {
                    it.target?.effectType
                }
                .function("potionEffects", 0) {
                    it.target?.potionEffects
                }
                .function("isInstant", 0) {
                    it.target?.isInstant
                }
                .function("isUpgradeable", 0) {
                    it.target?.isUpgradeable
                }
                .function("isExtendable", 0) {
                    it.target?.isExtendable
                }
                .function("maxLevel", 0) {
                    it.target?.maxLevel
                }
                // statics
                .function("getByEffect", 1) { PotionType.getByEffect(it.getArgument(0) as PotionEffectType) }
                .function("key", 0) { it.target?.key }
        }
    }
}
