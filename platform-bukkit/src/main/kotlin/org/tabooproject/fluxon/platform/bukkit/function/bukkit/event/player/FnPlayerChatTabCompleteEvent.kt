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

@Requires(classes = ["org.bukkit.event.player.PlayerChatTabCompleteEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerChatTabCompleteEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerChatTabCompleteEvent::class.java)
                .function("chatMessage", returnsObject().noParams()) { it.setReturnRef(it.target?.chatMessage) }
                .function("lastToken", returnsObject().noParams()) { it.setReturnRef(it.target?.lastToken) }
                .function("tabCompletions", returnsObject().noParams()) { it.setReturnRef(it.target?.tabCompletions) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerChatTabCompleteEvent.getHandlerList()) }
        }
    }
}
