package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.inventory.InventoryClickEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryClickEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryClickEvent::class.java)
                .function("cursor", returnsObject().noParams()) { it.setReturnRef(it.target?.cursor) }
                .function("currentItem", returnsObject().noParams()) { it.setReturnRef(it.target?.currentItem) }
                .function("isRightClick", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isRightClick) }
                .function("isLeftClick", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isLeftClick) }
                .function("isShiftClick", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isShiftClick) }
                .function("setCursor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCursor(it.getRef(0) as ItemStack)) }
                .function("setCurrentItem", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCurrentItem(it.getRef(0) as ItemStack)) }
                .function("clickedInventory", returnsObject().noParams()) { it.setReturnRef(it.target?.clickedInventory) }
                .function("slot", returnsObject().noParams()) { it.setReturnRef(it.target?.slot) }
                .function("rawSlot", returnsObject().noParams()) { it.setReturnRef(it.target?.rawSlot) }
                .function("hotbarButton", returnsObject().noParams()) { it.setReturnRef(it.target?.hotbarButton) }
                .function("action", returnsObject().noParams()) { it.setReturnRef(it.target?.action) }
                .function("click", returnsObject().noParams()) { it.setReturnRef(it.target?.click) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(InventoryClickEvent.getHandlerList()) }
        }
    }
}
