package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.vehicle

import org.bukkit.event.vehicle.VehicleBlockCollisionEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.vehicle.VehicleBlockCollisionEvent"])
@PlatformSide(Platform.BUKKIT)
object FnVehicleBlockCollisionEvent {

    val TYPE = Type.fromClass(VehicleBlockCollisionEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VehicleBlockCollisionEvent::class.java)
                .function("block", returnsObject().noParams()) { it.setReturnRef(it.target?.block) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(VehicleBlockCollisionEvent.getHandlerList()) }
        }
    }
}
