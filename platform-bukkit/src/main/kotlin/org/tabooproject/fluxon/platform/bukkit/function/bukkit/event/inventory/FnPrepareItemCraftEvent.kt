package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.inventory.PrepareItemCraftEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPrepareItemCraftEvent {

    val TYPE = Type.fromClass(PrepareItemCraftEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareItemCraftEvent::class.java)
                .function("recipe", returnsObject().noParams()) { it.setReturnRef(it.target?.recipe) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("isRepair", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRepair ?: false) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PrepareItemCraftEvent.getHandlerList()) }
        }
    }
}
