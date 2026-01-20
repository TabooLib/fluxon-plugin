package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityRegainHealthEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnEntityRegainHealthEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityRegainHealthEvent::class.java)
                .function("amount", 0) { it.target?.amount }
                .function("setAmount", 1) { it.target?.setAmount(it.getNumber(0).toDouble()) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("regainReason", 0) { it.target?.regainReason }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityRegainHealthEvent.getHandlerList() }
        }
    }
}
