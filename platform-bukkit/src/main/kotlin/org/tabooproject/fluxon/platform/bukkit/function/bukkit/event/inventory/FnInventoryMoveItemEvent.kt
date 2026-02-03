package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryMoveItemEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.InventoryMoveItemEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryMoveItemEvent {

    val TYPE = Type.fromClass(InventoryMoveItemEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryMoveItemEvent::class.java)
                .function("source", returns(FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.source) }
                .function("item", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.item) }
                .function("setItem", returnsVoid().params(FnItemStack.TYPE)) { it.target?.setItem(it.getRef(0) as ItemStack) }
                .function("destination", returns(FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.destination) }
                .function("initiator", returns(FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.initiator) }
        }
    }
}
