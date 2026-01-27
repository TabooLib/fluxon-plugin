package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.weather

import org.bukkit.event.weather.LightningStrikeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.weather.LightningStrikeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnLightningStrikeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LightningStrikeEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("lightning", 0) { it.target?.lightning }
                .function("cause", 0) { it.target?.cause }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { LightningStrikeEvent.getHandlerList() }
        }
    }
}
