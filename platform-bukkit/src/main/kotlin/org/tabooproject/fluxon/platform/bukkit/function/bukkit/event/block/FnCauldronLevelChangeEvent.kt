package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.CauldronLevelChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCauldronLevelChangeEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CauldronLevelChangeEvent::class.java)
                .function("entity", 0) { it.target?.entity }
                .function("reason", 0) { it.target?.reason }
                .function("newState", 0) { it.target?.newState }
                .function("oldLevel", 0) { it.target?.oldLevel }
                .function("newLevel", 0) { it.target?.newLevel }
                .function("setNewLevel", 1) { it.target?.setNewLevel(it.getNumber(0).toInt()) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { CauldronLevelChangeEvent.getHandlerList() }
        }
    }
}
