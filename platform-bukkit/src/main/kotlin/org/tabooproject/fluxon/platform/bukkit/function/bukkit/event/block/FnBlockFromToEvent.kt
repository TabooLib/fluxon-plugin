package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockFromToEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockFromToEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockFromToEvent {

    val TYPE = Type.fromClass(BlockFromToEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockFromToEvent::class.java)
                .function("face", returns(FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.getFace()) }
                .function("toBlock", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.toBlock) }
        }
    }
}
