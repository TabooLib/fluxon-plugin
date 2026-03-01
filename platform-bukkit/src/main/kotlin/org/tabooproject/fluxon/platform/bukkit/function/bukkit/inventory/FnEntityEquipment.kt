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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.EntityEquipment"])
@PlatformSide(Platform.BUKKIT)
object FnEntityEquipment {

    val TYPE = Type.fromClass(EntityEquipment::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityEquipment::class.java)
                .function("setItem",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.target?.setItem(
                        it.getRef(0) as EquipmentSlot,
                        it.getRef(1) as ItemStack
                    )
                }
                .function("setItem",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.Z)) {
                    it.target?.setItem(
                        it.getRef(0) as EquipmentSlot,
                        it.getRef(1) as ItemStack,
                        it.getBool(2)
                    )
                }
                .function("getItem",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE)) { it.setReturnRef(it.target?.getItem(it.getRef(0) as EquipmentSlot)) }
                .function("itemInMainHand", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemInMainHand) }
                .function("setItemInMainHand",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.target?.setItemInMainHand(it.getRef(0) as ItemStack)
                }
                .function("setItemInMainHand",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.Z)) {
                    it.target?.setItemInMainHand(
                        it.getRef(0) as ItemStack,
                        it.getBool(1)
                    )
                }
                .function("itemInOffHand", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemInOffHand) }
                .function("setItemInOffHand",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.target?.setItemInOffHand(it.getRef(0) as ItemStack)
                }
                .function("setItemInOffHand",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.Z)) {
                    it.target?.setItemInOffHand(
                        it.getRef(0) as ItemStack,
                        it.getBool(1)
                    )
                }
                .function("itemInHand", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemInHand) }
                .function("setItemInHand",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setItemInHand(it.getRef(0) as ItemStack) }
                .function("helmet", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.helmet) }
                .function("setHelmet",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.target?.setHelmet(it.getRef(0) as ItemStack)
                }
                .function("setHelmet",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.Z)) {
                    it.target?.setHelmet(it.getRef(0) as ItemStack, it.getBool(1))
                }
                .function("chestplate", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.chestplate) }
                .function("setChestplate",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.target?.setChestplate(it.getRef(0) as ItemStack)
                }
                .function("setChestplate",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.Z)) {
                    it.target?.setChestplate(
                        it.getRef(0) as ItemStack,
                        it.getBool(1)
                    )
                }
                .function("leggings", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.leggings) }
                .function("setLeggings",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.target?.setLeggings(it.getRef(0) as ItemStack)
                }
                .function("setLeggings",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.Z)) {
                    it.target?.setLeggings(it.getRef(0) as ItemStack, it.getBool(1))
                }
                .function("boots", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.boots) }
                .function("setBoots",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.target?.setBoots(it.getRef(0) as ItemStack)
                }
                .function("setBoots",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.Z)) {
                    it.target?.setBoots(it.getRef(0) as ItemStack, it.getBool(1))
                }
                .function("armorContents", returns(Type.fromClass(Array<ItemStack>::class.java)).noParams()) { it.setReturnRef(it.target?.armorContents) }
                .function("setArmorContents", returnsVoid().params(Type.fromClass(Array<ItemStack>::class.java))) { it.target?.setArmorContents(it.getRef(0) as Array<ItemStack>) }
                .function("clear", returnsVoid().noParams()) { it.target?.clear() }
                .function("itemInHandDropChance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.itemInHandDropChance ?: 0f) }
                .function("setItemInHandDropChance", returnsVoid().params(Type.F)) { it.target?.setItemInHandDropChance(it.getFloat(0)) }
                .function("itemInMainHandDropChance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.itemInMainHandDropChance ?: 0f) }
                .function("setItemInMainHandDropChance", returnsVoid().params(Type.F)) { it.target?.setItemInMainHandDropChance(it.getFloat(0)) }
                .function("itemInOffHandDropChance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.itemInOffHandDropChance ?: 0f) }
                .function("setItemInOffHandDropChance", returnsVoid().params(Type.F)) { it.target?.setItemInOffHandDropChance(it.getFloat(0)) }
                .function("helmetDropChance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.helmetDropChance ?: 0f) }
                .function("setHelmetDropChance", returnsVoid().params(Type.F)) { it.target?.setHelmetDropChance(it.getFloat(0)) }
                .function("chestplateDropChance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.chestplateDropChance ?: 0f) }
                .function("setChestplateDropChance", returnsVoid().params(Type.F)) { it.target?.setChestplateDropChance(it.getFloat(0)) }
                .function("leggingsDropChance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.leggingsDropChance ?: 0f) }
                .function("setLeggingsDropChance", returnsVoid().params(Type.F)) { it.target?.setLeggingsDropChance(it.getFloat(0)) }
                .function("bootsDropChance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.bootsDropChance ?: 0f) }
                .function("setBootsDropChance", returnsVoid().params(Type.F)) { it.target?.setBootsDropChance(it.getFloat(0)) }
                .function("holder", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.holder) }
        }
    }
}
