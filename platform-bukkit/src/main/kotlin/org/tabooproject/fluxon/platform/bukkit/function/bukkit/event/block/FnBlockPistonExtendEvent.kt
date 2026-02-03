package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockPistonExtendEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockPistonExtendEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockPistonExtendEvent {

    val TYPE = Type.fromClass(BlockPistonExtendEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPistonExtendEvent::class.java)
                .function("length", returns(Type.I).noParams()) { it.setReturnInt(it.target?.length ?: 0) }
                .function("blocks", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.blocks) }
        }
    }
}
