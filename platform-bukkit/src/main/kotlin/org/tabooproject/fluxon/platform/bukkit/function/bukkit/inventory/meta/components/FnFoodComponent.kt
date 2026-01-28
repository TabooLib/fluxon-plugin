package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.components

import org.bukkit.inventory.meta.components.FoodComponent
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

@Requires(classes = ["org.bukkit.inventory.meta.components.FoodComponent"])
@PlatformSide(Platform.BUKKIT)
object FnFoodComponent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FoodComponent::class.java)
                .function("nutrition", returnsObject().noParams()) { it.setReturnRef(it.target?.nutrition) }
                .function("setNutrition", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setNutrition(it.getInt(0).toInt())) }
                .function("saturation", returnsObject().noParams()) { it.setReturnRef(it.target?.saturation) }
                .function("setSaturation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSaturation(it.getFloat(0))) }
                .function("canAlwaysEat", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.canAlwaysEat()) }
                .function("setCanAlwaysEat", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCanAlwaysEat(it.getBool(0))) }
                .function("eatSeconds", returnsObject().noParams()) { it.setReturnRef(it.target?.eatSeconds) }
                .function("setEatSeconds", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setEatSeconds(it.getFloat(0))) }
                .function("effects", returnsObject().noParams()) { it.setReturnRef(it.target?.effects) }
                .function("setEffects", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setEffects(it.getRef(0) as List<FoodComponent.FoodEffect>)) }
                .function("addEffect", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.addEffect(
                        it.getRef(0) as PotionEffect,
                        it.getFloat(1)
                    ))
                }
        }
    }
}

@Requires(classes = ["org.bukkit.inventory.meta.components.FoodComponent.FoodEffect"])
@PlatformSide(Platform.BUKKIT)
object FnFoodComponentFoodEffect {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FoodComponent.FoodEffect::class.java)
                .function("effect", returnsObject().noParams()) { it.setReturnRef(it.target?.effect) }
                .function("setEffect", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setEffect(it.getRef(0) as PotionEffect)) }
                .function("probability", returnsObject().noParams()) { it.setReturnRef(it.target?.probability) }
                .function("setProbability", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setProbability(it.getFloat(0))) }
        }
    }
}
