package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerHideEntityEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.player.PlayerHideEntityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerHideEntityEvent {

    val TYPE = Type.fromClass(PlayerHideEntityEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerHideEntityEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.entity) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerHideEntityEvent.getHandlerList()) }
        }
    }
}
