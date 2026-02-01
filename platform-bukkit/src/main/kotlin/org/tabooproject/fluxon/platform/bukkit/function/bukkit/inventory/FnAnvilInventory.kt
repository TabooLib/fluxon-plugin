package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.AnvilInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.AnvilInventory"])
@PlatformSide(Platform.BUKKIT)
object FnAnvilInventory {

    val TYPE = Type.fromClass(AnvilInventory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AnvilInventory::class.java)
                .function("renameText", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.renameText) }
                .function("repairCostAmount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.repairCostAmount ?: 0) }
                .function("setRepairCostAmount", returnsVoid().params(Type.I)) { it.target?.setRepairCostAmount(it.getInt(0).toInt()) }
                .function("repairCost", returns(Type.I).noParams()) { it.setReturnInt(it.target?.repairCost ?: 0) }
                .function("setRepairCost", returnsVoid().params(Type.I)) { it.target?.setRepairCost(it.getInt(0).toInt()) }
                .function("maximumRepairCost", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumRepairCost ?: 0) }
                .function("setMaximumRepairCost", returnsVoid().params(Type.I)) { it.target?.setMaximumRepairCost(it.getInt(0).toInt()) }
        }
    }
}
