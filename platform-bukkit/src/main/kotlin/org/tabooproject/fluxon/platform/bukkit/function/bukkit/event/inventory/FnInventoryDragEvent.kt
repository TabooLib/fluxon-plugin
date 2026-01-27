package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.inventory.InventoryDragEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryDragEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryDragEvent::class.java)
                .function("rawSlots", 0) { it.target?.rawSlots }
                .function("inventorySlots", 0) { it.target?.inventorySlots }
                .function("cursor", 0) { it.target?.cursor }
                .function("setCursor", 1) { it.target?.setCursor(it.getArgument(0) as ItemStack) }
                .function("oldCursor", 0) { it.target?.oldCursor }
                .function("type", 0) { it.target?.type }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { InventoryDragEvent.getHandlerList() }
        }
    }
}
