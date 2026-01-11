package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.raid

import org.bukkit.event.raid.RaidTriggerEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnRaidTriggerEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RaidTriggerEvent::class.java)
                .function("player", 0) { it.target?.player }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { RaidTriggerEvent.getHandlerList() }
        }
    }
}
