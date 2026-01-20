package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.BlockChangeDelegate
import org.bukkit.block.data.BlockData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBlockChangeDelegate {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockChangeDelegate::class.java)
                .function("setBlockData", 4) {
                    it.target?.setBlockData(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt(),
                        it.getArgument(3) as BlockData
                    )
                }
                .function("blockData", 3) {
                    it.target?.getBlockData(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("height", 0) { it.target?.height }
                .function("isEmpty", 3) {
                    it.target?.isEmpty(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
        }
    }
}
