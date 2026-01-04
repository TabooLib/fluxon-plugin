package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockBreakEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlockBreakEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockBreakEvent::class.java)
                .function("player", 0) { it.target?.player }
                .function("isDropItems", 0) { it.target?.isDropItems }
                .function("setDropItems", 1) { it.getBoolean(0) }
        }
    }
}