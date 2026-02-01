package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.vehicle

import org.bukkit.event.vehicle.VehicleDamageEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.vehicle.VehicleDamageEvent"])
@PlatformSide(Platform.BUKKIT)
object FnVehicleDamageEvent {

    val TYPE = Type.fromClass(VehicleDamageEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VehicleDamageEvent::class.java)
                .function("attacker", returnsObject().noParams()) { it.setReturnRef(it.target?.attacker) }
                .function("damage", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.damage ?: 0.0) }
                .function("setDamage", returnsVoid().params(Type.D)) { it.target?.setDamage(it.getDouble(0)) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(VehicleDamageEvent.getHandlerList()) }
        }
    }
}
