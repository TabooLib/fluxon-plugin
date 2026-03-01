package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.InventoryView
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

@Requires(classes = ["org.bukkit.inventory.InventoryView"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryView {

    val TYPE = Type.fromClass(InventoryView::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryView::class.java)
                .function("topInventory",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.topInventory) }
                .function("bottomInventory",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.bottomInventory) }
                .function("player",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHumanEntity.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("type",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory.FnInventoryType.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
                .function("setItem",returnsVoid().params(Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setItem(it.getInt(0).toInt(), it.getRef(1) as ItemStack) }
                .function("getItem",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(Type.I)) { it.setReturnRef(it.target?.getItem(it.getInt(0).toInt())) }
                .function("setCursor",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setCursor(it.getRef(0) as ItemStack) }
                .function("cursor",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.cursor) }
                .function("getInventory",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).params(Type.I)) { it.setReturnRef(it.target?.getInventory(it.getInt(0).toInt())) }
                .function("convertSlot", returns(Type.I).params(Type.I)) { it.setReturnInt(it.target?.convertSlot(it.getInt(0).toInt()) ?: 0) }
                .function("close", returnsVoid().noParams()) { it.target?.close() }
                .function("countSlots", returns(Type.I).noParams()) { it.setReturnInt(it.target?.countSlots() ?: 0) }
                .function("setProperty",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryViewProperty.TYPE, Type.I)) {
                    it.setReturnBool(it.target?.setProperty(
                        it.getRef(0) as InventoryView.Property,
                        it.getInt(1).toInt()
                    ) == true)
                }
                .function("title", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.title) }
                .function("originalTitle", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.originalTitle) }
                .function("setTitle", returnsVoid().params(Type.STRING)) { it.target?.setTitle(it.getString(0)!!) }
        }
    }
}

@Requires(classes = ["org.bukkit.inventory.InventoryView\$Property"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryViewProperty : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.inventory.InventoryView.Property>() {

    override val enumClass: Class<org.bukkit.inventory.InventoryView.Property> = org.bukkit.inventory.InventoryView.Property::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryView.Property::class.java)
                .function("id", returns(Type.I).noParams()) { it.setReturnInt(it.target?.id ?: 0) }
        }
    }
}
