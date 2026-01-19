package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.BlockFace
import org.bukkit.block.data.Rotatable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnRotatable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rotatable::class.java)
                .function("rotation", 0) { it.target?.rotation }
                .function("setRotation", 1) { it.target?.setRotation(it.getArgument(0) as BlockFace) }
        }
    }
}
