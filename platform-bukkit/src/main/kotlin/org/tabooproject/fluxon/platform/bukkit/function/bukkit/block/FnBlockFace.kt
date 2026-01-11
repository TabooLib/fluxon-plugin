package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.BlockFace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlockFace {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockFace::class.java)
                .function("modX", 0) { it.target?.modX }
                .function("modY", 0) { it.target?.modY }
                .function("modZ", 0) { it.target?.modZ }
                .function("direction", 0) { it.target?.direction }
                .function("isCartesian", 0) { it.target?.isCartesian }
                .function("oppositeFace", 0) { it.target?.oppositeFace }
        }
    }
}
