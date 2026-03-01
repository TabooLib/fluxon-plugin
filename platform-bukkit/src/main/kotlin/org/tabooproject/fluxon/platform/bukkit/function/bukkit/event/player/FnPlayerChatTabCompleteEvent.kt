package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerChatTabCompleteEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerChatTabCompleteEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerChatTabCompleteEvent {

    val TYPE = Type.fromClass(PlayerChatTabCompleteEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerChatTabCompleteEvent::class.java)
                .function("chatMessage",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.chatMessage) }
                .function("lastToken",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.lastToken) }
                .function("tabCompletions",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.tabCompletions) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerChatTabCompleteEvent.getHandlerList()) }
        }
    }
}
