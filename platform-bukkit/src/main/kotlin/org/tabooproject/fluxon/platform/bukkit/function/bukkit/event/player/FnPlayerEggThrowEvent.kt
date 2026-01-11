package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerEggThrowEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPlayerEggThrowEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerEggThrowEvent::class.java)
                .function("egg", 0) { it.target?.egg }
                .function("isHatching", 0) { it.target?.isHatching }
                .function("setHatching", 1) { it.target?.setHatching(it.getBoolean(0)) }
                .function("hatchingType", 0) { it.target?.hatchingType }
                .function("setHatchingType", 1) { it.target?.setHatchingType(it.getArgument(0) as EntityType) }
                .function("numHatches", 0) { it.target?.numHatches }
                .function("setNumHatches", 1) { it.target?.setNumHatches(it.getNumber(0).toByte()) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerEggThrowEvent.getHandlerList() }
        }
    }
}
