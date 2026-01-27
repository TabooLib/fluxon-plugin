package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.BrewingStand
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.BrewingStand"])
@PlatformSide(Platform.BUKKIT)
object FnBrewingStand {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewingStand::class.java)
                .function("brewingTime", 0) { it.target?.brewingTime }
                .function("setBrewingTime", 1) { it.target?.setBrewingTime(it.getNumber(0).toInt()) }
                .function("fuelLevel", 0) { it.target?.fuelLevel }
                .function("setFuelLevel", 1) { it.target?.setFuelLevel(it.getNumber(0).toInt()) }
                .function("inventory", 0) { it.target?.inventory }
                .function("snapshotInventory", 0) { it.target?.snapshotInventory }
        }
    }
}
