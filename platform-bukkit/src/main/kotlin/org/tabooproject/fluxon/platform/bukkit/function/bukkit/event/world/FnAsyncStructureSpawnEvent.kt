package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.AsyncStructureSpawnEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAsyncStructureSpawnEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AsyncStructureSpawnEvent::class.java)
                .function("structure", 0) { it.target?.structure }
                .function("boundingBox", 0) { it.target?.boundingBox }
                .function("chunkX", 0) { it.target?.chunkX }
                .function("chunkZ", 0) { it.target?.chunkZ }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { AsyncStructureSpawnEvent.getHandlerList() }
        }
    }
}
