package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.inventory.InventoryDragEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryDragEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryDragEvent::class.java)
                .function("rawSlots", returnsObject().noParams()) { it.setReturnRef(it.target?.rawSlots) }
                .function("inventorySlots", returnsObject().noParams()) { it.setReturnRef(it.target?.inventorySlots) }
                .function("cursor", returnsObject().noParams()) { it.setReturnRef(it.target?.cursor) }
                .function("setCursor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCursor(it.getRef(0) as ItemStack)) }
                .function("oldCursor", returnsObject().noParams()) { it.setReturnRef(it.target?.oldCursor) }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(InventoryDragEvent.getHandlerList()) }
        }
    }
}
