package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.HopperInventorySearchEvent
import org.bukkit.inventory.Inventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.inventory.HopperInventorySearchEvent"])
@PlatformSide(Platform.BUKKIT)
object FnHopperInventorySearchEvent {

    val TYPE = Type.fromClass(HopperInventorySearchEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HopperInventorySearchEvent::class.java)
                .function("setInventory", returnsVoid().params(Type.OBJECT)) { it.target?.setInventory(it.getRef(0) as Inventory) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("containerType", returnsObject().noParams()) { it.setReturnRef(it.target?.containerType) }
                .function("searchBlock", returnsObject().noParams()) { it.setReturnRef(it.target?.searchBlock) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(HopperInventorySearchEvent.getHandlerList()) }
        }
    }
}
