package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.vehicle

import org.bukkit.event.vehicle.VehicleEntityCollisionEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.vehicle.VehicleEntityCollisionEvent"])
@PlatformSide(Platform.BUKKIT)
object FnVehicleEntityCollisionEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VehicleEntityCollisionEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.target?.entity }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("isPickupCancelled", returns(Type.Z).noParams()) { it.target?.isPickupCancelled }
                .function("setPickupCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setPickupCancelled(it.getBool(0)) }
                .function("isCollisionCancelled", returns(Type.Z).noParams()) { it.target?.isCollisionCancelled }
                .function("setCollisionCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCollisionCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { VehicleEntityCollisionEvent.getHandlerList() }
        }
    }
}
