package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.BatToggleSleepEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBatToggleSleepEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BatToggleSleepEvent::class.java)
                .function("isAwake", 0) { it.target?.isAwake }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BatToggleSleepEvent.getHandlerList() }
        }
    }
}
