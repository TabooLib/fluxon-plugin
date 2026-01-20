package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.raid

import org.bukkit.event.raid.RaidStopEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnRaidStopEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RaidStopEvent::class.java)
                .function("reason", 0) { it.target?.reason }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { RaidStopEvent.getHandlerList() }
        }
    }
}
