package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.DyeColor
import org.bukkit.event.entity.SheepDyeWoolEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSheepDyeWoolEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SheepDyeWoolEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("entity", 0) { it.target?.getEntity() }
                .function("player", 0) { it.target?.player }
                .function("color", 0) { it.target?.color }
                .function("setColor", 1) { it.target?.setColor(it.getArgument(0) as DyeColor) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { SheepDyeWoolEvent.getHandlerList() }
        }
    }
}
