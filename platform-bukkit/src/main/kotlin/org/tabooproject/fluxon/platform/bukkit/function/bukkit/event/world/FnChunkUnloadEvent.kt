package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.ChunkUnloadEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.world.ChunkUnloadEvent"])
@PlatformSide(Platform.BUKKIT)
object FnChunkUnloadEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChunkUnloadEvent::class.java)
                .function("isSaveChunk", 0) { it.target?.isSaveChunk }
                .function("setSaveChunk", 1) { it.target?.setSaveChunk(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { ChunkUnloadEvent.getHandlerList() }
        }
    }
}
