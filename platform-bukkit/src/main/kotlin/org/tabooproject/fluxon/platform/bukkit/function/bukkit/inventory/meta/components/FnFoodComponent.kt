package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.components

import org.bukkit.inventory.meta.components.FoodComponent
import org.bukkit.potion.PotionEffect
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.components.FoodComponent"])
@PlatformSide(Platform.BUKKIT)
object FnFoodComponent {

    val TYPE = Type.fromClass(FoodComponent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FoodComponent::class.java)
                .function("nutrition", returns(Type.I).noParams()) { it.setReturnInt(it.target?.nutrition ?: 0) }
                .function("setNutrition", returnsVoid().params(Type.I)) { it.target?.setNutrition(it.getInt(0)) }
                .function("saturation", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.saturation ?: 0f) }
                .function("setSaturation", returnsVoid().params(Type.F)) { it.target?.setSaturation(it.getFloat(0)) }
                .function("canAlwaysEat", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canAlwaysEat() ?: false) }
                .function("setCanAlwaysEat", returnsVoid().params(Type.Z)) { it.target?.setCanAlwaysEat(it.getBool(0)) }
                .function("eatSeconds", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.eatSeconds ?: 0f) }
                .function("setEatSeconds", returnsVoid().params(Type.F)) { it.target?.setEatSeconds(it.getFloat(0)) }
                .function("effects", returnsObject().noParams()) { it.setReturnRef(it.target?.effects) }
                .function("setEffects", returnsVoid().params(Type.OBJECT)) { it.target?.setEffects(it.getRef(0) as List<FoodComponent.FoodEffect>) }
                .function("addEffect", returnsVoid().params(Type.OBJECT, Type.F)) {
                    it.target?.addEffect(
                        it.getRef(0) as PotionEffect,
                        it.getFloat(1)
                    )
                }
        }
    }
}

@Requires(classes = ["org.bukkit.inventory.meta.components.FoodComponent.FoodEffect"])
@PlatformSide(Platform.BUKKIT)
object FnFoodComponentFoodEffect {

    val TYPE = Type.fromClass(FoodComponent.FoodEffect::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FoodComponent.FoodEffect::class.java)
                .function("effect", returnsObject().noParams()) { it.setReturnRef(it.target?.effect) }
                .function("setEffect", returnsVoid().params(Type.OBJECT)) { it.target?.setEffect(it.getRef(0) as PotionEffect) }
                .function("probability", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.probability ?: 0f) }
                .function("setProbability", returnsVoid().params(Type.F)) { it.target?.setProbability(it.getFloat(0)) }
        }
    }
}
