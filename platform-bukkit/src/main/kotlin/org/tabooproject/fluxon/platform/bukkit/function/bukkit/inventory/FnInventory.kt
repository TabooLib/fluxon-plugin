package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.Inventory"])
@PlatformSide(Platform.BUKKIT)
object FnInventory {

    val TYPE = Type.fromClass(Inventory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Inventory::class.java)
                .function("size", returns(Type.I).noParams()) { it.setReturnInt(it.target?.size ?: 0) }
                .function("maxStackSize", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxStackSize ?: 0) }
                .function("setMaxStackSize", returnsVoid().params(Type.I)) { it.target?.setMaxStackSize(it.getInt(0).toInt()) }
                .function("getItem", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(Type.I)) { it.setReturnRef(it.target?.getItem(it.getInt(0).toInt())) }
                .function("setItem",returnsVoid().params(Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.target?.setItem(it.getInt(0).toInt(), it.getRef(1) as ItemStack)
                }
                .function("contents", returns(Type.fromClass(Array<ItemStack>::class.java)).noParams()) { it.setReturnRef(it.target?.contents) }
                .function("setContents", returnsVoid().params(Type.fromClass(Array<ItemStack>::class.java))) { it.target?.setContents(it.getRef(0) as Array<ItemStack>) }
                .function("storageContents", returns(Type.fromClass(Array<ItemStack>::class.java)).noParams()) { it.setReturnRef(it.target?.storageContents) }
                .function("setStorageContents", returnsVoid().params(Type.fromClass(Array<ItemStack>::class.java))) { it.target?.setStorageContents(it.getRef(0) as Array<ItemStack>) }
                .function("contains", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnBool(it.target?.contains(it.getRef(0) as Material) ?: false) }
                .function("contains", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.setReturnBool(it.target?.contains(it.getRef(0) as ItemStack) ?: false) }
                .function("contains", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, Type.I)) { it.setReturnBool(it.target?.contains(it.getRef(0) as Material, it.getInt(1).toInt()) ?: false) }
                .function("contains", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.I)) { it.setReturnBool(it.target?.contains(it.getRef(0) as ItemStack, it.getInt(1).toInt()) ?: false) }
                .function("containsAtLeast",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.I)) {
                    it.setReturnBool(it.target?.containsAtLeast(
                        it.getRef(0) as ItemStack,
                        it.getInt(1).toInt()
                    ) ?: false)
                }
                .function("first", returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnInt(it.target?.first(it.getRef(0) as Material) ?: -1) }
                .function("first", returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.setReturnInt(it.target?.first(it.getRef(0) as ItemStack) ?: -1) }
                .function("firstEmpty", returns(Type.I).noParams()) { it.setReturnInt(it.target?.firstEmpty() ?: -1) }
                .function("isEmpty", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEmpty ?: false) }
                .function("remove", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.target?.remove(it.getRef(0) as Material) }
                .function("remove", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.remove(it.getRef(0) as ItemStack) }
                .function("clear", returnsVoid().noParams()) { it.target?.clear() }
                .function("clear", returnsVoid().params(Type.I)) { it.target?.clear(it.getInt(0).toInt()) }
                .function("viewers", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.viewers) }
                .function("type", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory.FnInventoryType.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
                .function("holder", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryHolder.TYPE).noParams()) { it.setReturnRef(it.target?.holder) }
                .function("iterator", returns(Type.fromClass(java.util.ListIterator::class.java)).noParams()) { it.setReturnRef(it.target?.iterator()) }
                .function("iterator", returns(Type.fromClass(java.util.ListIterator::class.java)).params(Type.I)) { it.setReturnRef(it.target?.iterator(it.getInt(0).toInt())) }
                .function("location", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.location) }
        }
    }
}
