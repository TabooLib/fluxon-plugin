package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryView
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.InventoryEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryEvent {

    val TYPE = Type.fromClass(InventoryEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryEvent::class.java)
                .function("inventory", returns(FnInventoryView.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("viewers", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.viewers) }
                .function("view", returns(FnInventoryView.TYPE).noParams()) { it.setReturnRef(it.target?.view) }
        }
    }
}
