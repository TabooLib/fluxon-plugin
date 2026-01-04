package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockExplodeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlockExplodeEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockExplodeEvent::class.java)
                .function("blockList", 0) { it.target?.blockList() }
                .function("yield", 0) { it.target?.yield }
                .syncFunction("setYield", 1) { it.target?.apply { yield = it.getNumber(0).toFloat() } }
        }
    }
}
