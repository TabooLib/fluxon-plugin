package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.Location
import org.bukkit.event.player.PlayerMoveEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerMoveEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerMoveEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerMoveEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("from", returnsObject().noParams()) { it.target?.from }
                .function("setFrom", returnsObject().params(Type.OBJECT)) { it.target?.setFrom(it.getRef(0) as Location) }
                .function("to", returnsObject().noParams()) { it.target?.to }
                .function("setTo", returnsObject().params(Type.OBJECT)) { it.target?.setTo(it.getRef(0) as Location) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PlayerMoveEvent.getHandlerList() }
        }
    }
}
