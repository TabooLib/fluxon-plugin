package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerResourcePackStatusEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.player.PlayerResourcePackStatusEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerResourcePackStatusEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerResourcePackStatusEvent::class.java)
                .function("iD", returnsObject().noParams()) { it.target?.id }
                .function("status", returnsObject().noParams()) { it.target?.status }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PlayerResourcePackStatusEvent.getHandlerList() }
        }
    }
}
