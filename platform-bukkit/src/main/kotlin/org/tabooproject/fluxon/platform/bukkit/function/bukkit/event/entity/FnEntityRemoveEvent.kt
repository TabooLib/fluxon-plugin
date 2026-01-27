package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityRemoveEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.entity.EntityRemoveEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityRemoveEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityRemoveEvent::class.java)
                .function("cause", 0) { it.target?.cause }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityRemoveEvent.getHandlerList() }
        }
    }
}
