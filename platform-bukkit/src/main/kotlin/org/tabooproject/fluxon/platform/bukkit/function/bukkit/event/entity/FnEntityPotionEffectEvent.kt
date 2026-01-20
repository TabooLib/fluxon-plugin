package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityPotionEffectEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEntityPotionEffectEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityPotionEffectEvent::class.java)
                .function("oldEffect", 0) { it.target?.oldEffect }
                .function("newEffect", 0) { it.target?.newEffect }
                .function("cause", 0) { it.target?.cause }
                .function("action", 0) { it.target?.action }
                .function("modifiedType", 0) { it.target?.modifiedType }
                .function("isOverride", 0) { it.target?.isOverride }
                .function("setOverride", 1) { it.target?.setOverride(it.getBoolean(0)) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityPotionEffectEvent.getHandlerList() }
        }
    }
}
