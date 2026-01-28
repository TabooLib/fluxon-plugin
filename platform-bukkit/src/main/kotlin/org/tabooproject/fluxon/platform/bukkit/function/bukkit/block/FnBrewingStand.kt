package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.BrewingStand
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.BrewingStand"])
@PlatformSide(Platform.BUKKIT)
object FnBrewingStand {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewingStand::class.java)
                .function("brewingTime", returnsObject().noParams()) { it.setReturnRef(it.target?.brewingTime) }
                .function("setBrewingTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBrewingTime(it.getInt(0).toInt())) }
                .function("fuelLevel", returnsObject().noParams()) { it.setReturnRef(it.target?.fuelLevel) }
                .function("setFuelLevel", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFuelLevel(it.getInt(0).toInt())) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("snapshotInventory", returnsObject().noParams()) { it.setReturnRef(it.target?.snapshotInventory) }
        }
    }
}
