package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityExhaustionEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntityExhaustionEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityExhaustionEvent::class.java)
                .function("exhaustionReason", 0) { it.target?.exhaustionReason }
                .function("exhaustion", 0) { it.target?.exhaustion }
                .function("setExhaustion", 1) { it.target?.setExhaustion(it.getNumber(0).toFloat()) }
                .function("entity", 0) { it.target?.getEntity() }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityExhaustionEvent.getHandlerList() }
        }
    }
}
