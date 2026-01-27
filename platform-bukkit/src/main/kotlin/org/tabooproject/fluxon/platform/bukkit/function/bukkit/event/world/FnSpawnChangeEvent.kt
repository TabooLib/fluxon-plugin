package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.SpawnChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.world.SpawnChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnChangeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnChangeEvent::class.java)
                .function("previousLocation", 0) { it.target?.previousLocation }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { SpawnChangeEvent.getHandlerList() }
        }
    }
}
