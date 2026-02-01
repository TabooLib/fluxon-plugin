package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.InventoryBlockStartEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.block.InventoryBlockStartEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryBlockStartEvent {

    val TYPE = Type.fromClass(InventoryBlockStartEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryBlockStartEvent::class.java)
                .function("source", returnsObject().noParams()) { it.setReturnRef(it.target?.source) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(InventoryBlockStartEvent.getHandlerList()) }
        }
    }
}
