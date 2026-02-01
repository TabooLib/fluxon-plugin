package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.potion.PotionType"])
@PlatformSide(Platform.BUKKIT)
object FnPotionType {

    val TYPE = Type.fromClass(PotionType::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionType::class.java)
                .function("effectType", returnsObject().noParams()) { it.setReturnRef(it.target?.effectType) }
                .function("potionEffects", returnsObject().noParams()) { it.setReturnRef(it.target?.potionEffects) }
                .function("isInstant", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInstant ?: false) }
                .function("isUpgradeable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isUpgradeable ?: false) }
                .function("isExtendable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isExtendable ?: false) }
                .function("maxLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxLevel ?: 0) }
                // statics
                .function("getByEffect", returnsObject().params(Type.OBJECT)) { it.setReturnRef(PotionType.getByEffect(it.getRef(0) as PotionEffectType)) }
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
        }
    }
}
