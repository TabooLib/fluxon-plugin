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


@Requires(classes = ["org.bukkit.inventory.ItemStack"])
@PlatformSide(Platform.BUKKIT)
object FnItemStack {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemStack::class.java)
//                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.itemMeta?.displayName ?: it.target?.getI18 nName()) } // TODO: setter
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                .function("setType", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setType(it.getRef(0) as Material)) }
                .function("amount", returnsObject().noParams()) { it.setReturnRef(it.target?.amount) }
                .function("setAmount", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAmount(it.getInt(0).toInt())) }
                .function("data", returnsObject().noParams()) { it.setReturnRef(it.target?.data) }
                .function("setData", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setData(it.getRef(0) as MaterialData)) }
                .function("setDurability", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDurability(it.getInt(0).toShort())) }
                .function("durability", returnsObject().noParams()) { it.setReturnRef(it.target?.durability) }
                .function("maxStackSize", returnsObject().noParams()) { it.setReturnRef(it.target?.maxStackSize) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.equals(it.getRef(0))) }
                .function("isSimilar", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.isSimilar(it.getRef(0) as ItemStack)) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnRef(it.target?.hashCode()) }
                .function("containsEnchantment", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.containsEnchantment(it.getRef(0) as Enchantment)) }
                .function("enchantments", returnsObject().noParams()) { it.setReturnRef(it.target?.enchantments) }
                .function("getEnchantmentLevel", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getEnchantmentLevel(it.getRef(0) as Enchantment)) }
                .function("addEnchantments", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addEnchantments(it.getRef(0) as Map<Enchantment, Int>)) }
                .function("addEnchantment", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.addEnchantment(
                        it.getRef(0) as Enchantment,
                        it.getInt(1).toInt()
                    ))
                }
                .function("addUnsafeEnchantments", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addUnsafeEnchantments(it.getRef(0) as Map<Enchantment, Int>)) }
                .function("addUnsafeEnchantment", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.addUnsafeEnchantment(
                        it.getRef(0) as Enchantment,
                        it.getInt(1).toInt()
                    ))
                }
                .function("removeEnchantment", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeEnchantment(it.getRef(0) as Enchantment)) }
                .function("removeEnchantments", returnsObject().noParams()) { it.setReturnRef(it.target?.removeEnchantments()) }
                .function("serialize", returnsObject().noParams()) { it.setReturnRef(it.target?.serialize()) }
                // static
                .function("deserialize", returnsObject().params(Type.OBJECT)) { it.setReturnRef(ItemStack.deserialize(it.getRef(0) as Map<String, Any>)) }
                .function("itemMeta", returnsObject().noParams()) { it.setReturnRef(it.target?.itemMeta) }
                .function("hasItemMeta", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasItemMeta()) }
                .function("setItemMeta", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setItemMeta(it.getRef(0) as ItemMeta)) }
                .function("translationKey", returnsObject().noParams()) { it.setReturnRef(it.target?.translationKey) }
        }
    }
}
