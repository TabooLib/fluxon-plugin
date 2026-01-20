package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.block.BlockState
import org.bukkit.inventory.meta.BlockStateMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBlockStateMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockStateMeta::class.java)
                .function("hasBlockState", 0) { it.target?.hasBlockState() }
                .function("blockState", 0) { it.target?.blockState }
                .function("setBlockState", 1) { it.target?.setBlockState(it.getArgument(0) as BlockState) }
        }
    }
}
