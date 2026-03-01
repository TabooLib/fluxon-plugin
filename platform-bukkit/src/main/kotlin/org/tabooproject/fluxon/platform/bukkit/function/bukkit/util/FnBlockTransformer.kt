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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.BlockTransformer"])
@PlatformSide(Platform.BUKKIT)
object FnBlockTransformer {

    val TYPE = Type.fromClass(BlockTransformer::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockTransformer::class.java)
                .function("transform",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnLimitedRegion.TYPE, Type.I, Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBlockTransformerTransformationState.TYPE)) {
                    it.setReturnRef(it.target?.transform(
                        it.getRef(0) as LimitedRegion,
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt(),
                        it.getRef(4) as BlockState,
                        it.getRef(5) as BlockTransformer.TransformationState
                    ))
                }
        }
    }
}

@Requires(classes = ["org.bukkit.util.BlockTransformer\$TransformationState"])
@PlatformSide(Platform.BUKKIT)
object FnBlockTransformerTransformationState {

    val TYPE = Type.fromClass(BlockTransformer.TransformationState::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockTransformer.TransformationState::class.java)
                .function("original", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState.TYPE).noParams()) { it.setReturnRef(it.target?.original) }
                .function("world", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE).noParams()) { it.setReturnRef(it.target?.world) }
        }
    }
}
