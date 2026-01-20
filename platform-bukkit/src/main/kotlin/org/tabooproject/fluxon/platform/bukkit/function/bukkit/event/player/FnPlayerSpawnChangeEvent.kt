package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.Location
import org.bukkit.event.player.PlayerSpawnChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerSpawnChangeEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerSpawnChangeEvent::class.java)
                .function("cause", 0) { it.target?.cause }
                .function("isForced", 0) { it.target?.isForced }
                .function("setForced", 1) { it.target?.setForced(it.getBoolean(0)) }
                .function("newSpawn", 0) { it.target?.newSpawn }
                .function("setNewSpawn", 1) { it.target?.setNewSpawn(it.getArgument(0) as Location) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerSpawnChangeEvent.getHandlerList() }
        }
    }
}
