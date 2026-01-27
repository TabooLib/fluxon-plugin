package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.PortalCreateEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.world.PortalCreateEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPortalCreateEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PortalCreateEvent::class.java)
                .function("blocks", 0) { it.target?.blocks }
                .function("entity", 0) { it.target?.entity }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("reason", 0) { it.target?.reason }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PortalCreateEvent.getHandlerList() }
        }
    }
}
