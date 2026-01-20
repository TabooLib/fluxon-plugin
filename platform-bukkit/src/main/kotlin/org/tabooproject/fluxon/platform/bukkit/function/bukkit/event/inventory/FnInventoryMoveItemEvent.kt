package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryMoveItemEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnInventoryMoveItemEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryMoveItemEvent::class.java)
                .function("source", 0) { it.target?.source }
                .function("item", 0) { it.target?.item }
                .function("setItem", 1) { it.target?.setItem(it.getArgument(0) as ItemStack) }
                .function("destination", 0) { it.target?.destination }
                .function("initiator", 0) { it.target?.initiator }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { InventoryMoveItemEvent.getHandlerList() }
        }
    }
}
