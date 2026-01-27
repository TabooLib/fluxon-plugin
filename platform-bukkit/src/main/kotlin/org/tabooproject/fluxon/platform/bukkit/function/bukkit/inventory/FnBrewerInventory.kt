package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.BrewerInventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.inventory.BrewerInventory"])
@PlatformSide(Platform.BUKKIT)
object FnBrewerInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewerInventory::class.java)
                .function("ingredient", 0) { it.target?.ingredient }
                .function("setIngredient", 1) { it.target?.setIngredient(it.getArgument(0) as ItemStack) }
                .function("fuel", 0) { it.target?.fuel }
                .function("setFuel", 1) { it.target?.setFuel(it.getArgument(0) as ItemStack) }
                .function("holder", 0) { it.target?.holder }
        }
    }
}
