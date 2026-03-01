package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.vehicle

import org.bukkit.event.vehicle.VehicleEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.vehicle.VehicleEvent"])
@PlatformSide(Platform.BUKKIT)
object FnVehicleEvent {

    val TYPE = Type.fromClass(VehicleEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VehicleEvent::class.java)
                .function("vehicle",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnVehicle.TYPE).noParams()) { it.setReturnRef(it.target?.getVehicle()) }
        }
    }
}
