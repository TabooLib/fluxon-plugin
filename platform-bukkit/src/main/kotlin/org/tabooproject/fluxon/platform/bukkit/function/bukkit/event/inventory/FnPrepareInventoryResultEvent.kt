package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.PrepareInventoryResultEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPrepareInventoryResultEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareInventoryResultEvent::class.java)
                .function("result", 0) { it.target?.result }
                .function("setResult", 1) { it.target?.setResult(it.getArgument(0) as ItemStack) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PrepareInventoryResultEvent.getHandlerList() }
        }
    }
}
