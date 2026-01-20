package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.ProjectileHitEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnProjectileHitEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ProjectileHitEvent::class.java)
                .function("entity", 0) { it.target?.getEntity() }
                .function("hitBlock", 0) { it.target?.hitBlock }
                .function("hitBlockFace", 0) { it.target?.hitBlockFace }
                .function("hitEntity", 0) { it.target?.hitEntity }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { ProjectileHitEvent.getHandlerList() }
        }
    }
}
