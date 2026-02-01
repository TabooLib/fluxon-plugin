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
                .function("armorContents", returnsObject().noParams()) { it.setReturnRef(it.target?.armorContents) }
                .function("extraContents", returnsObject().noParams()) { it.setReturnRef(it.target?.extraContents) }
                .function("helmet", returnsObject().noParams()) { it.setReturnRef(it.target?.helmet) }
                .function("chestplate", returnsObject().noParams()) { it.setReturnRef(it.target?.chestplate) }
                .function("leggings", returnsObject().noParams()) { it.setReturnRef(it.target?.leggings) }
                .function("boots", returnsObject().noParams()) { it.setReturnRef(it.target?.boots) }
                .function("setItem", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is Int -> it.target?.setItem(var1, it.getRef(1) as ItemStack)
                        is EquipmentSlot -> it.target?.setItem(var1, it.getRef(1) as ItemStack)
                        else -> throw IllegalArgumentException("参数 1 必须是 Int 或 EquipmentSlot 类型")
                    }
                }
                .function("getItem", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getItem(it.getRef(0) as EquipmentSlot)) }
                .function("setArmorContents", returnsVoid().params(Type.OBJECT)) { it.target?.setArmorContents(it.getRef(0) as Array<ItemStack>) }
                .function("setExtraContents", returnsVoid().params(Type.OBJECT)) { it.target?.setExtraContents(it.getRef(0) as Array<ItemStack>) }
                .function("setHelmet", returnsVoid().params(Type.OBJECT)) { it.target?.setHelmet(it.getRef(0) as ItemStack) }
                .function("setChestplate", returnsVoid().params(Type.OBJECT)) { it.target?.setChestplate(it.getRef(0) as ItemStack) }
                .function("setLeggings", returnsVoid().params(Type.OBJECT)) { it.target?.setLeggings(it.getRef(0) as ItemStack) }
                .function("setBoots", returnsVoid().params(Type.OBJECT)) { it.target?.setBoots(it.getRef(0) as ItemStack) }
                .function("itemInMainHand", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInMainHand) }
                .function("setItemInMainHand", returnsVoid().params(Type.OBJECT)) { it.target?.setItemInMainHand(it.getRef(0) as ItemStack) }
                .function("itemInOffHand", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInOffHand) }
                .function("setItemInOffHand", returnsVoid().params(Type.OBJECT)) { it.target?.setItemInOffHand(it.getRef(0) as ItemStack) }
                .function("itemInHand", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInHand) }
                .function("setItemInHand", returnsVoid().params(Type.OBJECT)) { it.target?.setItemInHand(it.getRef(0) as ItemStack) }
                .function("heldItemSlot", returns(Type.I).noParams()) { it.setReturnInt(it.target?.heldItemSlot ?: 0) }
                .function("setHeldItemSlot", returnsVoid().params(Type.I)) { it.target?.setHeldItemSlot(it.getInt(0).toInt()) }
                .function("holder", returnsObject().noParams()) { it.setReturnRef(it.target?.holder) }
        }
    }
}
