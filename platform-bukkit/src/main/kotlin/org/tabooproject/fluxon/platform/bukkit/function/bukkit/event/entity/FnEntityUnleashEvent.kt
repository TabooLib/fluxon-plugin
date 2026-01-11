package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityUnleashEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntityUnleashEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityUnleashEvent::class.java)
                .function("reason", 0) { it.target?.reason }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityUnleashEvent.getHandlerList() }
        }
    }
}
