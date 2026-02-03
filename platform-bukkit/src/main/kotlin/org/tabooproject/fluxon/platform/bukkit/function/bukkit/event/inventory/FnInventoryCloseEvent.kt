package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryCloseEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHumanEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.InventoryCloseEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryCloseEvent {

    val TYPE = Type.fromClass(InventoryCloseEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryCloseEvent::class.java)
                .function("player", returns(FnHumanEntity.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
        }
    }
}
