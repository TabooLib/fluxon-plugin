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
import taboolib.library.xseries.XPotion
import kotlin.jvm.optionals.getOrNull

@Requires(classes = ["org.bukkit.potion.PotionEffectType"])
@PlatformSide(Platform.BUKKIT)
object FnPotionEffectType {

    val TYPE = Type.fromClass(PotionEffectType::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionEffectType::class.java)
                .function("createEffect",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffect.TYPE).params(Type.I, Type.I)) {
                    it.setReturnRef(it.target?.createEffect(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("isInstant", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInstant ?: false) }
                .function("category", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffectTypeCategory.TYPE).noParams()) { it.setReturnRef(it.target?.category) }
                .function("color",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("durationModifier",returns(Type.D).noParams()) { it.setReturnRef(it.target?.durationModifier) }
                .function("id",returns(Type.I).noParams()) { it.setReturnRef(it.target?.id) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
        }
    }

    fun enumValue(value: String): PotionEffectType? {
        return XPotion.of(value).getOrNull()?.get()
    }
}
