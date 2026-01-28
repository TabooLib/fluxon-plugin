package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerLoginEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.player.PlayerLoginEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerLoginEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerLoginEvent::class.java)
                .function("result", returnsObject().noParams()) { it.setReturnRef(it.target?.result) }
                .function("setResult", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setResult(it.getRef(0) as PlayerLoginEvent.Result)) }
                .function("kickMessage", returnsObject().noParams()) { it.setReturnRef(it.target?.kickMessage) }
                .function("setKickMessage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setKickMessage(it.getString(0)!!)) }
                .function("hostname", returnsObject().noParams()) { it.setReturnRef(it.target?.hostname) }
                .function("allow", returnsObject().noParams()) { it.setReturnRef(it.target?.allow()) }
                .function("disallow", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.disallow(
                        it.getRef(0) as PlayerLoginEvent.Result,
                        it.getString(1)!!
                    ))
                }
                .function("address", returnsObject().noParams()) { it.setReturnRef(it.target?.address) }
                .function("realAddress", returnsObject().noParams()) { it.setReturnRef(it.target?.realAddress) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerLoginEvent.getHandlerList()) }
        }
    }
}
