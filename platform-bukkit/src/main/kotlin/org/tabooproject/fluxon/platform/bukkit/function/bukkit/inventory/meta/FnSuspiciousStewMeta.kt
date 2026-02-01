package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.SuspiciousStewMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.SuspiciousStewMeta"])
@PlatformSide(Platform.BUKKIT)
object FnSuspiciousStewMeta {

    val TYPE = Type.fromClass(SuspiciousStewMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SuspiciousStewMeta::class.java)
                .function("hasCustomEffects", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasCustomEffects() ?: false) }
                .function("customEffects", returnsObject().noParams()) { it.setReturnRef(it.target?.customEffects) }
                .function("addCustomEffect", returns(Type.Z).params(Type.OBJECT, Type.Z)) {
                    it.setReturnBool(it.target?.addCustomEffect(
                        it.getRef(0) as PotionEffect,
                        it.getBool(1)
                    ) ?: false)
                }
                .function("removeCustomEffect", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.removeCustomEffect(it.getRef(0) as PotionEffectType) ?: false)
                }
                .function("hasCustomEffect", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.hasCustomEffect(it.getRef(0) as PotionEffectType) ?: false)
                }
                .function("clearCustomEffects", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.clearCustomEffects() ?: false) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
