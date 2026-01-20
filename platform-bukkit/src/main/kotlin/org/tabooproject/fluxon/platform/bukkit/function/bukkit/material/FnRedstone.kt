package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Redstone
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnRedstone {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Redstone::class.java)
                .function("isPowered", 0) { it.target?.isPowered }
        }
    }
}
