package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.SlimeSplitEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSlimeSplitEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SlimeSplitEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("entity", 0) { it.target?.getEntity() }
                .function("count", 0) { it.target?.count }
                .function("setCount", 1) { it.target?.setCount(it.getNumber(0).toInt()) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { SlimeSplitEvent.getHandlerList() }
        }
    }
}
