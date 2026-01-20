package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerChannelEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerChannelEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerChannelEvent::class.java)
                .function("channel", 0) { it.target?.channel }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerChannelEvent.getHandlerList() }
        }
    }
}
