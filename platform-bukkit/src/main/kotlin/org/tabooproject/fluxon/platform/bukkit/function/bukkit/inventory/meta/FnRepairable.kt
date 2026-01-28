package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.Repairable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.Repairable"])
@PlatformSide(Platform.BUKKIT)
object FnRepairable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Repairable::class.java)
                .function("hasRepairCost", returns(Type.Z).noParams()) { it.target?.hasRepairCost() }
                .function("repairCost", returnsObject().noParams()) { it.target?.repairCost }
                .function("setRepairCost", returnsObject().params(Type.OBJECT)) { it.target?.setRepairCost(it.getInt(0).toInt()) }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
