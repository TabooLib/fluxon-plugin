package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.entity.Entity
import org.bukkit.event.entity.EntityTargetEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEntityTargetEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityTargetEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("reason", 0) { it.target?.reason }
                .function("target", 0) { it.target?.target }
                .function("setTarget", 1) { it.target?.setTarget(it.getArgument(0) as Entity) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityTargetEvent.getHandlerList() }
        }
    }
}
