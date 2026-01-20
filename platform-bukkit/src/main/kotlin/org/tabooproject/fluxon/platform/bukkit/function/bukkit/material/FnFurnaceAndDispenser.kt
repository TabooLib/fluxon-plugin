package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.FurnaceAndDispenser
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnFurnaceAndDispenser {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceAndDispenser::class.java)
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
