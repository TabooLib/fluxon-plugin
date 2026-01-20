package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.hanging

import org.bukkit.event.hanging.HangingBreakByEntityEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnHangingBreakByEntityEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HangingBreakByEntityEvent::class.java)
                .function("remover", 0) { it.target?.remover }
        }
    }
}
