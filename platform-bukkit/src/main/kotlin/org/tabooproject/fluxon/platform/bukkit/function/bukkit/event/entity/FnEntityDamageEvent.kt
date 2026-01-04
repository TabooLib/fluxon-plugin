package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityDamageEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntityDamageEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
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
        }
    }
}