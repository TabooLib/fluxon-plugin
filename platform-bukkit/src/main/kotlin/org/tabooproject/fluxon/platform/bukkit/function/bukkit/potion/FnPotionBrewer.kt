package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.potion.PotionBrewer
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPotionBrewer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionBrewer::class.java)
                .function("createEffect", 3) {
                    it.target?.createEffect(
                        it.getArgument(0) as PotionEffectType,
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("getEffectsFromDamage", 1) { it.target?.getEffectsFromDamage(it.getNumber(0).toInt()) }
                .function("getEffects", 3) {
                    it.target?.getEffects(
                        it.getArgument(0) as PotionType,
                        it.getBoolean(1),
                        it.getBoolean(2)
                    )
                }
        }
    }
}
