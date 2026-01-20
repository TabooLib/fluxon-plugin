package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.PluginDisableEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPluginDisableEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginDisableEvent::class.java)
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PluginDisableEvent.getHandlerList() }
        }
    }
}
