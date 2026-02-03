package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.InventoryBlockStartEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.InventoryBlockStartEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryBlockStartEvent {

    val TYPE = Type.fromClass(InventoryBlockStartEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryBlockStartEvent::class.java)
                .function("source", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.source) }
        }
    }
}
