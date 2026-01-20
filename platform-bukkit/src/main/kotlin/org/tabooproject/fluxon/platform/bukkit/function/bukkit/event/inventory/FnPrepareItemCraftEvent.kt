package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPrepareItemCraftEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareItemCraftEvent::class.java)
                .function("recipe", 0) { it.target?.recipe }
                .function("inventory", 0) { it.target?.inventory }
                .function("isRepair", 0) { it.target?.isRepair }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PrepareItemCraftEvent.getHandlerList() }
        }
    }
}
