package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.TradeSelectEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnTradeSelectEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TradeSelectEvent::class.java)
                .function("index", 0) { it.target?.index }
                .function("inventory", 0) { it.target?.inventory }
                .function("merchant", 0) { it.target?.merchant }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { TradeSelectEvent.getHandlerList() }
        }
    }
}
