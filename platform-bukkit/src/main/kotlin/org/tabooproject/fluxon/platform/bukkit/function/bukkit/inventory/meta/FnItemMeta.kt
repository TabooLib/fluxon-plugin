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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.ItemMeta"])
@PlatformSide(Platform.BUKKIT)
object FnItemMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemMeta::class.java)
                .function("hasDisplayName", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasDisplayName()) }
                .function("displayName", returnsObject().noParams()) { it.setReturnRef(it.target?.displayName) }
                .function("setDisplayName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDisplayName(it.getString(0))) }
                .function("hasItemName", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasItemName()) }
                .function("itemName", returnsObject().noParams()) { it.setReturnRef(it.target?.itemName) }
                .function("setItemName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setItemName(it.getString(0))) }
                .function("hasLocalizedName", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasLocalizedName()) }
                .function("localizedName", returnsObject().noParams()) { it.setReturnRef(it.target?.localizedName) }
                .function("setLocalizedName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLocalizedName(it.getString(0))) }
                .function("hasLore", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasLore()) }
                .function("lore", returnsObject().noParams()) { it.setReturnRef(it.target?.lore) }
                .function("setLore", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLore(it.getRef(0) as List<String>)) }
                .function("hasCustomModelData", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasCustomModelData()) }
                .function("customModelData", returnsObject().noParams()) { it.setReturnRef(it.target?.customModelData) }
                .function("setCustomModelData", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCustomModelData(it.getInt(0).toInt())) }
                .function("enchants", returnsObject().noParams()) { it.setReturnRef(it.target?.enchants) }
                .function("hasEnchants", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasEnchants()) }
                .function("hasEnchant", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.hasEnchant(it.getRef(0) as Enchantment)) }
                .function("getEnchantLevel", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getEnchantLevel(it.getRef(0) as Enchantment)) }
                .function("addEnchant", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.addEnchant(
                        it.getRef(0) as Enchantment,
                        it.getInt(1).toInt(),
                        it.getBool(2)
                    ))
                }
                .function("removeEnchant", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeEnchant(it.getRef(0) as Enchantment)) }
                .function("removeEnchantments", returnsObject().noParams()) { it.setReturnRef(it.target?.removeEnchantments()) }
                .function("hasConflictingEnchant", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.hasConflictingEnchant(it.getRef(0) as Enchantment)) }
                .function("addItemFlags", returnsObject().noParams()) { it.setReturnRef(it.target?.addItemFlags()) }
                .function("removeItemFlags", returnsObject().noParams()) { it.setReturnRef(it.target?.removeItemFlags()) }
                .function("hasFlags", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.itemFlags?.isNotEmpty()) }
                .function("itemFlags", returnsObject().noParams()) { it.setReturnRef(it.target?.itemFlags) }
                .function("hasItemFlag", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.hasItemFlag(it.getRef(0) as ItemFlag)) }
                .function("isHideTooltip", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isHideTooltip) }
                .function("setHideTooltip", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setHideTooltip(it.getBool(0))) }
                .function("isUnbreakable", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isUnbreakable) }
                .function("setUnbreakable", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setUnbreakable(it.getBool(0))) }
                .function("hasEnchantmentGlintOverride", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasEnchantmentGlintOverride()) }
                .function("enchantmentGlintOverride", returnsObject().noParams()) { it.setReturnRef(it.target?.enchantmentGlintOverride) }
                .function("setEnchantmentGlintOverride", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setEnchantmentGlintOverride(it.getBool(0))) }
                .function("isFireResistant", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isFireResistant) }
                .function("setFireResistant", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFireResistant(it.getBool(0))) }
                .function("hasMaxStackSize", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasMaxStackSize()) }
                .function("maxStackSize", returnsObject().noParams()) { it.setReturnRef(it.target?.maxStackSize) }
                .function("setMaxStackSize", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaxStackSize(it.getInt(0).toInt())) }
                .function("hasRarity", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasRarity()) }
                .function("rarity", returnsObject().noParams()) { it.setReturnRef(it.target?.rarity) }
                .function("setRarity", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRarity(it.getRef(0) as ItemRarity)) }
                .function("hasFood", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasFood()) }
                .function("food", returnsObject().noParams()) { it.setReturnRef(it.target?.food) }
                .function("setFood", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFood(it.getRef(0) as FoodComponent)) }
                .function("hasTool", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasTool()) }
                .function("tool", returnsObject().noParams()) { it.setReturnRef(it.target?.tool) }
                .function("setTool", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTool(it.getRef(0) as ToolComponent)) }
                .function("hasAttributeModifiers", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasAttributeModifiers()) }
                .function("getAttributeModifiers", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getAttributeModifiers(it.getRef(0) as Attribute)) }
                .function("addAttributeModifier", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.addAttributeModifier(
                        it.getRef(0) as Attribute,
                        it.getRef(1) as AttributeModifier
                    ))
                }
//                .function(
//                    "setAttributeModifiers",
//                    1
//                ) { it.target?.setAttributeModifiers(it.getRef(0) as Multimap<Attribute, AttributeModifier>) }
                .function("removeAttributeModifier", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Attribute -> it.target?.removeAttributeModifier(var1)
                            is EquipmentSlot -> it.target?.removeAttributeModifier(var1)
                            else -> throw IllegalArgumentException("参数必须是 Attribute 或 EquipmentSlot 类型")
                        }
                    } else {
                        it.target?.removeAttributeModifier(
                            it.getRef(0) as Attribute,
                            it.getRef(1) as AttributeModifier
                        )
                    })
                }
                .function("removeAttributeModifier", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Attribute -> it.target?.removeAttributeModifier(var1)
                            is EquipmentSlot -> it.target?.removeAttributeModifier(var1)
                            else -> throw IllegalArgumentException("参数必须是 Attribute 或 EquipmentSlot 类型")
                        }
                    } else {
                        it.target?.removeAttributeModifier(
                            it.getRef(0) as Attribute,
                            it.getRef(1) as AttributeModifier
                        )
                    })
                }
                .function("asString", returnsObject().noParams()) { it.setReturnRef(it.target?.asString) }
                .function("asComponentString", returnsObject().noParams()) { it.setReturnRef(it.target?.asComponentString) }
                .function("customTagContainer", returnsObject().noParams()) { it.setReturnRef(it.target?.customTagContainer) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
