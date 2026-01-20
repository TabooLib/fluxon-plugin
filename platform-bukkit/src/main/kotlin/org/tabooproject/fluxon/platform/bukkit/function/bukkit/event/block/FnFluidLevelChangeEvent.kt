package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.block.data.BlockData
import org.bukkit.event.block.FluidLevelChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnFluidLevelChangeEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FluidLevelChangeEvent::class.java)
                .function("newData", 0) { it.target?.newData }
                .function("setNewData", 1) { it.target?.setNewData(it.getArgument(0) as BlockData) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { FluidLevelChangeEvent.getHandlerList() }
        }
    }
}
