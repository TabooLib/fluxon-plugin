package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.AsyncPlayerChatEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.AsyncPlayerChatEvent"])
@PlatformSide(Platform.BUKKIT)
object FnAsyncPlayerChatEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AsyncPlayerChatEvent::class.java)
                .function("message", returnsObject().noParams()) { it.setReturnRef(it.target?.message) }
                .function("setMessage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMessage(it.getString(0)!!)) }
                .function("format", returnsObject().noParams()) { it.setReturnRef(it.target?.format) }
                .function("setFormat", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFormat(it.getString(0)!!)) }
                .function("recipients", returnsObject().noParams()) { it.setReturnRef(it.target?.recipients) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelled(it.getBool(0))) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(AsyncPlayerChatEvent.getHandlerList()) }
        }
    }
}
