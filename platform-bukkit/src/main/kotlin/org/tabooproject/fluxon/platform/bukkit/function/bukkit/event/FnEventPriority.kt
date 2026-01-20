package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event

import org.bukkit.event.EventPriority
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEventPriority {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EventPriority::class.java)
                .function("slot", 0) { it.target?.slot }
        }
    }
}
