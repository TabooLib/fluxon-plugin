package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.event.Event
import org.bukkit.event.Listener
import org.bukkit.plugin.EventExecutor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEventExecutor {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EventExecutor::class.java)
                .function("execute", 2) {
                    it.target?.execute(
                        it.getArgument(0) as Listener,
                        it.getArgument(1) as Event
                    )
                }
        }
    }
}
