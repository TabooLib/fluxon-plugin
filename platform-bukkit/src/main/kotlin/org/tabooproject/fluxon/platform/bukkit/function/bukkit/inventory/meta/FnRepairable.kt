package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.Repairable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnRepairable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Repairable::class.java)
                .function("hasRepairCost", 0) { it.target?.hasRepairCost() }
                .function("repairCost", 0) { it.target?.repairCost }
                .function("setRepairCost", 1) { it.target?.setRepairCost(it.getNumber(0).toInt()) }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
