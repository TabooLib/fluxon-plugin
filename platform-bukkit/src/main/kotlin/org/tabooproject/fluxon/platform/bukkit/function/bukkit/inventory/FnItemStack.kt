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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid


@Requires(classes = ["org.bukkit.inventory.ItemStack"])
@PlatformSide(Platform.BUKKIT)
object FnItemStack {

    val TYPE = Type.fromClass(ItemStack::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemStack::class.java)
//                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.itemMeta?.displayName ?: it.target?.getI18 nName()) } // TODO: setter
                .function("type", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
                .function("setType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.target?.setType(it.getRef(0) as Material) }
                .function("amount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.amount ?: 0) }
                .function("setAmount", returnsVoid().params(Type.I)) { it.target?.setAmount(it.getInt(0).toInt()) }
                .function("data", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE).noParams()) { it.setReturnRef(it.target?.data) }
                .function("setData",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE)) { it.target?.setData(it.getRef(0) as MaterialData) }
                .function("setDurability", returnsVoid().params(Type.I)) { it.target?.setDurability(it.getInt(0).toShort()) }
                .function("durability", returns(Type.I).noParams()) { it.setReturnInt(it.target?.durability?.toInt() ?: 0) }
                .function("maxStackSize", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxStackSize ?: 0) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("isSimilar",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.setReturnBool(it.target?.isSimilar(it.getRef(0) as ItemStack) ?: false)
                }
                .function("clone", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("containsEnchantment",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE)) {
                    it.setReturnBool(it.target?.containsEnchantment(it.getRef(0) as Enchantment) ?: false)
                }
                .function("enchantments", returns(Type.MAP).noParams()) { it.setReturnRef(it.target?.enchantments) }
                .function("getEnchantmentLevel",returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE)) {
                    it.setReturnInt(it.target?.getEnchantmentLevel(it.getRef(0) as Enchantment) ?: 0)
                }
                .function("addEnchantments",returnsVoid().params(Type.MAP)) {
                    it.target?.addEnchantments(it.getRef(0) as Map<Enchantment, Int>)
                }
                .function("addEnchantment",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE, Type.I)) {
                    it.target?.addEnchantment(
                        it.getRef(0) as Enchantment,
                        it.getInt(1).toInt()
                    )
                }
                .function("addUnsafeEnchantments",returnsVoid().params(Type.MAP)) {
                    it.target?.addUnsafeEnchantments(it.getRef(0) as Map<Enchantment, Int>)
                }
                .function("addUnsafeEnchantment",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE, Type.I)) {
                    it.target?.addUnsafeEnchantment(
                        it.getRef(0) as Enchantment,
                        it.getInt(1).toInt()
                    )
                }
                .function("removeEnchantment",returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE)) {
                    it.setReturnInt(it.target?.removeEnchantment(it.getRef(0) as Enchantment) ?: 0)
                }
                .function("removeEnchantments", returnsVoid().noParams()) { it.target?.removeEnchantments() }
                .function("serialize", returns(Type.MAP).noParams()) { it.setReturnRef(it.target?.serialize()) }
                // static
                .function("deserialize",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(Type.MAP)) { it.setReturnRef(ItemStack.deserialize(it.getRef(0) as Map<String, Any>)) }
                .function("itemMeta", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnItemMeta.TYPE).noParams()) { it.setReturnRef(it.target?.itemMeta) }
                .function("hasItemMeta", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasItemMeta() ?: false) }
                .function("setItemMeta",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnItemMeta.TYPE)) {
                    it.setReturnBool(it.target?.setItemMeta(it.getRef(0) as ItemMeta) ?: false)
                }
                .function("translationKey", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.translationKey) }
        }
    }
}
