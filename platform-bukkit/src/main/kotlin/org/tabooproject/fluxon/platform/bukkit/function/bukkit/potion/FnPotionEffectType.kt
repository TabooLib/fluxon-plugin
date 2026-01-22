package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.NamespacedKey
import org.bukkit.potion.PotionEffectType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPotionEffectType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionEffectType::class.java)
                .function("createEffect", 2) {
                    it.target?.createEffect(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("isInstant", 0) { it.target?.isInstant }
                .function("category", 0) { it.target?.category }
                .function("color", 0) { it.target?.color }
                .function("durationModifier", 0) { it.target?.durationModifier }
                .function("id", 0) { it.target?.id }
                .function("name", 0) { it.target?.name }
                // static
                .function("getByKey", 1) { PotionEffectType.getByKey(it.getArgument(0) as NamespacedKey) }
                // static
                .function("getById", 1) { PotionEffectType.getById(it.getNumber(0).toInt()) }
                // static
                .function("getByName", 1) { PotionEffectType.getByName(it.getString(0)!!) }
                // static
                .function("values", 0) { PotionEffectType.values() }
        }
    }
}
