package org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments

import org.bukkit.enchantments.Enchantment
import org.bukkit.enchantments.EnchantmentOffer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.enchantments.EnchantmentOffer"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantmentOffer {

    val TYPE = Type.fromClass(EnchantmentOffer::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantmentOffer::class.java)
                .function("enchantment", returnsObject().noParams()) { it.setReturnRef(it.target?.enchantment) }
                .function("setEnchantment", returnsVoid().params(Type.OBJECT)) { it.target?.setEnchantment(it.getRef(0) as Enchantment) }
                .function("enchantmentLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.enchantmentLevel ?: 0) }
                .function("setEnchantmentLevel", returnsVoid().params(Type.I)) { it.target?.setEnchantmentLevel(it.getInt(0).toInt()) }
                .function("cost", returns(Type.I).noParams()) { it.setReturnInt(it.target?.cost ?: 0) }
                .function("setCost", returnsVoid().params(Type.I)) { it.target?.setCost(it.getInt(0).toInt()) }
        }
    }
}
