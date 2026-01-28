package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.raid

import org.bukkit.event.raid.RaidSpawnWaveEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.raid.RaidSpawnWaveEvent"])
@PlatformSide(Platform.BUKKIT)
object FnRaidSpawnWaveEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RaidSpawnWaveEvent::class.java)
                .function("patrolLeader", returnsObject().noParams()) { it.setReturnRef(it.target?.patrolLeader) }
                .function("raiders", returnsObject().noParams()) { it.setReturnRef(it.target?.raiders) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(RaidSpawnWaveEvent.getHandlerList()) }
        }
    }
}
