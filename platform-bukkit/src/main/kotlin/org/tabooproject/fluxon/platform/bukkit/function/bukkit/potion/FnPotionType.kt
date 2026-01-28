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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionType::class.java)
                .function("effectType", returnsObject().noParams()) {
                    it.target?.effectType
                }
                .function("potionEffects", returnsObject().noParams()) {
                    it.target?.potionEffects
                }
                .function("isInstant", returns(Type.Z).noParams()) {
                    it.target?.isInstant
                }
                .function("isUpgradeable", returns(Type.Z).noParams()) {
                    it.target?.isUpgradeable
                }
                .function("isExtendable", returns(Type.Z).noParams()) {
                    it.target?.isExtendable
                }
                .function("maxLevel", returnsObject().noParams()) {
                    it.target?.maxLevel
                }
                // statics
                .function("getByEffect", returnsObject().params(Type.OBJECT)) { PotionType.getByEffect(it.getRef(0) as PotionEffectType) }
                .function("key", returnsObject().noParams()) { it.target?.key }
        }
    }
}
