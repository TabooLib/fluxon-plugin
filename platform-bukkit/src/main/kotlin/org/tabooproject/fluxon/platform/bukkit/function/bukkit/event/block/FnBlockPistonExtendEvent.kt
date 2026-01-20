package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockPistonExtendEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBlockPistonExtendEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPistonExtendEvent::class.java)
                .function("length", 0) { it.target?.length }
                .function("blocks", 0) { it.target?.blocks }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BlockPistonExtendEvent.getHandlerList() }
        }
    }
}
