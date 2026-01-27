package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerKickEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.player.PlayerKickEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerKickEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerKickEvent::class.java)
                .function("reason", 0) { it.target?.reason }
                .function("leaveMessage", 0) { it.target?.leaveMessage }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("setReason", 1) { it.target?.setReason(it.getString(0)!!) }
                .function("setLeaveMessage", 1) { it.target?.setLeaveMessage(it.getString(0)!!) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerKickEvent.getHandlerList() }
        }
    }
}
