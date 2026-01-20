package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.block.data.BlockData
import org.bukkit.entity.BlockDisplay
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBlockDisplay {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDisplay::class.java)
                .function("block", 0) { it.target?.block }
                .function("setBlock", 1) { it.target?.setBlock(it.getArgument(0) as BlockData) }
        }
    }
}
