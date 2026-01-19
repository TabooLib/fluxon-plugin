package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.entity.Entity
import org.bukkit.event.entity.EntityShootBowEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnEntityShootBowEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityShootBowEvent::class.java)
                .function("entity", 0) { it.target?.getEntity() }
                .function("bow", 0) { it.target?.bow }
                .function("consumable", 0) { it.target?.consumable }
                .function("projectile", 0) { it.target?.projectile }
                .function("setProjectile", 1) { it.target?.setProjectile(it.getArgument(0) as Entity) }
                .function("hand", 0) { it.target?.hand }
                .function("force", 0) { it.target?.force }
                .function("setConsumeItem", 1) { it.target?.setConsumeItem(it.getBoolean(0)) }
                .function("shouldConsumeItem", 0) { it.target?.shouldConsumeItem() }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityShootBowEvent.getHandlerList() }
        }
    }
}
