package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.Event
import org.bukkit.event.inventory.InventoryInteractEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnInventoryInteractEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryInteractEvent::class.java)
                .function("whoClicked", 0) { it.target?.whoClicked }
                .function("setResult", 1) { it.target?.setResult(it.getArgument(0) as Event.Result) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
        }
    }
}
