package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityInteractEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEntityInteractEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityInteractEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("block", 0) { it.target?.getBlock() }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityInteractEvent.getHandlerList() }
        }
    }
}
