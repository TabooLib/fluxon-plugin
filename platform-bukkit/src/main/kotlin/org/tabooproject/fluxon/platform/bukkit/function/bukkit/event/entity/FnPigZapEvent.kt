package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.PigZapEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.entity.PigZapEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPigZapEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PigZapEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("entity", 0) { it.target?.getEntity() }
                .function("lightning", 0) { it.target?.lightning }
                .function("pigZombie", 0) { it.target?.pigZombie }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PigZapEvent.getHandlerList() }
        }
    }
}
