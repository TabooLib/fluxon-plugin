package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

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

@Requires(classes = ["org.bukkit.event.player.PlayerPreLoginEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerPreLoginEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerPreLoginEvent::class.java)
                .function("result", returnsObject().noParams()) { it.setReturnRef(it.target?.result) }
                .function("setResult", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setResult(it.getRef(0) as PlayerPreLoginEvent.Result)) }
                .function("kickMessage", returnsObject().noParams()) { it.setReturnRef(it.target?.kickMessage) }
                .function("setKickMessage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setKickMessage(it.getString(0)!!)) }
                .function("allow", returnsObject().noParams()) { it.setReturnRef(it.target?.allow()) }
                .function("disallow", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.disallow(
                        it.getRef(0) as PlayerPreLoginEvent.Result,
                        it.getString(1)!!
                    ))
                }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("address", returnsObject().noParams()) { it.setReturnRef(it.target?.address) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                .function("uniqueId", returnsObject().noParams()) { it.setReturnRef(it.target?.uniqueId) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerPreLoginEvent.getHandlerList()) }
        }
    }
}
