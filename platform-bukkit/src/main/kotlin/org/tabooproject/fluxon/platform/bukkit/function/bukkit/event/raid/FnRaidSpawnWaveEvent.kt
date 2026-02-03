package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.raid

import org.bukkit.event.raid.RaidSpawnWaveEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnRaider
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.raid.RaidSpawnWaveEvent"])
@PlatformSide(Platform.BUKKIT)
object FnRaidSpawnWaveEvent {

    val TYPE = Type.fromClass(RaidSpawnWaveEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RaidSpawnWaveEvent::class.java)
                .function("patrolLeader", returns(FnRaider.TYPE).noParams()) { it.setReturnRef(it.target?.patrolLeader) }
                .function("raiders", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.raiders) }
        }
    }
}
