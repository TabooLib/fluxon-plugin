package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.raid

import org.bukkit.event.raid.RaidFinishEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnRaidFinishEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RaidFinishEvent::class.java)
                .function("winners", 0) { it.target?.winners }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { RaidFinishEvent.getHandlerList() }
        }
    }
}
