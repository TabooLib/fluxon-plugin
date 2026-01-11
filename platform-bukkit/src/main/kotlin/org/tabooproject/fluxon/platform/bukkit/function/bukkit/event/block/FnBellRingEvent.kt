package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BellRingEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBellRingEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BellRingEvent::class.java)
                .function("direction", 0) { it.target?.direction }
                .function("entity", 0) { it.target?.entity }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BellRingEvent.getHandlerList() }
        }
    }
}
