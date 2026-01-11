package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.block.BlockState
import org.bukkit.generator.LimitedRegion
import org.bukkit.util.BlockTransformer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlockTransformer {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockTransformer::class.java)
                .function("transform", 6) {
                    it.target?.transform(
                        it.getArgument(0) as LimitedRegion,
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt(),
                        it.getArgument(4) as BlockState,
                        it.getArgument(5) as BlockTransformer.TransformationState
                    )
                }

            registerExtension(BlockTransformer.TransformationState::class.java)
                .function("original", 0) { it.target?.original }
                .function("world", 0) { it.target?.world }
        }
    }
}
