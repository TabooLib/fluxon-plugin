package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockReceiveGameEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBlockReceiveGameEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockReceiveGameEvent::class.java)
                .function("event", 0) { it.target?.event }
                .function("entity", 0) { it.target?.entity }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BlockReceiveGameEvent.getHandlerList() }
        }
    }
}
