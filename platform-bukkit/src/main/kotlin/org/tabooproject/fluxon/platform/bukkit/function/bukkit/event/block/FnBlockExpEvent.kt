package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockExpEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type


@Requires(classes = ["org.bukkit.event.block.BlockExpEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockExpEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockExpEvent::class.java)
                .function("expToDrop", returnsObject().noParams()) { it.setReturnRef(it.target?.expToDrop) }
                .function("setExpToDrop", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setExpToDrop(it.getInt(0).toInt())) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(BlockExpEvent.getHandlerList()) }
        }
    }
}
