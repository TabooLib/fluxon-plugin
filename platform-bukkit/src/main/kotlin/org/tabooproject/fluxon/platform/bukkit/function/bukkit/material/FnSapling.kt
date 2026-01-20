package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Sapling
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSapling {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sapling::class.java)
                .function("isInstantGrowable", 0) { it.target?.isInstantGrowable }
                .function("setIsInstantGrowable", 1) { it.target?.setIsInstantGrowable(it.getBoolean(0)) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
