package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerPortalEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPlayerPortalEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerPortalEvent::class.java)
                .function("setSearchRadius", 1) { it.target?.setSearchRadius(it.getNumber(0).toInt()) }
                .function("searchRadius", 0) { it.target?.searchRadius }
                .function("canCreatePortal", 0) { it.target?.canCreatePortal }
                .function("setCanCreatePortal", 1) { it.target?.setCanCreatePortal(it.getBoolean(0)) }
                .function("setCreationRadius", 1) { it.target?.setCreationRadius(it.getNumber(0).toInt()) }
                .function("creationRadius", 0) { it.target?.creationRadius }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerPortalEvent.getHandlerList() }
        }
    }
}
