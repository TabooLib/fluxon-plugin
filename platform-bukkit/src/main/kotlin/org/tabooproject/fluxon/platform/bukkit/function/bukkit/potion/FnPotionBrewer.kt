package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.potion.PotionBrewer
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.potion.PotionBrewer"])
@PlatformSide(Platform.BUKKIT)
object FnPotionBrewer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionBrewer::class.java)
                .function("createEffect", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.createEffect(
                        it.getRef(0) as PotionEffectType,
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getEffectsFromDamage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getEffectsFromDamage(it.getInt(0).toInt())) }
                .function("getEffects", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getEffects(
                        it.getRef(0) as PotionType,
                        it.getBool(1),
                        it.getBool(2)
                    ))
                }
        }
    }
}
