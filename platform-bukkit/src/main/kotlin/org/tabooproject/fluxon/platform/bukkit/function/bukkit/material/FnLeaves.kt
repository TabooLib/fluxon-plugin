package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Leaves
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLeaves {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Leaves::class.java)
                .function("isDecaying", 0) { it.target?.isDecaying }
                .function("setDecaying", 1) { it.target?.setDecaying(it.getBoolean(0)) }
                .function("isDecayable", 0) { it.target?.isDecayable }
                .function("setDecayable", 1) { it.target?.setDecayable(it.getBoolean(0)) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
