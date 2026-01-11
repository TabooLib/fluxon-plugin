package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockDamageEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlockDamageEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDamageEvent::class.java)
                .function("player", 0) { it.target?.player }
                .function("instaBreak", 0) { it.target?.instaBreak }
                .function("setInstaBreak", 1) { it.target?.setInstaBreak(it.getBoolean(0)) }
                .function("itemInHand", 0) { it.target?.itemInHand }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BlockDamageEvent.getHandlerList() }
        }
    }
}
