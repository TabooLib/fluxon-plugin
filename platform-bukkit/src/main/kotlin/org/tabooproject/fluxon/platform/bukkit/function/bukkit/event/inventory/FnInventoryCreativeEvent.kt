package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryCreativeEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnInventoryCreativeEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryCreativeEvent::class.java)
                .function("cursor", 0) { it.target?.cursor }
                .function("setCursor", 1) { it.target?.setCursor(it.getArgument(0) as ItemStack) }
        }
    }
}
