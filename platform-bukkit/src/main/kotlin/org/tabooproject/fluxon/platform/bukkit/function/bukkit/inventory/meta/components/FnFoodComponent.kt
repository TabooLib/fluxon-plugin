package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.components

import org.bukkit.inventory.meta.components.FoodComponent
import org.bukkit.potion.PotionEffect
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnFoodComponent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FoodComponent::class.java)
                .function("nutrition", 0) { it.target?.nutrition }
                .function("setNutrition", 1) { it.target?.setNutrition(it.getNumber(0).toInt()) }
                .function("saturation", 0) { it.target?.saturation }
                .function("setSaturation", 1) { it.target?.setSaturation(it.getNumber(0).toFloat()) }
                .function("canAlwaysEat", 0) { it.target?.canAlwaysEat() }
                .function("setCanAlwaysEat", 1) { it.target?.setCanAlwaysEat(it.getBoolean(0)) }
                .function("eatSeconds", 0) { it.target?.eatSeconds }
                .function("setEatSeconds", 1) { it.target?.setEatSeconds(it.getNumber(0).toFloat()) }
                .function("effects", 0) { it.target?.effects }
                .function(
                    "setEffects",
                    1
                ) { it.target?.setEffects(it.getArgument(0) as List<FoodComponent.FoodEffect>) }
                .function("addEffect", 2) {
                    it.target?.addEffect(
                        it.getArgument(0) as PotionEffect,
                        it.getNumber(1).toFloat()
                    )
                }

            registerExtension(FoodComponent.FoodEffect::class.java)
                .function("effect", 0) { it.target?.effect }
                .function("setEffect", 1) { it.target?.setEffect(it.getArgument(0) as PotionEffect) }
                .function("probability", 0) { it.target?.probability }
                .function("setProbability", 1) { it.target?.setProbability(it.getNumber(0).toFloat()) }
        }
    }
}
