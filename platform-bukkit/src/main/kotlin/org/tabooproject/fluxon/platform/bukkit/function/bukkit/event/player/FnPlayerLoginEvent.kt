package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerLoginEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerLoginEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerLoginEvent::class.java)
                .function("result", 0) { it.target?.result }
                .function("setResult", 1) { it.target?.setResult(it.getArgument(0) as PlayerLoginEvent.Result) }
                .function("kickMessage", 0) { it.target?.kickMessage }
                .function("setKickMessage", 1) { it.target?.setKickMessage(it.getString(0)!!) }
                .function("hostname", 0) { it.target?.hostname }
                .function("allow", 0) { it.target?.allow() }
                .function("disallow", 2) {
                    it.target?.disallow(
                        it.getArgument(0) as PlayerLoginEvent.Result,
                        it.getString(1)!!
                    )
                }
                .function("address", 0) { it.target?.address }
                .function("realAddress", 0) { it.target?.realAddress }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerLoginEvent.getHandlerList() }
        }
    }
}
