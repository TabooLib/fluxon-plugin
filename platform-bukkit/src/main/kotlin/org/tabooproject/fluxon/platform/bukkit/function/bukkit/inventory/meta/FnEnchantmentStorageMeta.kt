package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.meta.EnchantmentStorageMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEnchantmentStorageMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantmentStorageMeta::class.java)
                .function("hasStoredEnchants", 0) { it.target?.hasStoredEnchants() }
                .function("hasStoredEnchant", 1) { it.target?.hasStoredEnchant(it.getArgument(0) as Enchantment) }
                .function(
                    "storedEnchantLevel",
                    1
                ) { it.target?.getStoredEnchantLevel(it.getArgument(0) as Enchantment) }
                .function("addStoredEnchant", 3) {
                    it.target?.addStoredEnchant(
                        it.getArgument(0) as Enchantment,
                        it.getNumber(1).toInt(),
                        it.getBoolean(2)
                    )
                }
                .function("removeStoredEnchant", 1) { it.target?.removeStoredEnchant(it.getArgument(0) as Enchantment) }
                .function(
                    "hasConflictingStoredEnchant",
                    1
                ) { it.target?.hasConflictingStoredEnchant(it.getArgument(0) as Enchantment) }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
