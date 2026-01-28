package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.BrewingStandFuelEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.inventory.BrewingStandFuelEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBrewingStandFuelEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewingStandFuelEvent::class.java)
                .function("fuel", returnsObject().noParams()) { it.target?.fuel }
                .function("fuelPower", returnsObject().noParams()) { it.target?.fuelPower }
                .function("setFuelPower", returnsObject().params(Type.OBJECT)) { it.target?.setFuelPower(it.getInt(0).toInt()) }
                .function("isConsuming", returns(Type.Z).noParams()) { it.target?.isConsuming }
                .function("setConsuming", returnsObject().params(Type.OBJECT)) { it.target?.setConsuming(it.getBool(0)) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { BrewingStandFuelEvent.getHandlerList() }
        }
    }
}
