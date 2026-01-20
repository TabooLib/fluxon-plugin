package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.entity.Villager
import org.bukkit.event.entity.VillagerCareerChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnVillagerCareerChangeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VillagerCareerChangeEvent::class.java)
                .function("entity", 0) { it.target?.getEntity() }
                .function("setProfession", 1) { it.target?.setProfession(it.getArgument(0) as Villager.Profession) }
                .function("reason", 0) { it.target?.reason }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { VillagerCareerChangeEvent.getHandlerList() }
        }
    }
}
