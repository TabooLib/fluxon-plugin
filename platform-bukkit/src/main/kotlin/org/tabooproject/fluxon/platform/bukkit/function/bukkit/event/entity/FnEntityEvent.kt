package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires


@Requires(classes = ["org.bukkit.event.entity.EntityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityEvent::class.java)
                .function("entity", 0) { it.target?.getEntity() }
                .function("entityType", 0) { it.target?.entityType }
        }
    }
}
