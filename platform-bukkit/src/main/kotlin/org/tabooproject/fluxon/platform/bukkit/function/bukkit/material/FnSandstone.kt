package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.SandstoneType
import org.bukkit.material.Sandstone
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSandstone {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sandstone::class.java)
                .function("type", 0) { it.target?.type }
                .function("setType", 1) { it.target?.setType(it.getArgument(0) as SandstoneType) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
