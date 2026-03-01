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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.PlayerInventory"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerInventory {

    val TYPE = Type.fromClass(PlayerInventory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerInventory::class.java)
                .function("armorContents", returns(Type.fromClass(Array<ItemStack>::class.java)).noParams()) { it.setReturnRef(it.target?.armorContents) }
                .function("extraContents", returns(Type.fromClass(Array<ItemStack>::class.java)).noParams()) { it.setReturnRef(it.target?.extraContents) }
                .function("helmet", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.helmet) }
                .function("chestplate", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.chestplate) }
                .function("leggings", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.leggings) }
                .function("boots", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.boots) }
                .function("setItem",returnsVoid().params(Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setItem(it.getInt(0), it.getRef(1) as ItemStack) }
                .function("setItem",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setItem(it.getRef(0) as EquipmentSlot, it.getRef(1) as ItemStack) }
                .function("getItem",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE)) { it.setReturnRef(it.target?.getItem(it.getRef(0) as EquipmentSlot)) }
                .function("setArmorContents", returnsVoid().params(Type.fromClass(Array<ItemStack>::class.java))) { it.target?.setArmorContents(it.getRef(0) as Array<ItemStack>) }
                .function("setExtraContents", returnsVoid().params(Type.fromClass(Array<ItemStack>::class.java))) { it.target?.setExtraContents(it.getRef(0) as Array<ItemStack>) }
                .function("setHelmet",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setHelmet(it.getRef(0) as ItemStack) }
                .function("setChestplate",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setChestplate(it.getRef(0) as ItemStack) }
                .function("setLeggings",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setLeggings(it.getRef(0) as ItemStack) }
                .function("setBoots",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setBoots(it.getRef(0) as ItemStack) }
                .function("itemInMainHand", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemInMainHand) }
                .function("setItemInMainHand",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setItemInMainHand(it.getRef(0) as ItemStack) }
                .function("itemInOffHand", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemInOffHand) }
                .function("setItemInOffHand",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setItemInOffHand(it.getRef(0) as ItemStack) }
                .function("itemInHand", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemInHand) }
                .function("setItemInHand",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setItemInHand(it.getRef(0) as ItemStack) }
                .function("heldItemSlot", returns(Type.I).noParams()) { it.setReturnInt(it.target?.heldItemSlot ?: 0) }
                .function("setHeldItemSlot", returnsVoid().params(Type.I)) { it.target?.setHeldItemSlot(it.getInt(0).toInt()) }
                .function("holder", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHumanEntity.TYPE).noParams()) { it.setReturnRef(it.target?.holder) }
        }
    }
}
