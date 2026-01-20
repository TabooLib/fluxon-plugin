package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerLevelChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerLevelChangeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerLevelChangeEvent::class.java)
                .function("oldLevel", 0) { it.target?.oldLevel }
                .function("newLevel", 0) { it.target?.newLevel }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerLevelChangeEvent.getHandlerList() }
        }
    }
}
