package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.Location
import org.bukkit.event.player.PlayerRespawnEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPlayerRespawnEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerRespawnEvent::class.java)
                .function("respawnLocation", 0) { it.target?.respawnLocation }
                .function("setRespawnLocation", 1) { it.target?.setRespawnLocation(it.getArgument(0) as Location) }
                .function("isBedSpawn", 0) { it.target?.isBedSpawn }
                .function("isAnchorSpawn", 0) { it.target?.isAnchorSpawn }
                .function("respawnReason", 0) { it.target?.respawnReason }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerRespawnEvent.getHandlerList() }
        }
    }
}
