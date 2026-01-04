package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.entity.Entity
import org.bukkit.event.entity.EntityShootBowEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntityShootBowEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityShootBowEvent::class.java)
                .function("bow", 0) { it.target?.bow }
                .function("hand", 0) { it.target?.hand }
                .function("force", 0) { it.target?.force }
                .function("consumable", 0) { it.target?.consumable }
                .function("shouldConsumeItem", 0) { it.target?.shouldConsumeItem() }
                .syncFunction("setConsumeItem", 1) { it.target?.setConsumeItem(it.getBoolean(0)) }
                .function("projectile", 0) { it.target?.projectile }
                .syncFunction("setProjectile", 1) { it.target?.apply { projectile = it.getArgument(0) as Entity } }
        }
    }
}
