package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.entity.Entity
import org.bukkit.event.entity.EntityTargetLivingEntityEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEntityTargetLivingEntityEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityTargetLivingEntityEvent::class.java)
                .function("target", 0) { it.target?.target }
                .function("setTarget", 1) { it.target?.setTarget(it.getArgument(0) as Entity) }
        }
    }
}
