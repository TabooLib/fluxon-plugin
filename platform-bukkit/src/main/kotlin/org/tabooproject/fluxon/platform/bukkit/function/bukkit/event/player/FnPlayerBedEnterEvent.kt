package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import Event.Result
import org.bukkit.event.player.PlayerBedEnterEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPlayerBedEnterEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerBedEnterEvent::class.java)
                .function("bedEnterResult", 0) { it.target?.bedEnterResult }
                .function("setUseBed", 1) { it.target?.setUseBed(it.getArgument(0) as Event.Result) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("bed", 0) { it.target?.bed }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerBedEnterEvent.getHandlerList() }
        }
    }
}
