package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityRegainHealthEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntityRegainHealthEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
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