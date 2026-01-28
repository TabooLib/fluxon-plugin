package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryMoveItemEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.inventory.InventoryMoveItemEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryMoveItemEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryMoveItemEvent::class.java)
                .function("source", returnsObject().noParams()) { it.target?.source }
                .function("item", returnsObject().noParams()) { it.target?.item }
                .function("setItem", returnsObject().params(Type.OBJECT)) { it.target?.setItem(it.getRef(0) as ItemStack) }
                .function("destination", returnsObject().noParams()) { it.target?.destination }
                .function("initiator", returnsObject().noParams()) { it.target?.initiator }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { InventoryMoveItemEvent.getHandlerList() }
        }
    }
}
