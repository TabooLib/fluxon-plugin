package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.ProjectileHitEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnProjectileHitEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ProjectileHitEvent::class.java)
                .function("hitBlock", 0) { it.target?.hitBlock }
                .function("hitBlockFace", 0) { it.target?.hitBlockFace }
                .function("hitEntity", 0) { it.target?.hitEntity }
        }
    }
}
