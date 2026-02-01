package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockPistonRetractEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.block.BlockPistonRetractEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockPistonRetractEvent {

    val TYPE = Type.fromClass(BlockPistonRetractEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPistonRetractEvent::class.java)
                .function("retractLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.retractLocation) }
                .function("blocks", returnsObject().noParams()) { it.setReturnRef(it.target?.blocks) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(BlockPistonRetractEvent.getHandlerList()) }
        }
    }
}
