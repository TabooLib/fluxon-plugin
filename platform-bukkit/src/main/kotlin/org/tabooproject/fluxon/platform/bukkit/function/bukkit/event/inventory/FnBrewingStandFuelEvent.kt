package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.BrewingStandFuelEvent
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

@Requires(classes = ["org.bukkit.event.inventory.BrewingStandFuelEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBrewingStandFuelEvent {

    val TYPE = Type.fromClass(BrewingStandFuelEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewingStandFuelEvent::class.java)
                .function("fuel", returnsObject().noParams()) { it.setReturnRef(it.target?.fuel) }
                .function("fuelPower", returns(Type.I).noParams()) { it.setReturnInt(it.target?.fuelPower ?: 0) }
                .function("setFuelPower", returnsVoid().params(Type.I)) { it.target?.setFuelPower(it.getInt(0).toInt()) }
                .function("isConsuming", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isConsuming ?: false) }
                .function("setConsuming", returnsVoid().params(Type.Z)) { it.target?.setConsuming(it.getBool(0)) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(BrewingStandFuelEvent.getHandlerList()) }
        }
    }
}
