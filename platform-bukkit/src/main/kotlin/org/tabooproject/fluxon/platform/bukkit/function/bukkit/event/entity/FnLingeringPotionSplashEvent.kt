package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.LingeringPotionSplashEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLingeringPotionSplashEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LingeringPotionSplashEvent::class.java)
                .function("entity", 0) { it.target?.entity }
                .function("areaEffectCloud", 0) { it.target?.areaEffectCloud }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { LingeringPotionSplashEvent.getHandlerList() }
        }
    }
}
