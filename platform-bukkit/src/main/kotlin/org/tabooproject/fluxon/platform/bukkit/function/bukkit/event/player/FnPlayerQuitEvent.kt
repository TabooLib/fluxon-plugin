package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerQuitEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.player.PlayerQuitEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerQuitEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerQuitEvent::class.java)
                .function("quitMessage", returnsObject().noParams()) { it.setReturnRef(it.target?.quitMessage) }
                .function("setQuitMessage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setQuitMessage(it.getString(0))) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerQuitEvent.getHandlerList()) }
        }
    }
}
