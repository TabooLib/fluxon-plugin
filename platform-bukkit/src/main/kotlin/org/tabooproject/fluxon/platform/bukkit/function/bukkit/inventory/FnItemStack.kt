package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnItemStack {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemStack::class.java)
//                .function("name", 0) { it.target?.itemMeta?.displayName ?: it.target?.getI18 nName() } // TODO: setter
                .function("type", 0) { it.target?.type }
                .function("setType", 1) { it.target?.setType(it.getArgument(0) as Material) }
                .function("amount", 0) { it.target?.amount }
                .function("setAmount", 1) { it.target?.setAmount(it.getNumber(0).toInt()) }
                .function("data", 0) { it.target?.data }
                .function("setData", 1) { it.target?.setData(it.getArgument(0) as MaterialData) }
                .function("setDurability", 1) { it.target?.setDurability(it.getNumber(0).toShort()) }
                .function("durability", 0) { it.target?.durability }
                .function("maxStackSize", 0) { it.target?.maxStackSize }
                .function("toString", 0) { it.target?.toString() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("isSimilar", 1) { it.target?.isSimilar(it.getArgument(0) as ItemStack) }
                .function("clone", 0) { it.target?.clone() }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("containsEnchantment", 1) { it.target?.containsEnchantment(it.getArgument(0) as Enchantment) }
                .function("enchantments", 0) { it.target?.enchantments }
                .function("getEnchantmentLevel", 1) { it.target?.getEnchantmentLevel(it.getArgument(0) as Enchantment) }
                .function(
                    "addEnchantments",
                    1
                ) { it.target?.addEnchantments(it.getArgument(0) as Map<Enchantment, Int>) }
                .function("addEnchantment", 2) {
                    it.target?.addEnchantment(
                        it.getArgument(0) as Enchantment,
                        it.getNumber(1).toInt()
                    )
                }
                .function(
                    "addUnsafeEnchantments",
                    1
                ) { it.target?.addUnsafeEnchantments(it.getArgument(0) as Map<Enchantment, Int>) }
                .function("addUnsafeEnchantment", 2) {
                    it.target?.addUnsafeEnchantment(
                        it.getArgument(0) as Enchantment,
                        it.getNumber(1).toInt()
                    )
                }
                .function("removeEnchantment", 1) { it.target?.removeEnchantment(it.getArgument(0) as Enchantment) }
                .function("removeEnchantments", 0) { it.target?.removeEnchantments() }
                .function("serialize", 0) { it.target?.serialize() }
                // static
                .function("deserialize", 1) { ItemStack.deserialize(it.getArgument(0) as Map<String, Any>) }
                .function("itemMeta", 0) { it.target?.itemMeta }
                .function("hasItemMeta", 0) { it.target?.hasItemMeta() }
                .function("setItemMeta", 1) { it.target?.setItemMeta(it.getArgument(0) as ItemMeta) }
                .function("translationKey", 0) { it.target?.translationKey }
        }
    }
}
