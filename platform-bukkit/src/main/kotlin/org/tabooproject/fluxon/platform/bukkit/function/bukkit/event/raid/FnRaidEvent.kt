package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.raid

import org.bukkit.event.raid.RaidEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnRaidEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RaidEvent::class.java)
                .function("raid", 0) { it.target?.raid }
        }
    }
}
