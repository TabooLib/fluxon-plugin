package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.RedstoneTorch
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnRedstoneTorch {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RedstoneTorch::class.java)
                .function("isPowered", 0) { it.target?.isPowered }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
