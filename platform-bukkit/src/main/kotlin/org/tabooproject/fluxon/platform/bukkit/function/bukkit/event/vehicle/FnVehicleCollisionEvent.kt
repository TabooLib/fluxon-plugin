package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.vehicle

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.vehicle.VehicleCollisionEvent"])
@PlatformSide(Platform.BUKKIT)
object FnVehicleCollisionEvent {

    val TYPE = Type.fromClass(org.bukkit.event.vehicle.VehicleCollisionEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.event.vehicle.VehicleCollisionEvent::class.java)
                // static getHandlerList
                .function("getHandlers", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.getHandlers()) }
        }
    }
}
