package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.PlayerInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.PlayerInventory"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerInventory::class.java)
                .function("armorContents", returnsObject().noParams()) { it.target?.armorContents }
                .function("extraContents", returnsObject().noParams()) { it.target?.extraContents }
                .function("helmet", returnsObject().noParams()) { it.target?.helmet }
                .function("chestplate", returnsObject().noParams()) { it.target?.chestplate }
                .function("leggings", returnsObject().noParams()) { it.target?.leggings }
                .function("boots", returnsObject().noParams()) { it.target?.boots }
                .function("setItem", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is Int -> it.target?.setItem(var1, it.getRef(1) as ItemStack)
                        is EquipmentSlot -> it.target?.setItem(var1, it.getRef(1) as ItemStack)
                        else -> throw IllegalArgumentException("参数 1 必须是 Int 或 EquipmentSlot 类型")
                    }
                }
                .function("getItem", returnsObject().params(Type.OBJECT)) { it.target?.getItem(it.getRef(0) as EquipmentSlot) }
                .function("setArmorContents", returnsObject().params(Type.OBJECT)) { it.target?.setArmorContents(it.getRef(0) as Array<ItemStack>) }
                .function("setExtraContents", returnsObject().params(Type.OBJECT)) { it.target?.setExtraContents(it.getRef(0) as Array<ItemStack>) }
                .function("setHelmet", returnsObject().params(Type.OBJECT)) { it.target?.setHelmet(it.getRef(0) as ItemStack) }
                .function("setChestplate", returnsObject().params(Type.OBJECT)) { it.target?.setChestplate(it.getRef(0) as ItemStack) }
                .function("setLeggings", returnsObject().params(Type.OBJECT)) { it.target?.setLeggings(it.getRef(0) as ItemStack) }
                .function("setBoots", returnsObject().params(Type.OBJECT)) { it.target?.setBoots(it.getRef(0) as ItemStack) }
                .function("itemInMainHand", returnsObject().noParams()) { it.target?.itemInMainHand }
                .function("setItemInMainHand", returnsObject().params(Type.OBJECT)) { it.target?.setItemInMainHand(it.getRef(0) as ItemStack) }
                .function("itemInOffHand", returnsObject().noParams()) { it.target?.itemInOffHand }
                .function("setItemInOffHand", returnsObject().params(Type.OBJECT)) { it.target?.setItemInOffHand(it.getRef(0) as ItemStack) }
                .function("itemInHand", returnsObject().noParams()) { it.target?.itemInHand }
                .function("setItemInHand", returnsObject().params(Type.OBJECT)) { it.target?.setItemInHand(it.getRef(0) as ItemStack) }
                .function("heldItemSlot", returnsObject().noParams()) { it.target?.heldItemSlot }
                .function("setHeldItemSlot", returnsObject().params(Type.OBJECT)) { it.target?.setHeldItemSlot(it.getInt(0).toInt()) }
                .function("holder", returnsObject().noParams()) { it.target?.holder }
        }
    }
}
