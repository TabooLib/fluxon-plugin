package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.BrewingStand
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnBrewerInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.BrewingStand"])
@PlatformSide(Platform.BUKKIT)
object FnBrewingStand {

    val TYPE = Type.fromClass(BrewingStand::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewingStand::class.java)
                .function("brewingTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.brewingTime ?: 0) }
                .function("setBrewingTime", returnsVoid().params(Type.I)) { it.target?.setBrewingTime(it.getInt(0).toInt()) }
                .function("fuelLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.fuelLevel ?: 0) }
                .function("setFuelLevel", returnsVoid().params(Type.I)) { it.target?.setFuelLevel(it.getInt(0).toInt()) }
                .function("inventory", returns(FnBrewerInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("snapshotInventory", returns(FnBrewerInventory.TYPE).noParams()) { it.setReturnRef(it.target?.snapshotInventory) }
        }
    }
}
