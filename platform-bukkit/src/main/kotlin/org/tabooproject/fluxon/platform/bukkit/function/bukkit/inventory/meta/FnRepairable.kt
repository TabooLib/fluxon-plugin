package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.Repairable
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

@Requires(classes = ["org.bukkit.inventory.meta.Repairable"])
@PlatformSide(Platform.BUKKIT)
object FnRepairable {

    val TYPE = Type.fromClass(Repairable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Repairable::class.java)
                .function("hasRepairCost", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasRepairCost() ?: false) }
                .function("repairCost", returns(Type.I).noParams()) { it.setReturnInt(it.target?.repairCost ?: 0) }
                .function("setRepairCost", returnsVoid().params(Type.I)) { it.target?.setRepairCost(it.getInt(0)) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
