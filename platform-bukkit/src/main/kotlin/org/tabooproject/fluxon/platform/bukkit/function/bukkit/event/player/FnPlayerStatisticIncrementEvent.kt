package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerStatisticIncrementEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.player.PlayerStatisticIncrementEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerStatisticIncrementEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerStatisticIncrementEvent::class.java)
                .function("statistic", 0) { it.target?.getStatistic() }
                .function("previousValue", 0) { it.target?.previousValue }
                .function("newValue", 0) { it.target?.newValue }
                .function("entityType", 0) { it.target?.entityType }
                .function("material", 0) { it.target?.material }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerStatisticIncrementEvent.getHandlerList() }
        }
    }
}
