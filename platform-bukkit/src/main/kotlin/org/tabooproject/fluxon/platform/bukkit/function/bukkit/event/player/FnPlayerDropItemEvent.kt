package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerDropItemEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerDropItemEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerDropItemEvent::class.java)
                .function("itemDrop", 0) { it.target?.itemDrop }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerDropItemEvent.getHandlerList() }
        }
    }
}
