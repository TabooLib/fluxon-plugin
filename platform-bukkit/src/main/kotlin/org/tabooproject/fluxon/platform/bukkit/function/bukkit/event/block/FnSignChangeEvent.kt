package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.SignChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.block.SignChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnSignChangeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SignChangeEvent::class.java)
                .function("player", 0) { it.target?.player }
                .function("lines", 0) { it.target?.lines }
                .function("getLine", 1) { it.target?.getLine(it.getNumber(0).toInt()) }
                .function("setLine", 2) { it.target?.setLine(it.getNumber(0).toInt(), it.getString(1)) }
                .function("side", 0) { it.target?.side }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { SignChangeEvent.getHandlerList() }
        }
    }
}
