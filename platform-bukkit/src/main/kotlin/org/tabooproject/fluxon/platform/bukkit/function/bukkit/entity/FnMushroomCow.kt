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
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.MushroomCow"])
@PlatformSide(Platform.BUKKIT)
object FnMushroomCow {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MushroomCow::class.java)
                .function("hasEffectsForNextStew", returns(Type.Z).noParams()) { it.target?.hasEffectsForNextStew() }
                .function("effectsForNextStew", returnsObject().noParams()) { it.target?.effectsForNextStew }
                .function("addEffectToNextStew", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.addEffectToNextStew(
                        it.getRef(0) as PotionEffect,
                        it.getBool(1)
                    )
                }
                .function("removeEffectFromNextStew", returnsObject().params(Type.OBJECT)) { it.target?.removeEffectFromNextStew(it.getRef(0) as PotionEffectType) }
                .function("hasEffectForNextStew", returns(Type.Z).params(Type.OBJECT)) { it.target?.hasEffectForNextStew(it.getRef(0) as PotionEffectType) }
                .function("clearEffectsForNextStew", returnsObject().noParams()) { it.target?.clearEffectsForNextStew() }
                .function("variant", returnsObject().noParams()) { it.target?.variant }
                .function("setVariant", returnsObject().params(Type.OBJECT)) { it.target?.setVariant(it.getRef(0) as MushroomCow.Variant) }
        }
    }
}
