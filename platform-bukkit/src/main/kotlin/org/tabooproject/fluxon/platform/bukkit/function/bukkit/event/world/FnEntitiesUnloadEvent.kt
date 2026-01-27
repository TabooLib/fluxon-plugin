package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.EntitiesUnloadEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.world.EntitiesUnloadEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntitiesUnloadEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntitiesUnloadEvent::class.java)
                .function("entities", 0) { it.target?.entities }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntitiesUnloadEvent.getHandlerList() }
        }
    }
}
