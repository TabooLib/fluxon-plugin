package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryCreativeEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.InventoryCreativeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryCreativeEvent {

    val TYPE = Type.fromClass(InventoryCreativeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryCreativeEvent::class.java)
                .function("cursor", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.cursor) }
                .function("setCursor", returnsVoid().params(FnItemStack.TYPE)) { it.target?.setCursor(it.getRef(0) as ItemStack) }
        }
    }
}
