package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerAdvancementDoneEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.player.PlayerAdvancementDoneEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerAdvancementDoneEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerAdvancementDoneEvent::class.java)
                .function("advancement", 0) { it.target?.advancement }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerAdvancementDoneEvent.getHandlerList() }
        }
    }
}
