package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.BrewEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnBrewerInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.BrewEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBrewEvent {

    val TYPE = Type.fromClass(BrewEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewEvent::class.java)
                .function("contents", returns(FnBrewerInventory.TYPE).noParams()) { it.setReturnRef(it.target?.contents) }
                .function("fuelLevel", returns(Type.I).noParams()) { it.setReturnRef(it.target?.fuelLevel) }
                .function("results", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.results) }
        }
    }
}
