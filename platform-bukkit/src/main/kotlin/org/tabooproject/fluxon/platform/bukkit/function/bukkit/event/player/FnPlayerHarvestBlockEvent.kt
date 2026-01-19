package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerHarvestBlockEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPlayerHarvestBlockEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerHarvestBlockEvent::class.java)
                .function("harvestedBlock", 0) { it.target?.harvestedBlock }
                .function("hand", 0) { it.target?.hand }
                .function("itemsHarvested", 0) { it.target?.itemsHarvested }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerHarvestBlockEvent.getHandlerList() }
        }
    }
}
