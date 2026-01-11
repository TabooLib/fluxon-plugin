package org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments

import org.bukkit.enchantments.EnchantmentTarget
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEnchantmentTarget {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantmentTarget::class.java)
                .function("includes", 1) {
                    // boolean includes(@NotNull Material item)
                    // boolean includes(@NotNull ItemStack item)
                    TODO()
                }
        }
    }
}
