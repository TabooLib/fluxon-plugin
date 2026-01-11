package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.hanging

import org.bukkit.event.hanging.HangingPlaceEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnHangingPlaceEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HangingPlaceEvent::class.java)
                .function("player", 0) { it.target?.player }
                .function("block", 0) { it.target?.block }
                .function("blockFace", 0) { it.target?.blockFace }
                .function("hand", 0) { it.target?.hand }
                .function("itemStack", 0) { it.target?.itemStack }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { HangingPlaceEvent.getHandlerList() }
        }
    }
}
