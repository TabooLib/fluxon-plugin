package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityBreedEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.entity.EntityBreedEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityBreedEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityBreedEvent::class.java)
                .function("entity", 0) { it.target?.getEntity() }
                .function("mother", 0) { it.target?.mother }
                .function("father", 0) { it.target?.father }
                .function("breeder", 0) { it.target?.breeder }
                .function("bredWith", 0) { it.target?.bredWith }
                .function("experience", 0) { it.target?.experience }
                .function("setExperience", 1) { it.target?.setExperience(it.getNumber(0).toInt()) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityBreedEvent.getHandlerList() }
        }
    }
}
