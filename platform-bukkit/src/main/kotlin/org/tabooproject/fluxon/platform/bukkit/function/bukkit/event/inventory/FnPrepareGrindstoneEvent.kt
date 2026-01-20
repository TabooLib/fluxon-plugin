package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.PrepareGrindstoneEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPrepareGrindstoneEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareGrindstoneEvent::class.java)
                .function("inventory", 0) { it.target?.inventory }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PrepareGrindstoneEvent.getHandlerList() }
        }
    }
}
