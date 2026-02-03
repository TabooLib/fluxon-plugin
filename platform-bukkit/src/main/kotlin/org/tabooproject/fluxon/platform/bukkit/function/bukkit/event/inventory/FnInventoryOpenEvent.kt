package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryOpenEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHumanEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.InventoryOpenEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryOpenEvent {

    val TYPE = Type.fromClass(InventoryOpenEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryOpenEvent::class.java)
                .function("player", returns(FnHumanEntity.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
        }
    }
}
