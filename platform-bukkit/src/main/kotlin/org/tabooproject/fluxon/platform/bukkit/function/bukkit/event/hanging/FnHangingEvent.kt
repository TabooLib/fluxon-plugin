package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.hanging

import org.bukkit.event.hanging.HangingEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.hanging.HangingEvent"])
@PlatformSide(Platform.BUKKIT)
object FnHangingEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HangingEvent::class.java)
                .function("entity", 0) { it.target?.entity }
        }
    }
}
