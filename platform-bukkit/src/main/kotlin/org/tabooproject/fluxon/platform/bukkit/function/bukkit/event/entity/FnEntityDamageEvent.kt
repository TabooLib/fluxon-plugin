package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityDamageEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnEntityDamageEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityDamageEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function(
                    "originalDamage",
                    1
                ) { it.target?.getOriginalDamage(it.getArgument(0) as EntityDamageEvent.DamageModifier) }
                .function("setDamage", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setDamage(it.getNumber(0).toDouble())
                    } else {
                        it.target?.setDamage(
                            it.getArgument(0) as EntityDamageEvent.DamageModifier,
                            it.getNumber(1).toDouble()
                        )
                    }
                }
                .function("damage", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.damage
                    } else {
                        it.target?.getDamage(it.getArgument(0) as EntityDamageEvent.DamageModifier)
                    }
                }
                .function(
                    "isApplicable",
                    1
                ) { it.target?.isApplicable(it.getArgument(0) as EntityDamageEvent.DamageModifier) }
                .function("finalDamage", 0) { it.target?.finalDamage }
                .function("cause", 0) { it.target?.cause }
                .function("damageSource", 0) { it.target?.damageSource }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityDamageEvent.getHandlerList() }
        }
    }
}
