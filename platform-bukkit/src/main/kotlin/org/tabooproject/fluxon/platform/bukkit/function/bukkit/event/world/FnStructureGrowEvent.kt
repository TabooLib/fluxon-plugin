package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.StructureGrowEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnStructureGrowEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureGrowEvent::class.java)
                .function("location", 0) { it.target?.location }
                .function("species", 0) { it.target?.species }
                .function("isFromBonemeal", 0) { it.target?.isFromBonemeal }
                .function("player", 0) { it.target?.player }
                .function("blocks", 0) { it.target?.blocks }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { StructureGrowEvent.getHandlerList() }
        }
    }
}
