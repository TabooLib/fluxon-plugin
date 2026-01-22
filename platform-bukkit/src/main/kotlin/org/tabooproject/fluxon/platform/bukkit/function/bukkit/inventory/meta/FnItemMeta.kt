package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemRarity
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.inventory.meta.components.FoodComponent
import org.bukkit.inventory.meta.components.ToolComponent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnItemMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemMeta::class.java)
                .function("hasDisplayName", 0) { it.target?.hasDisplayName() }
                .function("displayName", 0) { it.target?.displayName }
                .function("setDisplayName", 1) { it.target?.setDisplayName(it.getString(0)) }
                .function("hasItemName", 0) { it.target?.hasItemName() }
                .function("itemName", 0) { it.target?.itemName }
                .function("setItemName", 1) { it.target?.setItemName(it.getString(0)) }
                .function("hasLocalizedName", 0) { it.target?.hasLocalizedName() }
                .function("localizedName", 0) { it.target?.localizedName }
                .function("setLocalizedName", 1) { it.target?.setLocalizedName(it.getString(0)) }
                .function("hasLore", 0) { it.target?.hasLore() }
                .function("lore", 0) { it.target?.lore }
                .function("setLore", 1) { it.target?.setLore(it.getArgument(0) as List<String>) }
                .function("hasCustomModelData", 0) { it.target?.hasCustomModelData() }
                .function("customModelData", 0) { it.target?.customModelData }
                .function("setCustomModelData", 1) { it.target?.setCustomModelData(it.getNumber(0).toInt()) }
                .function("enchants", 0) { it.target?.enchants }
                .function("hasEnchants", 0) { it.target?.hasEnchants() }
                .function("hasEnchant", 1) { it.target?.hasEnchant(it.getArgument(0) as Enchantment) }
                .function("getEnchantLevel", 1) { it.target?.getEnchantLevel(it.getArgument(0) as Enchantment) }
                .function("addEnchant", 3) {
                    it.target?.addEnchant(
                        it.getArgument(0) as Enchantment,
                        it.getNumber(1).toInt(),
                        it.getBoolean(2)
                    )
                }
                .function("removeEnchant", 1) { it.target?.removeEnchant(it.getArgument(0) as Enchantment) }
                .function("removeEnchantments", 0) { it.target?.removeEnchantments() }
                .function(
                    "hasConflictingEnchant",
                    1
                ) { it.target?.hasConflictingEnchant(it.getArgument(0) as Enchantment) }
                .function("addItemFlags", 0) { it.target?.addItemFlags() }
                .function("removeItemFlags", 0) { it.target?.removeItemFlags() }
                .function("hasFlags", 0) { it.target?.itemFlags?.isNotEmpty() }
                .function("itemFlags", 0) { it.target?.itemFlags }
                .function("hasItemFlag", 1) { it.target?.hasItemFlag(it.getArgument(0) as ItemFlag) }
                .function("isHideTooltip", 0) { it.target?.isHideTooltip }
                .function("setHideTooltip", 1) { it.target?.setHideTooltip(it.getBoolean(0)) }
                .function("isUnbreakable", 0) { it.target?.isUnbreakable }
                .function("setUnbreakable", 1) { it.target?.setUnbreakable(it.getBoolean(0)) }
                .function("hasEnchantmentGlintOverride", 0) { it.target?.hasEnchantmentGlintOverride() }
                .function("enchantmentGlintOverride", 0) { it.target?.enchantmentGlintOverride }
                .function("setEnchantmentGlintOverride", 1) { it.target?.setEnchantmentGlintOverride(it.getBoolean(0)) }
                .function("isFireResistant", 0) { it.target?.isFireResistant }
                .function("setFireResistant", 1) { it.target?.setFireResistant(it.getBoolean(0)) }
                .function("hasMaxStackSize", 0) { it.target?.hasMaxStackSize() }
                .function("maxStackSize", 0) { it.target?.maxStackSize }
                .function("setMaxStackSize", 1) { it.target?.setMaxStackSize(it.getNumber(0).toInt()) }
                .function("hasRarity", 0) { it.target?.hasRarity() }
                .function("rarity", 0) { it.target?.rarity }
                .function("setRarity", 1) { it.target?.setRarity(it.getArgument(0) as ItemRarity) }
                .function("hasFood", 0) { it.target?.hasFood() }
                .function("food", 0) { it.target?.food }
                .function("setFood", 1) { it.target?.setFood(it.getArgument(0) as FoodComponent) }
                .function("hasTool", 0) { it.target?.hasTool() }
                .function("tool", 0) { it.target?.tool }
                .function("setTool", 1) { it.target?.setTool(it.getArgument(0) as ToolComponent) }
                .function("hasAttributeModifiers", 0) { it.target?.hasAttributeModifiers() }
                .function("getAttributeModifiers", 1) { it.target?.getAttributeModifiers(it.getArgument(0) as Attribute) }
                .function("addAttributeModifier", 2) {
                    it.target?.addAttributeModifier(
                        it.getArgument(0) as Attribute,
                        it.getArgument(1) as AttributeModifier
                    )
                }
//                .function(
//                    "setAttributeModifiers",
//                    1
//                ) { it.target?.setAttributeModifiers(it.getArgument(0) as Multimap<Attribute, AttributeModifier>) }
                .function("removeAttributeModifier", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        when (val var1 = it.getArgument(0)) {
                            is Attribute -> it.target?.removeAttributeModifier(var1)
                            is EquipmentSlot -> it.target?.removeAttributeModifier(var1)
                            else -> throw IllegalArgumentException("参数必须是 Attribute 或 EquipmentSlot 类型")
                        }
                    } else {
                        it.target?.removeAttributeModifier(
                            it.getArgument(0) as Attribute,
                            it.getArgument(1) as AttributeModifier
                        )
                    }
                }
                .function("asString", 0) { it.target?.asString }
                .function("asComponentString", 0) { it.target?.asComponentString }
                .function("customTagContainer", 0) { it.target?.customTagContainer }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
