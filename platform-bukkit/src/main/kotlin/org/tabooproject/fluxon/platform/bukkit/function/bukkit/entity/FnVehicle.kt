package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Vehicle
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Vehicle"])
@PlatformSide(Platform.BUKKIT)
object FnVehicle {

    val TYPE = Type.fromClass(Vehicle::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vehicle::class.java)
                .function("velocity", returnsObject().noParams()) { it.setReturnRef(it.target?.velocity) }
                .function("setVelocity", returnsVoid().params(Type.OBJECT)) { it.target?.setVelocity(it.getRef(0) as Vector) }
        }
    }
}
