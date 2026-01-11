package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Gate
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnGate {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Gate::class.java)
                .function("isInWall", 0) { it.target?.isInWall }
                .function("setInWall", 1) { it.target?.setInWall(it.getBoolean(0)) }
        }
    }
}
