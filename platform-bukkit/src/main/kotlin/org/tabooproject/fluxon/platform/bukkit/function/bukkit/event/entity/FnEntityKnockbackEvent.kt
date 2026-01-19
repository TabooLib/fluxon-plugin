package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityKnockbackEvent
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntityKnockbackEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityKnockbackEvent::class.java)
                .function("entity", 0) { it.target?.getEntity() }
                .function("cause", 0) { it.target?.cause }
                .function("force", 0) { it.target?.force }
                .function("knockback", 0) { it.target?.knockback }
                .function("finalKnockback", 0) { it.target?.finalKnockback }
                .function("setFinalKnockback", 1) { it.target?.setFinalKnockback(it.getArgument(0) as Vector) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityKnockbackEvent.getHandlerList() }
        }
    }
}
