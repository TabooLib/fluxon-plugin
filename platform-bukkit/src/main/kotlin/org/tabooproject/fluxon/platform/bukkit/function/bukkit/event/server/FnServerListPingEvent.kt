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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.server.ServerListPingEvent"])
@PlatformSide(Platform.BUKKIT)
object FnServerListPingEvent {

    val TYPE = Type.fromClass(ServerListPingEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServerListPingEvent::class.java)
                .function("hostname", returnsObject().noParams()) { it.setReturnRef(it.target?.hostname) }
                .function("address", returnsObject().noParams()) { it.setReturnRef(it.target?.address) }
                .function("motd", returnsObject().noParams()) { it.setReturnRef(it.target?.motd) }
                .function("setMotd", returnsVoid().params(Type.STRING)) { it.target?.setMotd(it.getString(0)!!) }
                .function("numPlayers", returns(Type.I).noParams()) { it.setReturnInt(it.target?.numPlayers ?: 0) }
                .function("maxPlayers", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxPlayers ?: 0) }
                .function("shouldSendChatPreviews", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.shouldSendChatPreviews() ?: false)
                }
                .function("setMaxPlayers", returnsVoid().params(Type.I)) { it.target?.setMaxPlayers(it.getInt(0).toInt()) }
                .function("setServerIcon", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setServerIcon(it.getRef(0) as CachedServerIcon)
                }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(ServerListPingEvent.getHandlerList()) }
                .function("iterator", returnsObject().noParams()) { it.setReturnRef(it.target?.iterator()) }
        }
    }
}
