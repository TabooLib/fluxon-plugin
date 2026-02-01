package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Color
import org.bukkit.entity.Arrow
import org.bukkit.potion.PotionData
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Arrow"])
@PlatformSide(Platform.BUKKIT)
object FnArrow {

    val TYPE = Type.fromClass(Arrow::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Arrow::class.java)
                .function("setBasePotionData", returnsVoid().params(Type.OBJECT)) { it.target?.setBasePotionData(it.getRef(0) as PotionData) }
                .function("basePotionData", returnsObject().noParams()) { it.setReturnRef(it.target?.basePotionData) }
                .function("setBasePotionType", returnsVoid().params(Type.OBJECT)) { it.target?.setBasePotionType(it.getRef(0) as PotionType) }
                .function("basePotionType", returnsObject().noParams()) { it.setReturnRef(it.target?.basePotionType) }
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsVoid().params(Type.OBJECT)) { it.target?.setColor(it.getRef(0) as Color) }
                .function("hasCustomEffects", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasCustomEffects() ?: false) }
                .function("customEffects", returnsObject().noParams()) { it.setReturnRef(it.target?.customEffects) }
                .function("addCustomEffect", returns(Type.Z).params(Type.OBJECT, Type.Z)) {
                    it.setReturnBool(it.target?.addCustomEffect(
                        it.getRef(0) as PotionEffect,
                        it.getBool(1)
                    ) ?: false)
                }
                .function("removeCustomEffect", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.removeCustomEffect(it.getRef(0) as PotionEffectType) ?: false) }
                .function("hasCustomEffect", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.hasCustomEffect(it.getRef(0) as PotionEffectType) ?: false) }
                .function("clearCustomEffects", returnsVoid().noParams()) { it.target?.clearCustomEffects() }
        }
    }
}
