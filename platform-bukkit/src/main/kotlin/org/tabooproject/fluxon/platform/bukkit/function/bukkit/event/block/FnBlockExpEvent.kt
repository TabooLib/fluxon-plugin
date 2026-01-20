package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockExpEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnBlockExpEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockExpEvent::class.java)
                .function("expToDrop", 0) { it.target?.expToDrop }
                .function("setExpToDrop", 1) { it.target?.setExpToDrop(it.getNumber(0).toInt()) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BlockExpEvent.getHandlerList() }
        }
    }
}
