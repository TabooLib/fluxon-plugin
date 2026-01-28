package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.bukkit.event.player.PlayerPreLoginEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.AsyncPlayerPreLoginEvent"])
@PlatformSide(Platform.BUKKIT)
object FnAsyncPlayerPreLoginEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AsyncPlayerPreLoginEvent::class.java)
                .function("loginResult", returnsObject().noParams()) { it.target?.loginResult }
                .function("setLoginResult", returnsObject().params(Type.OBJECT)) { it.target?.setLoginResult(it.getRef(0) as AsyncPlayerPreLoginEvent.Result) }
                .function("setResult", returnsObject().params(Type.OBJECT)) { it.target?.setResult(it.getRef(0) as PlayerPreLoginEvent.Result) }
                .function("kickMessage", returnsObject().noParams()) { it.target?.kickMessage }
                .function("setKickMessage", returnsObject().params(Type.OBJECT)) { it.target?.setKickMessage(it.getString(0)!!) }
                .function("allow", returnsObject().noParams()) { it.target?.allow() }
                .function("disallow", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is AsyncPlayerPreLoginEvent.Result -> it.target?.disallow(var1, it.getString(1)!!)
                        is PlayerPreLoginEvent.Result -> it.target?.disallow(var1, it.getString(1)!!)
                        else -> throw IllegalArgumentException("参数必须是 AsyncPlayerPreLoginEvent.Result 或 PlayerPreLoginEvent.Result 类型")
                    }
                }
                .function("name", returns(Type.STRING).noParams()) { it.target?.name }
                .function("address", returnsObject().noParams()) { it.target?.address }
                .function("uniqueId", returnsObject().noParams()) { it.target?.uniqueId }
                .function("isTransferred", returns(Type.Z).noParams()) { it.target?.isTransferred }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { AsyncPlayerPreLoginEvent.getHandlerList() }
        }
    }
}
