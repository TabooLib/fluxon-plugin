package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.Color
import org.bukkit.inventory.meta.PotionMeta
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

@Requires(classes = ["org.bukkit.inventory.meta.PotionMeta"])
@PlatformSide(Platform.BUKKIT)
object FnPotionMeta {

    val TYPE = Type.fromClass(PotionMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionMeta::class.java)
                .function("setBasePotionData",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionData.TYPE)) { it.target?.setBasePotionData(it.getRef(0) as PotionData) }
                .function("basePotionData",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionData.TYPE).noParams()) { it.setReturnRef(it.target?.basePotionData) }
                .function("setBasePotionType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionType.TYPE)) { it.target?.setBasePotionType(it.getRef(0) as PotionType) }
                .function("basePotionType",returns(Type.Z).noParams()) { it.setReturnRef(it.target?.basePotionType) }
                .function("hasBasePotionType", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasBasePotionType() ?: false) }
                .function("hasCustomEffects", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasCustomEffects() ?: false) }
                .function("customEffects", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.customEffects) }
                .function("addCustomEffect",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffect.TYPE, Type.Z)) {
                    it.setReturnBool(it.target?.addCustomEffect(
                        it.getRef(0) as PotionEffect,
                        it.getBool(1)
                    ) ?: false)
                }
                .function("removeCustomEffect",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffectType.TYPE)) {
                    it.setReturnBool(it.target?.removeCustomEffect(it.getRef(0) as PotionEffectType) ?: false)
                }
                .function("hasCustomEffect",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffectType.TYPE)) {
                    it.setReturnBool(it.target?.hasCustomEffect(it.getRef(0) as PotionEffectType) ?: false)
                }
                .function("setMainEffect",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffectType.TYPE)) { it.target?.setMainEffect(it.getRef(0) as PotionEffectType) }
                .function("clearCustomEffects", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.clearCustomEffects() ?: false) }
                .function("hasColor", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasColor() ?: false) }
                .function("color", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE)) { it.target?.setColor(it.getRef(0) as Color) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnPotionMeta.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
