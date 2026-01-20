package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityChangeBlockEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEntityChangeBlockEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityChangeBlockEvent::class.java)
                .function("block", 0) { it.target?.block }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("to", 0) { it.target?.to }
                .function("blockData", 0) { it.target?.blockData }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityChangeBlockEvent.getHandlerList() }
        }
    }
}
