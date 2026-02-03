package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.FurnaceStartSmeltEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.FurnaceStartSmeltEvent"])
@PlatformSide(Platform.BUKKIT)
object FnFurnaceStartSmeltEvent {

    val TYPE = Type.fromClass(FurnaceStartSmeltEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceStartSmeltEvent::class.java)
                .function("totalCookTime", returns(Type.I).noParams()) { it.setReturnRef(it.target?.totalCookTime) }
                .function("setTotalCookTime", returnsVoid().params(Type.I)) { it.target?.setTotalCookTime(it.getInt(0)) }
        }
    }
}
