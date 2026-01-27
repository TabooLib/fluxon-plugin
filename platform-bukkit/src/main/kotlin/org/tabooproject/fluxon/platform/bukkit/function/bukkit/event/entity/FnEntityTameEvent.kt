package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityTameEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.entity.EntityTameEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityTameEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityTameEvent::class.java)
                .function("entity", 0) { it.target?.getEntity() }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("owner", 0) { it.target?.owner }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityTameEvent.getHandlerList() }
        }
    }
}
