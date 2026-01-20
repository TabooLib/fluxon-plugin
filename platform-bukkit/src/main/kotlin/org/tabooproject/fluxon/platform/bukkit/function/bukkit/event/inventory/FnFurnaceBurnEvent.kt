package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.FurnaceBurnEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnFurnaceBurnEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceBurnEvent::class.java)
                .function("fuel", 0) { it.target?.fuel }
                .function("burnTime", 0) { it.target?.burnTime }
                .function("setBurnTime", 1) { it.target?.setBurnTime(it.getNumber(0).toInt()) }
                .function("isBurning", 0) { it.target?.isBurning }
                .function("setBurning", 1) { it.target?.setBurning(it.getBoolean(0)) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { FurnaceBurnEvent.getHandlerList() }
        }
    }
}
