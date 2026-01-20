package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.PlayerInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerInventory::class.java)
                .function("armorContents", 0) { it.target?.armorContents }
                .function("extraContents", 0) { it.target?.extraContents }
                .function("helmet", 0) { it.target?.helmet }
                .function("chestplate", 0) { it.target?.chestplate }
                .function("leggings", 0) { it.target?.leggings }
                .function("boots", 0) { it.target?.boots }
                .function("setItem", 2) {
                    when (val var1 = it.getArgument(0)) {
                        is Int -> it.target?.setItem(var1, it.getArgument(1) as ItemStack)
                        is EquipmentSlot -> it.target?.setItem(var1, it.getArgument(1) as ItemStack)
                        else -> throw IllegalArgumentException("参数 1 必须是 Int 或 EquipmentSlot 类型")
                    }
                }
                .function("item", 1) { it.target?.getItem(it.getArgument(0) as EquipmentSlot) }
                .function("setArmorContents", 1) { it.target?.setArmorContents(it.getArgument(0) as Array<ItemStack>) }
                .function("setExtraContents", 1) { it.target?.setExtraContents(it.getArgument(0) as Array<ItemStack>) }
                .function("setHelmet", 1) { it.target?.setHelmet(it.getArgument(0) as ItemStack) }
                .function("setChestplate", 1) { it.target?.setChestplate(it.getArgument(0) as ItemStack) }
                .function("setLeggings", 1) { it.target?.setLeggings(it.getArgument(0) as ItemStack) }
                .function("setBoots", 1) { it.target?.setBoots(it.getArgument(0) as ItemStack) }
                .function("itemInMainHand", 0) { it.target?.itemInMainHand }
                .function("setItemInMainHand", 1) { it.target?.setItemInMainHand(it.getArgument(0) as ItemStack) }
                .function("itemInOffHand", 0) { it.target?.itemInOffHand }
                .function("setItemInOffHand", 1) { it.target?.setItemInOffHand(it.getArgument(0) as ItemStack) }
                .function("itemInHand", 0) { it.target?.itemInHand }
                .function("setItemInHand", 1) { it.target?.setItemInHand(it.getArgument(0) as ItemStack) }
                .function("heldItemSlot", 0) { it.target?.heldItemSlot }
                .function("setHeldItemSlot", 1) { it.target?.setHeldItemSlot(it.getNumber(0).toInt()) }
                .function("holder", 0) { it.target?.holder }
        }
    }
}
