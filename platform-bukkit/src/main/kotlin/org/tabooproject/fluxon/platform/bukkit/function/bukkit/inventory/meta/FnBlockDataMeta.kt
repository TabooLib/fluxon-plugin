package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.Material
import org.bukkit.block.data.BlockData
import org.bukkit.inventory.meta.BlockDataMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBlockDataMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDataMeta::class.java)
                .function("hasBlockData", 0) { it.target?.hasBlockData() }
                .function("blockData", 1) { it.target?.getBlockData(it.getArgument(0) as Material) }
                .function("setBlockData", 1) { it.target?.setBlockData(it.getArgument(0) as BlockData) }
        }
    }
}
