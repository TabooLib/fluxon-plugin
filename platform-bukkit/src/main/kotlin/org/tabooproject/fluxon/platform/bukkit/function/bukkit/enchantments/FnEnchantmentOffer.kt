package org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments

import org.bukkit.enchantments.Enchantment
import org.bukkit.enchantments.EnchantmentOffer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.enchantments.EnchantmentOffer"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantmentOffer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantmentOffer::class.java)
                .function("enchantment", returnsObject().noParams()) { it.target?.enchantment }
                .function("setEnchantment", returnsObject().params(Type.OBJECT)) { it.target?.setEnchantment(it.getRef(0) as Enchantment) }
                .function("enchantmentLevel", returnsObject().noParams()) { it.target?.enchantmentLevel }
                .function("setEnchantmentLevel", returnsObject().params(Type.OBJECT)) { it.target?.setEnchantmentLevel(it.getInt(0).toInt()) }
                .function("cost", returnsObject().noParams()) { it.target?.cost }
                .function("setCost", returnsObject().params(Type.OBJECT)) { it.target?.setCost(it.getInt(0).toInt()) }
        }
    }
}
