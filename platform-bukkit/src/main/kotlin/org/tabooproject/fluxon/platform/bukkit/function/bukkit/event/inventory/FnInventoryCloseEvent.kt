package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryCloseEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnInventoryCloseEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryCloseEvent::class.java)
                .function("player", 0) { it.target?.player }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { InventoryCloseEvent.getHandlerList() }
        }
    }
}
