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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
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
                .function("displayName", returnsObject().noParams()) { it.setReturnRef(it.target?.displayName) }
                .function("setDisplayName", returnsVoid().params(Type.STRING)) { it.target?.setDisplayName(it.getString(0)) }
                .function("hasItemName", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasItemName() ?: false) }
                .function("itemName", returnsObject().noParams()) { it.setReturnRef(it.target?.itemName) }
                .function("setItemName", returnsVoid().params(Type.STRING)) { it.target?.setItemName(it.getString(0)) }
                .function("hasLocalizedName", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasLocalizedName() ?: false) }
                .function("localizedName", returnsObject().noParams()) { it.setReturnRef(it.target?.localizedName) }
                .function("setLocalizedName", returnsVoid().params(Type.STRING)) { it.target?.setLocalizedName(it.getString(0)) }
                .function("hasLore", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasLore() ?: false) }
                .function("lore", returnsObject().noParams()) { it.setReturnRef(it.target?.lore) }
                .function("setLore", returnsVoid().params(Type.OBJECT)) { it.target?.setLore(it.getRef(0) as List<String>) }
                .function("hasCustomModelData", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasCustomModelData() ?: false) }
                .function("customModelData", returnsObject().noParams()) { it.setReturnRef(it.target?.customModelData) }
                .function("setCustomModelData", returnsVoid().params(Type.I)) { it.target?.setCustomModelData(it.getInt(0)) }
                .function("enchants", returnsObject().noParams()) { it.setReturnRef(it.target?.enchants) }
                .function("hasEnchants", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasEnchants() ?: false) }
                .function("hasEnchant", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.hasEnchant(it.getRef(0) as Enchantment) ?: false) }
                .function("getEnchantLevel", returns(Type.I).params(Type.OBJECT)) {
                    it.setReturnInt(it.target?.getEnchantLevel(it.getRef(0) as Enchantment) ?: 0)
                }
                .function("addEnchant", returns(Type.Z).params(Type.OBJECT, Type.I, Type.Z)) {
                    it.setReturnBool(it.target?.addEnchant(
                        it.getRef(0) as Enchantment,
                        it.getInt(1),
                        it.getBool(2)
                    ) ?: false)
                }
                .function("removeEnchant", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.removeEnchant(it.getRef(0) as Enchantment) ?: false)
                }
                .function("removeEnchantments", returnsVoid().noParams()) { it.target?.removeEnchantments() }
                .function("hasConflictingEnchant", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.hasConflictingEnchant(it.getRef(0) as Enchantment) ?: false)
                }
                .function("addItemFlags", returnsVoid().noParams()) { it.target?.addItemFlags() }
                .function("removeItemFlags", returnsVoid().noParams()) { it.target?.removeItemFlags() }
                .function("hasFlags", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.itemFlags?.isNotEmpty() ?: false) }
                .function("itemFlags", returnsObject().noParams()) { it.setReturnRef(it.target?.itemFlags) }
                .function("hasItemFlag", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.hasItemFlag(it.getRef(0) as ItemFlag) ?: false) }
                .function("isHideTooltip", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isHideTooltip ?: false) }
                .function("setHideTooltip", returnsVoid().params(Type.Z)) { it.target?.setHideTooltip(it.getBool(0)) }
                .function("isUnbreakable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isUnbreakable ?: false) }
                .function("setUnbreakable", returnsVoid().params(Type.Z)) { it.target?.setUnbreakable(it.getBool(0)) }
                .function("hasEnchantmentGlintOverride", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasEnchantmentGlintOverride() ?: false) }
                .function("enchantmentGlintOverride", returnsObject().noParams()) { it.setReturnRef(it.target?.enchantmentGlintOverride) }
                .function("setEnchantmentGlintOverride", returnsVoid().params(Type.Z)) { it.target?.setEnchantmentGlintOverride(it.getBool(0)) }
                .function("isFireResistant", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFireResistant ?: false) }
                .function("setFireResistant", returnsVoid().params(Type.Z)) { it.target?.setFireResistant(it.getBool(0)) }
                .function("hasMaxStackSize", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasMaxStackSize() ?: false) }
                .function("maxStackSize", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxStackSize ?: 0) }
                .function("setMaxStackSize", returnsVoid().params(Type.I)) { it.target?.setMaxStackSize(it.getInt(0)) }
                .function("hasRarity", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasRarity() ?: false) }
                .function("rarity", returnsObject().noParams()) { it.setReturnRef(it.target?.rarity) }
                .function("setRarity", returnsVoid().params(Type.OBJECT)) { it.target?.setRarity(it.getRef(0) as ItemRarity) }
                .function("hasFood", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasFood() ?: false) }
                .function("food", returnsObject().noParams()) { it.setReturnRef(it.target?.food) }
                .function("setFood", returnsVoid().params(Type.OBJECT)) { it.target?.setFood(it.getRef(0) as FoodComponent) }
                .function("hasTool", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasTool() ?: false) }
                .function("tool", returnsObject().noParams()) { it.setReturnRef(it.target?.tool) }
                .function("setTool", returnsVoid().params(Type.OBJECT)) { it.target?.setTool(it.getRef(0) as ToolComponent) }
                .function("hasAttributeModifiers", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasAttributeModifiers() ?: false) }
                .function("getAttributeModifiers", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getAttributeModifiers(it.getRef(0) as Attribute)) }
                .function("addAttributeModifier", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnBool(it.target?.addAttributeModifier(
                        it.getRef(0) as Attribute,
                        it.getRef(1) as AttributeModifier
                    ) ?: false)
                }
//                .function(
//                    "setAttributeModifiers",
//                    1
//                ) { it.target?.setAttributeModifiers(it.getRef(0) as Multimap<Attribute, AttributeModifier>) }
                .function("removeAttributeModifier", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is Attribute -> it.target?.removeAttributeModifier(var1)
                        is EquipmentSlot -> it.target?.removeAttributeModifier(var1)
                        else -> throw IllegalArgumentException("参数必须是 Attribute 或 EquipmentSlot 类型")
                    } ?: false)
                }
                .function("removeAttributeModifier", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnBool(it.target?.removeAttributeModifier(
                        it.getRef(0) as Attribute,
                        it.getRef(1) as AttributeModifier
                    ) ?: false)
                }
                .function("asString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.asString) }
                .function("asComponentString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.asComponentString) }
                .function("customTagContainer", returnsObject().noParams()) { it.setReturnRef(it.target?.customTagContainer) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
