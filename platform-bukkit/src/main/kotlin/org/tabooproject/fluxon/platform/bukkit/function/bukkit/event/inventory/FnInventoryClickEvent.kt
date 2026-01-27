package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.inventory.InventoryClickEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryClickEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryClickEvent::class.java)
                .function("cursor", 0) { it.target?.cursor }
                .function("currentItem", 0) { it.target?.currentItem }
                .function("isRightClick", 0) { it.target?.isRightClick }
                .function("isLeftClick", 0) { it.target?.isLeftClick }
                .function("isShiftClick", 0) { it.target?.isShiftClick }
                .function("setCursor", 1) { it.target?.setCursor(it.getArgument(0) as ItemStack) }
                .function("setCurrentItem", 1) { it.target?.setCurrentItem(it.getArgument(0) as ItemStack) }
                .function("clickedInventory", 0) { it.target?.clickedInventory }
                .function("slot", 0) { it.target?.slot }
                .function("rawSlot", 0) { it.target?.rawSlot }
                .function("hotbarButton", 0) { it.target?.hotbarButton }
                .function("action", 0) { it.target?.action }
                .function("click", 0) { it.target?.click }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { InventoryClickEvent.getHandlerList() }
        }
    }
}
