package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.hanging

import org.bukkit.event.hanging.HangingBreakEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnHangingBreakEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HangingBreakEvent::class.java)
                .function("cause", 0) { it.target?.cause }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { HangingBreakEvent.getHandlerList() }
        }
    }
}
