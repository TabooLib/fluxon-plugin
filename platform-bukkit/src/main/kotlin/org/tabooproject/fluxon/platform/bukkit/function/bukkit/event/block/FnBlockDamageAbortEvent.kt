package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockDamageAbortEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlockDamageAbortEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDamageAbortEvent::class.java)
                .function("player", 0) { it.target?.player }
                .function("itemInHand", 0) { it.target?.itemInHand }
        }
    }
}
