package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryPickupItemEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnItem
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.InventoryPickupItemEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryPickupItemEvent {

    val TYPE = Type.fromClass(InventoryPickupItemEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryPickupItemEvent::class.java)
                .function("inventory", returns(FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("item", returns(FnItem.TYPE).noParams()) { it.setReturnRef(it.target?.item) }
        }
    }
}
