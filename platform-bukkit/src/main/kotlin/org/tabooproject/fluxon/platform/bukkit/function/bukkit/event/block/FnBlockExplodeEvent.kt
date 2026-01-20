package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockExplodeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnBlockExplodeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockExplodeEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("explodedBlockState", 0) { it.target?.explodedBlockState }
                .function("blockList", 0) { it.target?.blockList() }
                .function("yield", 0) { it.target?.yield }
                .function("setYield", 1) { it.target?.setYield(it.getNumber(0).toFloat()) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BlockExplodeEvent.getHandlerList() }
        }
    }
}
