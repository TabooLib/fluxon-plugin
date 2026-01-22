package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.EntityEquipment
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEntityEquipment {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityEquipment::class.java)
                .function("setItem", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.setItem(
                            it.getArgument(0) as EquipmentSlot,
                            it.getArgument(1) as ItemStack
                        )
                    } else {
                        it.target?.setItem(
                            it.getArgument(0) as EquipmentSlot,
                            it.getArgument(1) as ItemStack,
                            it.getBoolean(2)
                        )
                    }
                }
                .function("getItem", 1) { it.target?.getItem(it.getArgument(0) as EquipmentSlot) }
                .function("itemInMainHand", 0) { it.target?.itemInMainHand }
                .function("setItemInMainHand", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setItemInMainHand(it.getArgument(0) as ItemStack)
                    } else {
                        it.target?.setItemInMainHand(
                            it.getArgument(0) as ItemStack,
                            it.getBoolean(1)
                        )
                    }
                }
                .function("itemInOffHand", 0) { it.target?.itemInOffHand }
                .function("setItemInOffHand", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setItemInOffHand(it.getArgument(0) as ItemStack)
                    } else {
                        it.target?.setItemInOffHand(
                            it.getArgument(0) as ItemStack,
                            it.getBoolean(1)
                        )
                    }
                }
                .function("itemInHand", 0) { it.target?.itemInHand }
                .function("setItemInHand", 1) { it.target?.setItemInHand(it.getArgument(0) as ItemStack) }
                .function("helmet", 0) { it.target?.helmet }
                .function("setHelmet", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setHelmet(it.getArgument(0) as ItemStack)
                    } else {
                        it.target?.setHelmet(it.getArgument(0) as ItemStack, it.getBoolean(1))
                    }
                }
                .function("chestplate", 0) { it.target?.chestplate }
                .function("setChestplate", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setChestplate(it.getArgument(0) as ItemStack)
                    } else {
                        it.target?.setChestplate(
                            it.getArgument(0) as ItemStack,
                            it.getBoolean(1)
                        )
                    }
                }
                .function("leggings", 0) { it.target?.leggings }
                .function("setLeggings", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setLeggings(it.getArgument(0) as ItemStack)
                    } else {
                        it.target?.setLeggings(it.getArgument(0) as ItemStack, it.getBoolean(1))
                    }
                }
                .function("boots", 0) { it.target?.boots }
                .function("setBoots", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setBoots(it.getArgument(0) as ItemStack)
                    } else {
                        it.target?.setBoots(it.getArgument(0) as ItemStack, it.getBoolean(1))
                    }
                }
                .function("armorContents", 0) { it.target?.armorContents }
                .function("setArmorContents", 1) { it.target?.setArmorContents(it.getArgument(0) as Array<ItemStack>) }
                .function("clear", 0) { it.target?.clear() }
                .function("itemInHandDropChance", 0) { it.target?.itemInHandDropChance }
                .function("setItemInHandDropChance", 1) {
                    it.target?.setItemInHandDropChance(
                        it.getNumber(0).toFloat()
                    )
                }
                .function("itemInMainHandDropChance", 0) { it.target?.itemInMainHandDropChance }
                .function("setItemInMainHandDropChance", 1) {
                    it.target?.setItemInMainHandDropChance(
                        it.getNumber(0).toFloat()
                    )
                }
                .function("itemInOffHandDropChance", 0) { it.target?.itemInOffHandDropChance }
                .function("setItemInOffHandDropChance", 1) {
                    it.target?.setItemInOffHandDropChance(
                        it.getNumber(0).toFloat()
                    )
                }
                .function("helmetDropChance", 0) { it.target?.helmetDropChance }
                .function("setHelmetDropChance", 1) { it.target?.setHelmetDropChance(it.getNumber(0).toFloat()) }
                .function("chestplateDropChance", 0) { it.target?.chestplateDropChance }
                .function("setChestplateDropChance", 1) {
                    it.target?.setChestplateDropChance(
                        it.getNumber(0).toFloat()
                    )
                }
                .function("leggingsDropChance", 0) { it.target?.leggingsDropChance }
                .function("setLeggingsDropChance", 1) { it.target?.setLeggingsDropChance(it.getNumber(0).toFloat()) }
                .function("bootsDropChance", 0) { it.target?.bootsDropChance }
                .function("setBootsDropChance", 1) { it.target?.setBootsDropChance(it.getNumber(0).toFloat()) }
                .function("holder", 0) { it.target?.holder }
        }
    }
}
