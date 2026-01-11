package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.event.Event
import org.bukkit.plugin.TimedRegisteredListener
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnTimedRegisteredListener {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TimedRegisteredListener::class.java)
                .function("callEvent", 1) { it.target?.callEvent(it.getArgument(0) as Event) }
                .function("reset", 0) { it.target?.reset() }
                .function("count", 0) { it.target?.count }
                .function("totalTime", 0) { it.target?.totalTime }
                .function("hasMultiple", 0) { it.target?.hasMultiple() }
        }
    }
}
