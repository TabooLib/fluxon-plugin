package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.TimeSkipEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnTimeSkipEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TimeSkipEvent::class.java)
                .function("skipReason", 0) { it.target?.skipReason }
                .function("skipAmount", 0) { it.target?.skipAmount }
                .function("setSkipAmount", 1) { it.target?.setSkipAmount(it.getNumber(0).toLong()) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { TimeSkipEvent.getHandlerList() }
        }
    }
}
