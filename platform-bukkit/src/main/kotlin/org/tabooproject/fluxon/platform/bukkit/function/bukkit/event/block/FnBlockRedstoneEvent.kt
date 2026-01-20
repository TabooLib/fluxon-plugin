package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockRedstoneEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBlockRedstoneEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockRedstoneEvent::class.java)
                .function("oldCurrent", 0) { it.target?.oldCurrent }
                .function("newCurrent", 0) { it.target?.newCurrent }
                .function("setNewCurrent", 1) { it.target?.setNewCurrent(it.getNumber(0).toInt()) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BlockRedstoneEvent.getHandlerList() }
        }
    }
}
