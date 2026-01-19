package org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments

import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEnchantment {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Enchantment::class.java)
                .function("name", 0) { it.target?.name }
                .function("maxLevel", 0) { it.target?.maxLevel }
                .function("startLevel", 0) { it.target?.startLevel }
                .function("itemTarget", 0) { it.target?.itemTarget }
                .function("isTreasure", 0) { it.target?.isTreasure }
                .function("isCursed", 0) { it.target?.isCursed }
                .function("conflictsWith", 1) { it.target?.conflictsWith(it.getArgument(0) as Enchantment) }
                .function("canEnchantItem", 1) { it.target?.canEnchantItem(it.getArgument(0) as ItemStack) }
                // static
                .function("byKey", 1) { Enchantment.getByKey(it.getArgument(0) as NamespacedKey) }
                // static
                .function("byName", 1) { Enchantment.getByName(it.getString(0)) }
                // static
                .function("values", 0) { Enchantment.values() }
        }
    }
}
