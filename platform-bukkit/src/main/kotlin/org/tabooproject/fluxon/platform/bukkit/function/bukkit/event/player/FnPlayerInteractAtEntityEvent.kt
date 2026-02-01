package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerInteractAtEntityEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.player.PlayerInteractAtEntityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerInteractAtEntityEvent {

    val TYPE = Type.fromClass(PlayerInteractAtEntityEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerInteractAtEntityEvent::class.java)
                .function("clickedPosition", returnsObject().noParams()) { it.setReturnRef(it.target?.clickedPosition) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerInteractAtEntityEvent.getHandlerList()) }
        }
    }
}
