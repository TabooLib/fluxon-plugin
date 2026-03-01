package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerPreLoginEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerPreLoginEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerPreLoginEvent {

    val TYPE = Type.fromClass(PlayerPreLoginEvent::class.java)
    private val INET_ADDRESS = Type.fromClass(java.net.InetAddress::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerPreLoginEvent::class.java)
                .function("result", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player.FnPlayerPreLoginEventResult.TYPE).noParams()) { it.setReturnRef(it.target?.result) }
                .function("setResult", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player.FnPlayerPreLoginEventResult.TYPE)) { it.target?.setResult(it.getRef(0) as PlayerPreLoginEvent.Result)  }
                .function("setResult", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player.FnPlayerPreLoginEventResult.enumValue(it.getString(0))?.let { p0 -> it.target?.setResult(p0)  } }
                .function("kickMessage",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.kickMessage) }
                .function("setKickMessage", returnsVoid().params(Type.STRING)) { it.target?.setKickMessage(it.getString(0)!!) }
                .function("allow", returnsVoid().noParams()) { it.target?.allow() }
                .function("disallow", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player.FnPlayerPreLoginEventResult.TYPE, Type.STRING)) { it.target?.disallow(it.getRef(0) as PlayerPreLoginEvent.Result, it.getString(1)!!) }
                .function("disallow", returnsVoid().params(Type.STRING, Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player.FnPlayerPreLoginEventResult.enumValue(it.getString(0))?.let { p0 -> it.target?.disallow(p0, it.getString(1)!!) } }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("address", returns(INET_ADDRESS).noParams()) { it.setReturnRef(it.target?.address) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                .function("uniqueId",returns(org.tabooproject.fluxon.util.StandardTypes.UUID).noParams()) { it.setReturnRef(it.target?.uniqueId) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerPreLoginEvent.getHandlerList()) }
        }
    }
}
