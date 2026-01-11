package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.HopperInventorySearchEvent
import org.bukkit.inventory.Inventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnHopperInventorySearchEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HopperInventorySearchEvent::class.java)
                .function("setInventory", 1) { it.target?.setInventory(it.getArgument(0) as Inventory) }
                .function("inventory", 0) { it.target?.inventory }
                .function("containerType", 0) { it.target?.containerType }
                .function("searchBlock", 0) { it.target?.searchBlock }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { HopperInventorySearchEvent.getHandlerList() }
        }
    }
}
