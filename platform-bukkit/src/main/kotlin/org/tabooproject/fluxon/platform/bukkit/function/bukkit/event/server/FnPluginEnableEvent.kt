package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.PluginEnableEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPluginEnableEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginEnableEvent::class.java)
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PluginEnableEvent.getHandlerList() }
        }
    }
}
