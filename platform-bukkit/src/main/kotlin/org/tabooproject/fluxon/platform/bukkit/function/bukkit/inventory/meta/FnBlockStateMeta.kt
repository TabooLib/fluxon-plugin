package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.block.BlockState
import org.bukkit.inventory.meta.BlockStateMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.BlockStateMeta"])
@PlatformSide(Platform.BUKKIT)
object FnBlockStateMeta {

    val TYPE = Type.fromClass(BlockStateMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockStateMeta::class.java)
                .function("hasBlockState", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasBlockState() ?: false) }
                .function("blockState", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState.TYPE).noParams()) { it.setReturnRef(it.target?.blockState) }
                .function("setBlockState",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState.TYPE)) { it.target?.setBlockState(it.getRef(0) as BlockState) }
        }
    }
}
