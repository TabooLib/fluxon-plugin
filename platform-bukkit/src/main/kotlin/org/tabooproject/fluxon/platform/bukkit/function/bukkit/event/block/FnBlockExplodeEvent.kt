package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockExplodeEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@Requires(classes = ["org.bukkit.event.block.BlockExplodeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockExplodeEvent {

    val TYPE = Type.fromClass(BlockExplodeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockExplodeEvent::class.java)
                .function("explodedBlockState", returns(FnBlockState.TYPE).noParams()) { it.setReturnRef(it.target?.explodedBlockState) }
                .function("blockList", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.blockList()) }
                .function("yield", returns(Type.F).noParams()) { it.setReturnRef(it.target?.yield) }
                .function("setYield", returnsVoid().params(Type.F)) { it.target?.setYield(it.getFloat(0)) }
        }
    }
}
