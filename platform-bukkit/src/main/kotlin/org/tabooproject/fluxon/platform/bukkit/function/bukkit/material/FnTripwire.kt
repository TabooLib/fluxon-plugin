package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Tripwire
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnTripwire {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tripwire::class.java)
                .function("isActivated", 0) { it.target?.isActivated }
                .function("setActivated", 1) { it.target?.setActivated(it.getBoolean(0)) }
                .function("isObjectTriggering", 0) { it.target?.isObjectTriggering }
                .function("setObjectTriggering", 1) { it.target?.setObjectTriggering(it.getBoolean(0)) }
                .function("clone", 0) { it.target?.clone() }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
