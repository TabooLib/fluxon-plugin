package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockDropItemEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockDropItemEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockDropItemEvent {

    val TYPE = Type.fromClass(BlockDropItemEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDropItemEvent::class.java)
                .function("player", returns(FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("blockState", returns(FnBlockState.TYPE).noParams()) { it.setReturnRef(it.target?.blockState) }
                .function("items", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.items) }
        }
    }
}
