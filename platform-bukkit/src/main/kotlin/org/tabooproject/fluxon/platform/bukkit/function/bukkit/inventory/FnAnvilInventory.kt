package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.AnvilInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAnvilInventory {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AnvilInventory::class.java)
                .function("renameText", 0) { it.target?.renameText }
                .function("repairCostAmount", 0) { it.target?.repairCostAmount }
                .function("setRepairCostAmount", 1) { it.target?.setRepairCostAmount(it.getNumber(0).toInt()) }
                .function("repairCost", 0) { it.target?.repairCost }
                .function("setRepairCost", 1) { it.target?.setRepairCost(it.getNumber(0).toInt()) }
                .function("maximumRepairCost", 0) { it.target?.maximumRepairCost }
                .function("setMaximumRepairCost", 1) { it.target?.setMaximumRepairCost(it.getNumber(0).toInt()) }
        }
    }
}
