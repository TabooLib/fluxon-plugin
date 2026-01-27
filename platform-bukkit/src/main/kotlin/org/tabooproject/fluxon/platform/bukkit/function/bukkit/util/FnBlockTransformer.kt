package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.block.BlockState
import org.bukkit.generator.LimitedRegion
import org.bukkit.util.BlockTransformer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.util.BlockTransformer"])
@PlatformSide(Platform.BUKKIT)
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
        }
    }
}

@Requires(classes = ["org.bukkit.util.BlockTransformer.TransformationState"])
@PlatformSide(Platform.BUKKIT)
object FnBlockTransformerTransformationState {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockTransformer.TransformationState::class.java)
                .function("original", 0) { it.target?.original }
                .function("world", 0) { it.target?.world }
        }
    }
}
