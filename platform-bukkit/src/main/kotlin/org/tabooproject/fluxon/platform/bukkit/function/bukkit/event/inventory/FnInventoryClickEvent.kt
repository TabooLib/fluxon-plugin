package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryAction
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.InventoryClickEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryClickEvent {

    val TYPE = Type.fromClass(InventoryClickEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryClickEvent::class.java)
                .function("cursor", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.cursor) }
                .function("currentItem", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.currentItem) }
                .function("isRightClick", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRightClick ?: false) }
                .function("isLeftClick", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLeftClick ?: false) }
                .function("isShiftClick", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isShiftClick ?: false) }
                .function("setCursor", returnsVoid().params(FnItemStack.TYPE)) { it.target?.setCursor(it.getRef(0) as ItemStack) }
                .function("setCurrentItem", returnsVoid().params(FnItemStack.TYPE)) { it.target?.setCurrentItem(it.getRef(0) as ItemStack) }
                .function("clickedInventory", returns(FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.clickedInventory) }
                .function("slot", returns(Type.I).noParams()) { it.setReturnInt(it.target?.slot ?: 0) }
                .function("rawSlot", returns(Type.I).noParams()) { it.setReturnInt(it.target?.rawSlot ?: 0) }
                .function("hotbarButton", returns(Type.I).noParams()) { it.setReturnInt(it.target?.hotbarButton ?: 0) }
                .function("action", returns(FnInventoryAction.TYPE).noParams()) { it.setReturnRef(it.target?.action) }
                .function("click", returns(FnClickType.TYPE).noParams()) { it.setReturnRef(it.target?.click) }
        }
    }
}
