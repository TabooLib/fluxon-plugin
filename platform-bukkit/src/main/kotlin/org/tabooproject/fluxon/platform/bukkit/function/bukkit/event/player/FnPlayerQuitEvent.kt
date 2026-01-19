package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerQuitEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPlayerQuitEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerQuitEvent::class.java)
                .function("quitMessage", 0) { it.target?.quitMessage }
                .function("setQuitMessage", 1) { it.target?.setQuitMessage(it.getString(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerQuitEvent.getHandlerList() }
        }
    }
}
