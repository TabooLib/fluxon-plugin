package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerCommandSendEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerCommandSendEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerCommandSendEvent::class.java)
                .function("commands", 0) { it.target?.commands }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerCommandSendEvent.getHandlerList() }
        }
    }
}
