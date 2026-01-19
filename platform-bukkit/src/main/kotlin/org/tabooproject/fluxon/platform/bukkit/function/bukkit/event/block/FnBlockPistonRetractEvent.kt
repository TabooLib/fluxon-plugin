package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockPistonRetractEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlockPistonRetractEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPistonRetractEvent::class.java)
                .function("retractLocation", 0) { it.target?.retractLocation }
                .function("blocks", 0) { it.target?.blocks }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BlockPistonRetractEvent.getHandlerList() }
        }
    }
}
