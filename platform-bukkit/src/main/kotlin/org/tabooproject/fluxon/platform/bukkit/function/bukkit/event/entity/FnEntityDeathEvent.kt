package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityDeathEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntityDeathEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityDeathEvent::class.java)
                .function("entity", 0) { it.target?.getEntity() }
                .function("damageSource", 0) { it.target?.damageSource }
                .function("droppedExp", 0) { it.target?.droppedExp }
                .function("setDroppedExp", 1) { it.target?.setDroppedExp(it.getNumber(0).toInt()) }
                .function("drops", 0) { it.target?.drops }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityDeathEvent.getHandlerList() }
        }
    }
}
