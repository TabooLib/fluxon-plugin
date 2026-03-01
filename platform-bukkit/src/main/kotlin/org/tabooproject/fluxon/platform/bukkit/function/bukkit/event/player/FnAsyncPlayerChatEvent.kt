package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.AsyncPlayerChatEvent
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

@Requires(classes = ["org.bukkit.event.player.AsyncPlayerChatEvent"])
@PlatformSide(Platform.BUKKIT)
object FnAsyncPlayerChatEvent {

    val TYPE = Type.fromClass(AsyncPlayerChatEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AsyncPlayerChatEvent::class.java)
                .function("message",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.message) }
                .function("setMessage", returnsVoid().params(Type.STRING)) { it.target?.setMessage(it.getString(0)!!) }
                .function("format",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.format) }
                .function("setFormat", returnsVoid().params(Type.STRING)) { it.target?.setFormat(it.getString(0)!!) }
                .function("recipients",returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.recipients) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(AsyncPlayerChatEvent.getHandlerList()) }
        }
    }
}
