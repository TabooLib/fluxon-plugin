package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.PressurePlate
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPressurePlate {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PressurePlate::class.java)
                .function("isPressed", 0) { it.target?.isPressed }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
