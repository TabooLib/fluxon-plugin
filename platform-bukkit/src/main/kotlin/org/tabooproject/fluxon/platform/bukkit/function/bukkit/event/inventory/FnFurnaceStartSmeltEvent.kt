package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.FurnaceStartSmeltEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.inventory.FurnaceStartSmeltEvent"])
@PlatformSide(Platform.BUKKIT)
object FnFurnaceStartSmeltEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceStartSmeltEvent::class.java)
                .function("totalCookTime", 0) { it.target?.totalCookTime }
                .function("setTotalCookTime", 1) { it.target?.setTotalCookTime(it.getNumber(0).toInt()) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { FurnaceStartSmeltEvent.getHandlerList() }
        }
    }
}
