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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.BlockTransformer"])
@PlatformSide(Platform.BUKKIT)
object FnBlockTransformer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockTransformer::class.java)
                .function("transform", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.transform(
                        it.getRef(0) as LimitedRegion,
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt(),
                        it.getRef(4) as BlockState,
                        it.getRef(5) as BlockTransformer.TransformationState
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
                .function("original", returnsObject().noParams()) { it.target?.original }
                .function("world", returnsObject().noParams()) { it.target?.world }
        }
    }
}
