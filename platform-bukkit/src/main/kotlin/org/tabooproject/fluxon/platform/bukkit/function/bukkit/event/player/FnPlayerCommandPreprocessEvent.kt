package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPlayerCommandPreprocessEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerCommandPreprocessEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("message", 0) { it.target?.message }
                .function("setMessage", 1) { it.target?.setMessage(it.getString(0)!!) }
                .function("setPlayer", 1) { it.target?.setPlayer(it.getArgument(0) as Player) }
                .function("recipients", 0) { it.target?.recipients }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerCommandPreprocessEvent.getHandlerList() }
        }
    }
}
