package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.PressureSensor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.PressureSensor"])
@PlatformSide(Platform.BUKKIT)
object FnPressureSensor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PressureSensor::class.java)
                .function("isPressed", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isPressed) }
        }
    }
}
