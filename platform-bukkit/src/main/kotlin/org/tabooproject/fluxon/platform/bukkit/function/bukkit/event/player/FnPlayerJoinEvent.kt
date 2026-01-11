package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerJoinEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPlayerJoinEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerJoinEvent::class.java)
                .function("joinMessage", 0) { it.target?.joinMessage }
                .function("setJoinMessage", 1) { it.target?.setJoinMessage(it.getString(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerJoinEvent.getHandlerList() }
        }
    }
}
