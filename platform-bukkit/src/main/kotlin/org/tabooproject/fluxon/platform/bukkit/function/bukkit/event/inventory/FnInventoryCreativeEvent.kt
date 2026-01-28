package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryCreativeEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.inventory.InventoryCreativeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryCreativeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryCreativeEvent::class.java)
                .function("cursor", returnsObject().noParams()) { it.target?.cursor }
                .function("setCursor", returnsObject().params(Type.OBJECT)) { it.target?.setCursor(it.getRef(0) as ItemStack) }
        }
    }
}
