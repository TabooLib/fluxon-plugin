package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockRedstoneEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.block.BlockRedstoneEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockRedstoneEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockRedstoneEvent::class.java)
                .function("oldCurrent", returnsObject().noParams()) { it.target?.oldCurrent }
                .function("newCurrent", returnsObject().noParams()) { it.target?.newCurrent }
                .function("setNewCurrent", returnsObject().params(Type.OBJECT)) { it.target?.setNewCurrent(it.getInt(0).toInt()) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { BlockRedstoneEvent.getHandlerList() }
        }
    }
}
