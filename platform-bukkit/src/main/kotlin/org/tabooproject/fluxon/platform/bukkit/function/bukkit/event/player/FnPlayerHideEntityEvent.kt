package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerHideEntityEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerHideEntityEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerHideEntityEvent::class.java)
                .function("entity", 0) { it.target?.entity }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerHideEntityEvent.getHandlerList() }
        }
    }
}
