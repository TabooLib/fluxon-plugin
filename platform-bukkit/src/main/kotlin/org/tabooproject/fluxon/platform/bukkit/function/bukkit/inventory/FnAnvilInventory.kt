package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.AnvilInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.AnvilInventory"])
@PlatformSide(Platform.BUKKIT)
object FnAnvilInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AnvilInventory::class.java)
                .function("renameText", returnsObject().noParams()) { it.setReturnRef(it.target?.renameText) }
                .function("repairCostAmount", returnsObject().noParams()) { it.setReturnRef(it.target?.repairCostAmount) }
                .function("setRepairCostAmount", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRepairCostAmount(it.getInt(0).toInt())) }
                .function("repairCost", returnsObject().noParams()) { it.setReturnRef(it.target?.repairCost) }
                .function("setRepairCost", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRepairCost(it.getInt(0).toInt())) }
                .function("maximumRepairCost", returnsObject().noParams()) { it.setReturnRef(it.target?.maximumRepairCost) }
                .function("setMaximumRepairCost", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaximumRepairCost(it.getInt(0).toInt())) }
        }
    }
}
