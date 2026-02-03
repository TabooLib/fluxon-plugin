package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.FurnaceBurnEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.FurnaceBurnEvent"])
@PlatformSide(Platform.BUKKIT)
object FnFurnaceBurnEvent {

    val TYPE = Type.fromClass(FurnaceBurnEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceBurnEvent::class.java)
                .function("fuel", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.fuel) }
                .function("burnTime", returns(Type.I).noParams()) { it.setReturnRef(it.target?.burnTime) }
                .function("setBurnTime", returnsVoid().params(Type.I)) { it.target?.setBurnTime(it.getInt(0).toInt()) }
                .function("isBurning", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBurning ?: false) }
                .function("setBurning", returnsVoid().params(Type.Z)) { it.target?.setBurning(it.getBool(0)) }
        }
    }
}
