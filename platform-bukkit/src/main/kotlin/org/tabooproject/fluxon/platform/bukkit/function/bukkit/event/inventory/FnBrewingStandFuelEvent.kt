package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.BrewingStandFuelEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.inventory.BrewingStandFuelEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBrewingStandFuelEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewingStandFuelEvent::class.java)
                .function("fuel", 0) { it.target?.fuel }
                .function("fuelPower", 0) { it.target?.fuelPower }
                .function("setFuelPower", 1) { it.target?.setFuelPower(it.getNumber(0).toInt()) }
                .function("isConsuming", 0) { it.target?.isConsuming }
                .function("setConsuming", 1) { it.target?.setConsuming(it.getBoolean(0)) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BrewingStandFuelEvent.getHandlerList() }
        }
    }
}
