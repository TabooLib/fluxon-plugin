package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.util.StandardTypes
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.InventoryDragEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryDragEvent {

    val TYPE = Type.fromClass(InventoryDragEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryDragEvent::class.java)
                .function("rawSlots", returns(StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.rawSlots) }
                .function("inventorySlots", returns(StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.inventorySlots) }
                .function("cursor", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.cursor) }
                .function("setCursor", returnsVoid().params(FnItemStack.TYPE)) { it.target?.setCursor(it.getRef(0) as ItemStack) }
                .function("oldCursor", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.oldCursor) }
                .function("type", returns(FnDragType.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
        }
    }
}
