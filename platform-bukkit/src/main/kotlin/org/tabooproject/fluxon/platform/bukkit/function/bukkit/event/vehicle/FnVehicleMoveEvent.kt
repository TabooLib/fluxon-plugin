package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.vehicle

import org.bukkit.event.vehicle.VehicleMoveEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.vehicle.VehicleMoveEvent"])
@PlatformSide(Platform.BUKKIT)
object FnVehicleMoveEvent {

    val TYPE = Type.fromClass(VehicleMoveEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VehicleMoveEvent::class.java)
                .function("from", returnsObject().noParams()) { it.setReturnRef(it.target?.from) }
                .function("to", returnsObject().noParams()) { it.setReturnRef(it.target?.to) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(VehicleMoveEvent.getHandlerList()) }
        }
    }
}
