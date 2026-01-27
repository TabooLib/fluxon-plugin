package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.raid

import org.bukkit.event.raid.RaidSpawnWaveEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.raid.RaidSpawnWaveEvent"])
@PlatformSide(Platform.BUKKIT)
object FnRaidSpawnWaveEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RaidSpawnWaveEvent::class.java)
                .function("patrolLeader", 0) { it.target?.patrolLeader }
                .function("raiders", 0) { it.target?.raiders }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { RaidSpawnWaveEvent.getHandlerList() }
        }
    }
}
