package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.NetherWartsState
import org.bukkit.material.NetherWarts
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnNetherWarts {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NetherWarts::class.java)
                .function("state", 0) { it.target?.state }
                .function("setState", 1) { it.target?.setState(it.getArgument(0) as NetherWartsState) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
