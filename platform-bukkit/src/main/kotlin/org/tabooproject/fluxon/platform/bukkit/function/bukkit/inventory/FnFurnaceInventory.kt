package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.FurnaceInventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnFurnaceInventory {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceInventory::class.java)
                .function("result", 0) { it.target?.result }
                .function("fuel", 0) { it.target?.fuel }
                .function("smelting", 0) { it.target?.smelting }
                .function("setFuel", 1) { it.target?.setFuel(it.getArgument(0) as ItemStack) }
                .function("setResult", 1) { it.target?.setResult(it.getArgument(0) as ItemStack) }
                .function("setSmelting", 1) { it.target?.setSmelting(it.getArgument(0) as ItemStack) }
                .function("holder", 0) { it.target?.holder }
        }
    }
}
