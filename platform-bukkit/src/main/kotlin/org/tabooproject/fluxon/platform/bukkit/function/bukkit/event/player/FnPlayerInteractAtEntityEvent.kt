package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerInteractAtEntityEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.player.PlayerInteractAtEntityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerInteractAtEntityEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerInteractAtEntityEvent::class.java)
                .function("clickedPosition", 0) { it.target?.clickedPosition }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerInteractAtEntityEvent.getHandlerList() }
        }
    }
}
