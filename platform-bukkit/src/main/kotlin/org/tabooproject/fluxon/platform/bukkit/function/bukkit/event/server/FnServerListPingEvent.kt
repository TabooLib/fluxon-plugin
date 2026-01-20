package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.ServerListPingEvent
import org.bukkit.util.CachedServerIcon
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnServerListPingEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServerListPingEvent::class.java)
                .function("hostname", 0) { it.target?.hostname }
                .function("address", 0) { it.target?.address }
                .function("motd", 0) { it.target?.motd }
                .function("setMotd", 1) { it.target?.setMotd(it.getString(0)!!) }
                .function("numPlayers", 0) { it.target?.numPlayers }
                .function("maxPlayers", 0) { it.target?.maxPlayers }
                .function("shouldSendChatPreviews", 0) { it.target?.shouldSendChatPreviews() }
                .function("setMaxPlayers", 1) { it.target?.setMaxPlayers(it.getNumber(0).toInt()) }
                .function("setServerIcon", 0) { it.target?.setServerIcon(it.getArgument(0) as CachedServerIcon) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { ServerListPingEvent.getHandlerList() }
                .function("iterator", 0) { it.target?.iterator() }
        }
    }
}
