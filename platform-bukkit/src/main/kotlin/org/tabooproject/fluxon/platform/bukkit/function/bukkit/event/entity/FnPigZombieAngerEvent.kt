package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.PigZombieAngerEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPigZombieAngerEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PigZombieAngerEvent::class.java)
                .function("target", 0) { it.target?.target }
                .function("newAnger", 0) { it.target?.newAnger }
                .function("setNewAnger", 1) { it.target?.setNewAnger(it.getNumber(0).toInt()) }
                .function("entity", 0) { it.target?.getEntity() }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PigZombieAngerEvent.getHandlerList() }
        }
    }
}
