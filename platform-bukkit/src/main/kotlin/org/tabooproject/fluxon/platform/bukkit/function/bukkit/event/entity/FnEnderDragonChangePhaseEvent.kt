package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.entity.EnderDragon
import org.bukkit.event.entity.EnderDragonChangePhaseEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEnderDragonChangePhaseEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnderDragonChangePhaseEvent::class.java)
                .function("entity", 0) { it.target?.getEntity() }
                .function("setNewPhase", 1) { it.target?.setNewPhase(it.getArgument(0) as EnderDragon.Phase) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EnderDragonChangePhaseEvent.getHandlerList() }
        }
    }
}
