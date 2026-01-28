package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.inventory.InventoryEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryEvent::class.java)
                .function("inventory", returnsObject().noParams()) { it.target?.inventory }
                .function("viewers", returnsObject().noParams()) { it.target?.viewers }
                .function("view", returnsObject().noParams()) { it.target?.view }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { InventoryEvent.getHandlerList() }
        }
    }
}
