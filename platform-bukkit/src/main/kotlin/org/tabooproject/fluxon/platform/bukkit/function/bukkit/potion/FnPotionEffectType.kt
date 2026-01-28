package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.NamespacedKey
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

@Requires(classes = ["org.bukkit.potion.PotionEffectType"])
@PlatformSide(Platform.BUKKIT)
object FnPotionEffectType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionEffectType::class.java)
                .function("createEffect", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.createEffect(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("isInstant", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isInstant) }
                .function("category", returnsObject().noParams()) { it.setReturnRef(it.target?.category) }
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("durationModifier", returnsObject().noParams()) { it.setReturnRef(it.target?.durationModifier) }
                .function("id", returnsObject().noParams()) { it.setReturnRef(it.target?.id) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                // static
                .function("getByKey", returnsObject().params(Type.OBJECT)) { it.setReturnRef(PotionEffectType.getByKey(it.getRef(0) as NamespacedKey)) }
                // static
                .function("getById", returnsObject().params(Type.OBJECT)) { it.setReturnRef(PotionEffectType.getById(it.getInt(0).toInt())) }
                // static
                .function("getByName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(PotionEffectType.getByName(it.getString(0)!!)) }
                // static
                .function("values", returnsObject().noParams()) { it.setReturnRef(PotionEffectType.values()) }
        }
    }
}
