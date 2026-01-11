package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityPoseChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntityPoseChangeEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityPoseChangeEvent::class.java)
                .function("pose", 0) { it.target?.pose }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityPoseChangeEvent.getHandlerList() }
        }
    }
}
