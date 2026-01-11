package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.BlockFace
import org.bukkit.block.data.MultipleFacing
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMultipleFacing {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MultipleFacing::class.java)
                .function("hasFace", 1) { it.target?.hasFace(it.getArgument(0) as BlockFace) }
                .function("setFace", 2) { it.target?.setFace(it.getArgument(0) as BlockFace, it.getBoolean(1)) }
                .function("faces", 0) { it.target?.faces }
                .function("allowedFaces", 0) { it.target?.allowedFaces }
        }
    }
}
