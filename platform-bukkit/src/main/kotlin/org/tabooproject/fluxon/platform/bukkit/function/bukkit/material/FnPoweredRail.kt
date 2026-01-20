package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.PoweredRail
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPoweredRail {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PoweredRail::class.java)
                .function("isPowered", 0) { it.target?.isPowered }
                .function("setPowered", 1) { it.target?.setPowered(it.getBoolean(0)) }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
