package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.PrepareSmithingEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPrepareSmithingEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareSmithingEvent::class.java)
                .function("inventory", 0) { it.target?.inventory }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PrepareSmithingEvent.getHandlerList() }
        }
    }
}
