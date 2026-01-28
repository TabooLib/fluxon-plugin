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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SuspiciousStewMeta::class.java)
                .function("hasCustomEffects", returns(Type.Z).noParams()) { it.target?.hasCustomEffects() }
                .function("customEffects", returnsObject().noParams()) { it.target?.customEffects }
                .function("addCustomEffect", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.addCustomEffect(
                        it.getRef(0) as PotionEffect,
                        it.getBool(1)
                    )
                }
                .function("removeCustomEffect", returnsObject().params(Type.OBJECT)) { it.target?.removeCustomEffect(it.getRef(0) as PotionEffectType) }
                .function("hasCustomEffect", returns(Type.Z).params(Type.OBJECT)) { it.target?.hasCustomEffect(it.getRef(0) as PotionEffectType) }
                .function("clearCustomEffects", returnsObject().noParams()) { it.target?.clearCustomEffects() }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
