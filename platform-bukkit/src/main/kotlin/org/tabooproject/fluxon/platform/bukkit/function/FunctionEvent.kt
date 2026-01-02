package org.tabooproject.fluxon.platform.bukkit.function

import org.bukkit.event.Cancellable
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityEvent
import org.bukkit.event.entity.EntityRegainHealthEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FunctionEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cancellable::class.java)
                .function("isCancelled", 0) {
                    it.target?.isCancelled
                }
                .function("setCancelled", 1) {
                    it.target?.setCancelled(it.getBoolean(0))
                }
            // EntityEvent
            registerExtension(EntityEvent::class.java)
                .function("entity", 0) {
                    it.target?.entity
                }
            // EntityDamageEvent
            registerExtension(EntityDamageEvent::class.java)
                .function("damage", 0) {
                    it.target?.damage
                }
                .function("setDamage", 1) {
                    it.target?.setDamage(it.getNumber(0).toDouble())
                }
                .function("finalDamage", 0) {
                    it.target?.finalDamage
                }
                .function("cause", 0) {
                    it.target?.cause
                }
            // EntityRegainHealthEvent
            registerExtension(EntityRegainHealthEvent::class.java)
                .function("amount", 0) {
                    it.target?.amount
                }
                .function("setAmount", 1) {
                    it.target?.setAmount(it.getNumber(0).toDouble())
                }
                .function("regainReason", 0) {
                    it.target?.regainReason
                }
        }
    }
}