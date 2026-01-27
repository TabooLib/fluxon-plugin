package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.entity.LivingEntity
import org.bukkit.event.entity.PotionSplashEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.entity.PotionSplashEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPotionSplashEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionSplashEvent::class.java)
                .function("entity", 0) { it.target?.getEntity() }
                .function("potion", 0) { it.target?.potion }
                .function("affectedEntities", 0) { it.target?.affectedEntities }
                .function("getIntensity", 1) { it.target?.getIntensity(it.getArgument(0) as LivingEntity) }
                .function("setIntensity", 2) {
                    it.target?.setIntensity(
                        it.getArgument(0) as LivingEntity,
                        it.getNumber(1).toDouble()
                    )
                }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PotionSplashEvent.getHandlerList() }
        }
    }
}
