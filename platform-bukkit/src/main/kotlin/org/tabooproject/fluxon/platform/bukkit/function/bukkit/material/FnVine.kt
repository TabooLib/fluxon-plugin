package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Vine
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnVine {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vine::class.java)
                .function("isOnFace", 1) { it.target?.isOnFace(it.getArgument(0) as BlockFace) }
                .function("putOnFace", 1) { it.target?.putOnFace(it.getArgument(0) as BlockFace) }
                .function("removeFromFace", 1) { it.target?.removeFromFace(it.getArgument(0) as BlockFace) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
