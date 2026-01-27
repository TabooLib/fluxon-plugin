package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.CraftingInventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.inventory.CraftingInventory"])
@PlatformSide(Platform.BUKKIT)
object FnCraftingInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CraftingInventory::class.java)
                .function("result", 0) { it.target?.result }
                .function("matrix", 0) { it.target?.matrix }
                .function("setResult", 1) { it.target?.setResult(it.getArgument(0) as ItemStack) }
                .function("setMatrix", 1) { it.target?.setMatrix(it.getArgument(0) as Array<ItemStack>) }
                .function("recipe", 0) { it.target?.recipe }
        }
    }
}
