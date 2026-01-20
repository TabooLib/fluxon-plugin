package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.weather

import org.bukkit.event.weather.ThunderChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnThunderChangeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ThunderChangeEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("toThunderState", 0) { it.target?.toThunderState() }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { ThunderChangeEvent.getHandlerList() }
        }
    }
}
