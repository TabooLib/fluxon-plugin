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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.ItemMeta"])
@PlatformSide(Platform.BUKKIT)
object FnItemMeta {

    val TYPE = Type.fromClass(ItemMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemMeta::class.java)
                .function("hasDisplayName", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasDisplayName() ?: false) }
                .function("displayName", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.displayName) }
                .function("setDisplayName", returnsVoid().params(Type.STRING)) { it.target?.setDisplayName(it.getString(0)) }
                .function("hasItemName", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasItemName() ?: false) }
                .function("itemName", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.itemName) }
                .function("setItemName", returnsVoid().params(Type.STRING)) { it.target?.setItemName(it.getString(0)) }
                .function("hasLocalizedName", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasLocalizedName() ?: false) }
                .function("localizedName", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.localizedName) }
                .function("setLocalizedName", returnsVoid().params(Type.STRING)) { it.target?.setLocalizedName(it.getString(0)) }
                .function("hasLore", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasLore() ?: false) }
                .function("lore", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.lore) }
                .function("setLore",returnsVoid().params(Type.LIST)) { it.target?.setLore(it.getRef(0) as List<String>) }
                .function("hasCustomModelData", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasCustomModelData() ?: false) }
                .function("customModelData", returns(Type.I).noParams()) { it.setReturnInt(it.target?.customModelData ?: 0) }
                .function("setCustomModelData", returnsVoid().params(Type.I)) { it.target?.setCustomModelData(it.getInt(0)) }
                .function("enchants", returns(Type.MAP).noParams()) { it.setReturnRef(it.target?.enchants) }
                .function("hasEnchants", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasEnchants() ?: false) }
                .function("hasEnchant",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE)) { it.setReturnBool(it.target?.hasEnchant(it.getRef(0) as Enchantment) ?: false) }
                .function("getEnchantLevel",returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE)) {
                    it.setReturnInt(it.target?.getEnchantLevel(it.getRef(0) as Enchantment) ?: 0)
                }
                .function("addEnchant",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE, Type.I, Type.Z)) {
                    it.setReturnBool(it.target?.addEnchant(
                        it.getRef(0) as Enchantment,
                        it.getInt(1),
                        it.getBool(2)
                    ) ?: false)
                }
                .function("removeEnchant",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE)) {
                    it.setReturnBool(it.target?.removeEnchant(it.getRef(0) as Enchantment) ?: false)
                }
                .function("removeEnchantments", returnsVoid().noParams()) { it.target?.removeEnchantments() }
                .function("hasConflictingEnchant",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE)) {
                    it.setReturnBool(it.target?.hasConflictingEnchant(it.getRef(0) as Enchantment) ?: false)
                }
                .function("addItemFlags", returnsVoid().noParams()) { it.target?.addItemFlags() }
                .function("removeItemFlags", returnsVoid().noParams()) { it.target?.removeItemFlags() }
                .function("hasFlags", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.itemFlags?.isNotEmpty() ?: false) }
                .function("itemFlags", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.itemFlags) }
                .function("hasItemFlag", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemFlag.TYPE)) { it.setReturnBool(it.target?.hasItemFlag(it.getRef(0) as ItemFlag) ?: false)  }
                .function("hasItemFlag", returns(Type.Z).params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemFlag.enumValue(it.getString(0))?.let { p0 -> it.setReturnBool(it.target?.hasItemFlag(p0) ?: false)  } }
                .function("isHideTooltip", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isHideTooltip ?: false) }
                .function("setHideTooltip", returnsVoid().params(Type.Z)) { it.target?.setHideTooltip(it.getBool(0)) }
                .function("isUnbreakable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isUnbreakable ?: false) }
                .function("setUnbreakable", returnsVoid().params(Type.Z)) { it.target?.setUnbreakable(it.getBool(0)) }
                .function("hasEnchantmentGlintOverride", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasEnchantmentGlintOverride() ?: false) }
                .function("enchantmentGlintOverride", returns(Type.BOOLEAN).noParams()) { it.setReturnRef(it.target?.enchantmentGlintOverride) }
                .function("setEnchantmentGlintOverride", returnsVoid().params(Type.Z)) { it.target?.setEnchantmentGlintOverride(it.getBool(0)) }
                .function("isFireResistant", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFireResistant ?: false) }
                .function("setFireResistant", returnsVoid().params(Type.Z)) { it.target?.setFireResistant(it.getBool(0)) }
                .function("hasMaxStackSize", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasMaxStackSize() ?: false) }
                .function("maxStackSize", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxStackSize ?: 0) }
                .function("setMaxStackSize", returnsVoid().params(Type.I)) { it.target?.setMaxStackSize(it.getInt(0)) }
                .function("hasRarity", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasRarity() ?: false) }
                .function("rarity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemRarity.TYPE).noParams()) { it.setReturnRef(it.target?.rarity) }
                .function("setRarity", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemRarity.TYPE)) { it.target?.setRarity(it.getRef(0) as ItemRarity)  }
                .function("setRarity", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemRarity.enumValue(it.getString(0))?.let { p0 -> it.target?.setRarity(p0)  } }
                .function("hasFood", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasFood() ?: false) }
                .function("food", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.components.FnFoodComponent.TYPE).noParams()) { it.setReturnRef(it.target?.food) }
                .function("setFood",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.components.FnFoodComponent.TYPE)) { it.target?.setFood(it.getRef(0) as FoodComponent) }
                .function("hasTool", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasTool() ?: false) }
                .function("tool", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.components.FnToolComponent.TYPE).noParams()) { it.setReturnRef(it.target?.tool) }
                .function("setTool",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.components.FnToolComponent.TYPE)) { it.target?.setTool(it.getRef(0) as ToolComponent) }
                .function("hasAttributeModifiers", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasAttributeModifiers() ?: false) }
                .function("getAttributeModifiers", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute.FnAttribute.TYPE)) {
                    it.setReturnRef(it.target?.getAttributeModifiers(it.getRef(0) as Attribute))
                }
                .function("addAttributeModifier",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute.FnAttribute.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute.FnAttributeModifier.TYPE)) {
                    it.setReturnBool(it.target?.addAttributeModifier(
                        it.getRef(0) as Attribute,
                        it.getRef(1) as AttributeModifier
                    ) ?: false)
                }
//                .function(
//                    "setAttributeModifiers",
//                    1
//                ) { it.target?.setAttributeModifiers(it.getRef(0) as Multimap<Attribute, AttributeModifier>) }
                .function("removeAttributeModifier", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute.FnAttribute.TYPE)) {
                    it.setReturnBool(it.target?.removeAttributeModifier(it.getRef(0) as Attribute) ?: false)
                }
                .function("removeAttributeModifier", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE)) {
                    it.setReturnBool(it.target?.removeAttributeModifier(it.getRef(0) as EquipmentSlot) ?: false)
                }
                .function("removeAttributeModifier",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute.FnAttribute.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute.FnAttributeModifier.TYPE)) {
                    it.setReturnBool(it.target?.removeAttributeModifier(
                        it.getRef(0) as Attribute,
                        it.getRef(1) as AttributeModifier
                    ) ?: false)
                }
                .function("asString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.asString) }
                .function("asComponentString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.asComponentString) }
                .function("customTagContainer", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.tags.FnCustomItemTagContainer.TYPE).noParams()) { it.setReturnRef(it.target?.customTagContainer) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
