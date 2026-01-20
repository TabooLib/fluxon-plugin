package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.DecoratedPotInventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnDecoratedPotInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DecoratedPotInventory::class.java)
                .function("setItem", 1) { it.target?.setItem(it.getArgument(0) as ItemStack) }
                .function("item", 0) { it.target?.item }
                .function("holder", 0) { it.target?.holder }
        }
    }
}
