package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.FurnaceBurnEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.inventory.FurnaceBurnEvent"])
@PlatformSide(Platform.BUKKIT)
object FnFurnaceBurnEvent {

    val TYPE = Type.fromClass(FurnaceBurnEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceBurnEvent::class.java)
                .function("fuel", returnsObject().noParams()) { it.setReturnRef(it.target?.fuel) }
                .function("burnTime", returnsObject().noParams()) { it.setReturnRef(it.target?.burnTime) }
                .function("setBurnTime", returnsVoid().params(Type.I)) { it.target?.setBurnTime(it.getInt(0).toInt()) }
                .function("isBurning", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBurning ?: false) }
                .function("setBurning", returnsVoid().params(Type.Z)) { it.target?.setBurning(it.getBool(0)) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(FurnaceBurnEvent.getHandlerList()) }
        }
    }
}
