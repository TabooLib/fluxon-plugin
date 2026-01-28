package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.block.BlockState
import org.bukkit.inventory.meta.BlockStateMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.BlockStateMeta"])
@PlatformSide(Platform.BUKKIT)
object FnBlockStateMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockStateMeta::class.java)
                .function("hasBlockState", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasBlockState()) }
                .function("blockState", returnsObject().noParams()) { it.setReturnRef(it.target?.blockState) }
                .function("setBlockState", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBlockState(it.getRef(0) as BlockState)) }
        }
    }
}
