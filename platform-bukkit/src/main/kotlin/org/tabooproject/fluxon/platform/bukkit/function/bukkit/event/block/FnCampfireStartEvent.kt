package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.CampfireStartEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCampfireStartEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CampfireStartEvent::class.java)
                .function("recipe", 0) { it.target?.recipe }
                .function("totalCookTime", 0) { it.target?.totalCookTime }
                .function("setTotalCookTime", 1) { it.target?.setTotalCookTime(it.getNumber(0).toInt()) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { CampfireStartEvent.getHandlerList() }
        }
    }
}
