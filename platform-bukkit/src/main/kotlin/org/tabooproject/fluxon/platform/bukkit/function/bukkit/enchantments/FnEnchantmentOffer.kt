package org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments

import org.bukkit.enchantments.Enchantment
import org.bukkit.enchantments.EnchantmentOffer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEnchantmentOffer {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantmentOffer::class.java)
                .function("enchantment", 0) { it.target?.enchantment }
                .function("setEnchantment", 1) { it.target?.setEnchantment(it.getArgument(0) as Enchantment) }
                .function("enchantmentLevel", 0) { it.target?.enchantmentLevel }
                .function("setEnchantmentLevel", 1) { it.target?.setEnchantmentLevel(it.getNumber(0).toInt()) }
                .function("cost", 0) { it.target?.cost }
                .function("setCost", 1) { it.target?.setCost(it.getNumber(0).toInt()) }
        }
    }
}
