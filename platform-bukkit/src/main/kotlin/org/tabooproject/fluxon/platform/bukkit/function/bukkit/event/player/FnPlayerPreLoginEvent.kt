package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerPreLoginEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.player.PlayerPreLoginEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerPreLoginEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerPreLoginEvent::class.java)
                .function("result", 0) { it.target?.result }
                .function("setResult", 1) { it.target?.setResult(it.getArgument(0) as PlayerPreLoginEvent.Result) }
                .function("kickMessage", 0) { it.target?.kickMessage }
                .function("setKickMessage", 1) { it.target?.setKickMessage(it.getString(0)!!) }
                .function("allow", 0) { it.target?.allow() }
                .function("disallow", 2) {
                    it.target?.disallow(
                        it.getArgument(0) as PlayerPreLoginEvent.Result,
                        it.getString(1)!!
                    )
                }
                .function("name", 0) { it.target?.name }
                .function("address", 0) { it.target?.address }
                .function("handlers", 0) { it.target?.handlers }
                .function("uniqueId", 0) { it.target?.uniqueId }
                // static
                .function("handlerList", 0) { PlayerPreLoginEvent.getHandlerList() }
        }
    }
}
