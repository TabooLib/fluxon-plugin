package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.GenericGameEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnGenericGameEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GenericGameEvent::class.java)
                .function("event", 0) { it.target?.event }
                .function("location", 0) { it.target?.location }
                .function("entity", 0) { it.target?.entity }
                .function("radius", 0) { it.target?.radius }
                .function("setRadius", 1) { it.target?.setRadius(it.getNumber(0).toInt()) }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { GenericGameEvent.getHandlerList() }
        }
    }
}
