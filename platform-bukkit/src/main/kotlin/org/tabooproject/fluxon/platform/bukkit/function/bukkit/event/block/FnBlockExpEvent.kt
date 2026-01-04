package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockExpEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlockExpEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockExpEvent::class.java)
                .function("expToDrop", 0) { it.target?.expToDrop }
                .syncFunction("setExpToDrop", 1) { it.target?.apply { expToDrop = it.getNumber(0).toInt() } }
        }
    }
}
