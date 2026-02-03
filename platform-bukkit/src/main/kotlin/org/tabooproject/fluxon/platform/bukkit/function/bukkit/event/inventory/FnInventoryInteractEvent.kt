package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.Event
import org.bukkit.event.inventory.InventoryInteractEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHumanEntity
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnEventResult
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.InventoryInteractEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryInteractEvent {

    val TYPE = Type.fromClass(InventoryInteractEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryInteractEvent::class.java)
                .function("whoClicked", returns(FnHumanEntity.TYPE).noParams()) { it.setReturnRef(it.target?.whoClicked) }
                .function("setResult", returnsVoid().params(FnEventResult.TYPE)) { it.target?.setResult(it.getRef(0) as Event.Result) }
        }
    }
}
