package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.TabCompleteEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnTabCompleteEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TabCompleteEvent::class.java)
                .function("sender", 0) { it.target?.sender }
                .function("buffer", 0) { it.target?.buffer }
                .function("completions", 0) { it.target?.completions }
                .function("setCompletions", 1) { it.target?.setCompletions(it.getArgument(0) as List<String>) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { TabCompleteEvent.getHandlerList() }
        }
    }
}
