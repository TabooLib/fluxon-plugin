package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.ChunkPopulateEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnChunkPopulateEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChunkPopulateEvent::class.java)
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { ChunkPopulateEvent.getHandlerList() }
        }
    }
}
