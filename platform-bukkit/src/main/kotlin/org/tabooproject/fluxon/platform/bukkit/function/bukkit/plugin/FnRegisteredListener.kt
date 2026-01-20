package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.event.Event
import org.bukkit.plugin.RegisteredListener
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnRegisteredListener {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RegisteredListener::class.java)
                .function("listener", 0) { it.target?.listener }
                .function("plugin", 0) { it.target?.plugin }
                .function("priority", 0) { it.target?.priority }
                .function("callEvent", 1) { it.target?.callEvent(it.getArgument(0) as Event) }
                .function("isIgnoringCancelled", 0) { it.target?.isIgnoringCancelled }
        }
    }
}
