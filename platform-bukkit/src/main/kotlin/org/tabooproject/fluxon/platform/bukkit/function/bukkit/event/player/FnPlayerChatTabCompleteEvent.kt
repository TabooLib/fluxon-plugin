package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerChatTabCompleteEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPlayerChatTabCompleteEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerChatTabCompleteEvent::class.java)
                .function("chatMessage", 0) { it.target?.chatMessage }
                .function("lastToken", 0) { it.target?.lastToken }
                .function("tabCompletions", 0) { it.target?.tabCompletions }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerChatTabCompleteEvent.getHandlerList() }
        }
    }
}
