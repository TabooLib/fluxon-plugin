package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BrewingStartEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.block.BrewingStartEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBrewingStartEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewingStartEvent::class.java)
                .function("totalBrewTime", 0) { it.target?.totalBrewTime }
                .function("setTotalBrewTime", 1) { it.target?.setTotalBrewTime(it.getNumber(0).toInt()) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BrewingStartEvent.getHandlerList() }
        }
    }
}
