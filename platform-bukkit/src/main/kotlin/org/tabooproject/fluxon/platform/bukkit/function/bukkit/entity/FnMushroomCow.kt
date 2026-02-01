package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.MushroomCow
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
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

@Requires(classes = ["org.bukkit.entity.MushroomCow"])
@PlatformSide(Platform.BUKKIT)
object FnMushroomCow {

    val TYPE = Type.fromClass(MushroomCow::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MushroomCow::class.java)
                .function("hasEffectsForNextStew", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasEffectsForNextStew() ?: false) }
                .function("effectsForNextStew", returnsObject().noParams()) { it.setReturnRef(it.target?.effectsForNextStew) }
                .function("addEffectToNextStew", returns(Type.Z).params(Type.OBJECT, Type.Z)) {
                    it.setReturnBool(it.target?.addEffectToNextStew(
                        it.getRef(0) as PotionEffect,
                        it.getBool(1)
                    ) ?: false)
                }
                .function("removeEffectFromNextStew", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.removeEffectFromNextStew(it.getRef(0) as PotionEffectType) ?: false)
                }
                .function("hasEffectForNextStew", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.hasEffectForNextStew(it.getRef(0) as PotionEffectType) ?: false)
                }
                .function("clearEffectsForNextStew", returnsVoid().noParams()) { it.target?.clearEffectsForNextStew() }
                .function("variant", returnsObject().noParams()) { it.setReturnRef(it.target?.variant) }
                .function("setVariant", returnsVoid().params(Type.OBJECT)) { it.target?.setVariant(it.getRef(0) as MushroomCow.Variant) }
        }
    }
}
