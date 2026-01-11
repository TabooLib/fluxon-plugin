package org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments

import org.bukkit.enchantments.EnchantmentWrapper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEnchantmentWrapper {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantmentWrapper::class.java)
                .function("enchantment", 0) { it.target?.enchantment }
        }
    }
}
