package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerBedLeaveEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerBedLeaveEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerBedLeaveEvent::class.java)
                .function("bed", 0) { it.target?.bed }
                .function("shouldSetSpawnLocation", 0) { it.target?.shouldSetSpawnLocation() }
                .function("setSpawnLocation", 1) { it.target?.setSpawnLocation(it.getBoolean(0)) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerBedLeaveEvent.getHandlerList() }
        }
    }
}
