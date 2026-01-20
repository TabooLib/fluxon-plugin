package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityPortalExitEvent
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEntityPortalExitEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityPortalExitEvent::class.java)
                .function("before", 0) { it.target?.before }
                .function("after", 0) { it.target?.after }
                .function("setAfter", 1) { it.target?.setAfter(it.getArgument(0) as Vector) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityPortalExitEvent.getHandlerList() }
        }
    }
}
