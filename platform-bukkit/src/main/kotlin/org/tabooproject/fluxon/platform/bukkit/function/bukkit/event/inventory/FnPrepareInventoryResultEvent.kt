package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.PrepareInventoryResultEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.inventory.PrepareInventoryResultEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPrepareInventoryResultEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareInventoryResultEvent::class.java)
                .function("result", returnsObject().noParams()) { it.setReturnRef(it.target?.result) }
                .function("setResult", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setResult(it.getRef(0) as ItemStack)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PrepareInventoryResultEvent.getHandlerList()) }
        }
    }
}
