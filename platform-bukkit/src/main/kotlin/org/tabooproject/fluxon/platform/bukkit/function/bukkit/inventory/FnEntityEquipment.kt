package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.EntityEquipment
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.EntityEquipment"])
@PlatformSide(Platform.BUKKIT)
object FnEntityEquipment {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityEquipment::class.java)
                .function("setItem", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.setItem(
                            it.getRef(0) as EquipmentSlot,
                            it.getRef(1) as ItemStack
                        )
                    } else {
                        it.target?.setItem(
                            it.getRef(0) as EquipmentSlot,
                            it.getRef(1) as ItemStack,
                            it.getBool(2)
                        )
                    })
                }
                .function("setItem", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.setItem(
                            it.getRef(0) as EquipmentSlot,
                            it.getRef(1) as ItemStack
                        )
                    } else {
                        it.target?.setItem(
                            it.getRef(0) as EquipmentSlot,
                            it.getRef(1) as ItemStack,
                            it.getBool(2)
                        )
                    })
                }
                .function("getItem", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getItem(it.getRef(0) as EquipmentSlot)) }
                .function("itemInMainHand", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInMainHand) }
                .function("setItemInMainHand", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setItemInMainHand(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setItemInMainHand(
                            it.getRef(0) as ItemStack,
                            it.getBool(1)
                        )
                    })
                }
                .function("setItemInMainHand", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setItemInMainHand(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setItemInMainHand(
                            it.getRef(0) as ItemStack,
                            it.getBool(1)
                        )
                    })
                }
                .function("itemInOffHand", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInOffHand) }
                .function("setItemInOffHand", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setItemInOffHand(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setItemInOffHand(
                            it.getRef(0) as ItemStack,
                            it.getBool(1)
                        )
                    })
                }
                .function("setItemInOffHand", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setItemInOffHand(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setItemInOffHand(
                            it.getRef(0) as ItemStack,
                            it.getBool(1)
                        )
                    })
                }
                .function("itemInHand", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInHand) }
                .function("setItemInHand", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setItemInHand(it.getRef(0) as ItemStack)) }
                .function("helmet", returnsObject().noParams()) { it.setReturnRef(it.target?.helmet) }
                .function("setHelmet", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setHelmet(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setHelmet(it.getRef(0) as ItemStack, it.getBool(1))
                    })
                }
                .function("setHelmet", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setHelmet(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setHelmet(it.getRef(0) as ItemStack, it.getBool(1))
                    })
                }
                .function("chestplate", returnsObject().noParams()) { it.setReturnRef(it.target?.chestplate) }
                .function("setChestplate", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setChestplate(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setChestplate(
                            it.getRef(0) as ItemStack,
                            it.getBool(1)
                        )
                    })
                }
                .function("setChestplate", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setChestplate(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setChestplate(
                            it.getRef(0) as ItemStack,
                            it.getBool(1)
                        )
                    })
                }
                .function("leggings", returnsObject().noParams()) { it.setReturnRef(it.target?.leggings) }
                .function("setLeggings", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setLeggings(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setLeggings(it.getRef(0) as ItemStack, it.getBool(1))
                    })
                }
                .function("setLeggings", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setLeggings(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setLeggings(it.getRef(0) as ItemStack, it.getBool(1))
                    })
                }
                .function("boots", returnsObject().noParams()) { it.setReturnRef(it.target?.boots) }
                .function("setBoots", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setBoots(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setBoots(it.getRef(0) as ItemStack, it.getBool(1))
                    })
                }
                .function("setBoots", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setBoots(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setBoots(it.getRef(0) as ItemStack, it.getBool(1))
                    })
                }
                .function("armorContents", returnsObject().noParams()) { it.setReturnRef(it.target?.armorContents) }
                .function("setArmorContents", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setArmorContents(it.getRef(0) as Array<ItemStack>)) }
                .function("clear", returnsObject().noParams()) { it.setReturnRef(it.target?.clear()) }
                .function("itemInHandDropChance", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInHandDropChance) }
                .function("setItemInHandDropChance", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.setItemInHandDropChance(
                        it.getFloat(0)
                    ))
                }
                .function("itemInMainHandDropChance", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInMainHandDropChance) }
                .function("setItemInMainHandDropChance", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.setItemInMainHandDropChance(
                        it.getFloat(0)
                    ))
                }
                .function("itemInOffHandDropChance", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInOffHandDropChance) }
                .function("setItemInOffHandDropChance", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.setItemInOffHandDropChance(
                        it.getFloat(0)
                    ))
                }
                .function("helmetDropChance", returnsObject().noParams()) { it.setReturnRef(it.target?.helmetDropChance) }
                .function("setHelmetDropChance", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setHelmetDropChance(it.getFloat(0))) }
                .function("chestplateDropChance", returnsObject().noParams()) { it.setReturnRef(it.target?.chestplateDropChance) }
                .function("setChestplateDropChance", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.setChestplateDropChance(
                        it.getFloat(0)
                    ))
                }
                .function("leggingsDropChance", returnsObject().noParams()) { it.setReturnRef(it.target?.leggingsDropChance) }
                .function("setLeggingsDropChance", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLeggingsDropChance(it.getFloat(0))) }
                .function("bootsDropChance", returnsObject().noParams()) { it.setReturnRef(it.target?.bootsDropChance) }
                .function("setBootsDropChance", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBootsDropChance(it.getFloat(0))) }
                .function("holder", returnsObject().noParams()) { it.setReturnRef(it.target?.holder) }
        }
    }
}
