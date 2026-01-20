package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockSpreadEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBlockSpreadEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockSpreadEvent::class.java)
                .function("source", 0) { it.target?.source }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BlockSpreadEvent.getHandlerList() }
        }
    }
}
