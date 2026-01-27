package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityToggleSwimEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.entity.EntityToggleSwimEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityToggleSwimEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityToggleSwimEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("isSwimming", 0) { it.target?.isSwimming }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityToggleSwimEvent.getHandlerList() }
        }
    }
}
