package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.SmithItemEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnSmithingInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.SmithItemEvent"])
@PlatformSide(Platform.BUKKIT)
object FnSmithItemEvent {

    val TYPE = Type.fromClass(SmithItemEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SmithItemEvent::class.java)
                .function("inventory", returns(FnSmithingInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
