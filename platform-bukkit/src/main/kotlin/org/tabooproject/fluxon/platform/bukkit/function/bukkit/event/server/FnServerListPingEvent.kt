package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.ServerListPingEvent
import org.bukkit.util.CachedServerIcon
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.server.ServerListPingEvent"])
@PlatformSide(Platform.BUKKIT)
object FnServerListPingEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServerListPingEvent::class.java)
                .function("hostname", returnsObject().noParams()) { it.setReturnRef(it.target?.hostname) }
                .function("address", returnsObject().noParams()) { it.setReturnRef(it.target?.address) }
                .function("motd", returnsObject().noParams()) { it.setReturnRef(it.target?.motd) }
                .function("setMotd", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMotd(it.getString(0)!!)) }
                .function("numPlayers", returnsObject().noParams()) { it.setReturnRef(it.target?.numPlayers) }
                .function("maxPlayers", returnsObject().noParams()) { it.setReturnRef(it.target?.maxPlayers) }
                .function("shouldSendChatPreviews", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.shouldSendChatPreviews()) }
                .function("setMaxPlayers", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaxPlayers(it.getInt(0).toInt())) }
                .function("setServerIcon", returnsObject().noParams()) { it.setReturnRef(it.target?.setServerIcon(it.getRef(0) as CachedServerIcon)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(ServerListPingEvent.getHandlerList()) }
                .function("iterator", returnsObject().noParams()) { it.setReturnRef(it.target?.iterator()) }
        }
    }
}
