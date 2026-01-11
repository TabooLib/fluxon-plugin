package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.ArrowBodyCountChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnArrowBodyCountChangeEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ArrowBodyCountChangeEvent::class.java)
                .function("isReset", 0) { it.target?.isReset }
                .function("oldAmount", 0) { it.target?.oldAmount }
                .function("newAmount", 0) { it.target?.newAmount }
                .function("setNewAmount", 1) { it.target?.setNewAmount(it.getNumber(0).toInt()) }
                .function("entity", 0) { it.target?.getEntity() }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { ArrowBodyCountChangeEvent.getHandlerList() }
        }
    }
}
