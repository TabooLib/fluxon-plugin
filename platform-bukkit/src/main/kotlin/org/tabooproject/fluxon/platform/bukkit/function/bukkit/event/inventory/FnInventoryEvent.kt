package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.inventory.InventoryEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryEvent::class.java)
                .function("inventory", 0) { it.target?.inventory }
                .function("viewers", 0) { it.target?.viewers }
                .function("view", 0) { it.target?.view }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { InventoryEvent.getHandlerList() }
        }
    }
}
