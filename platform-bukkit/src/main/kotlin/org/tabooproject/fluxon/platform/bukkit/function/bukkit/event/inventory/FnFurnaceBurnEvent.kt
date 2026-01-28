package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.FurnaceBurnEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.inventory.FurnaceBurnEvent"])
@PlatformSide(Platform.BUKKIT)
object FnFurnaceBurnEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceBurnEvent::class.java)
                .function("fuel", returnsObject().noParams()) { it.setReturnRef(it.target?.fuel) }
                .function("burnTime", returnsObject().noParams()) { it.setReturnRef(it.target?.burnTime) }
                .function("setBurnTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBurnTime(it.getInt(0).toInt())) }
                .function("isBurning", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isBurning) }
                .function("setBurning", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBurning(it.getBool(0))) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelled(it.getBool(0))) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(FurnaceBurnEvent.getHandlerList()) }
        }
    }
}
