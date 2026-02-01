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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerMoveEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerMoveEvent {

    val TYPE = Type.fromClass(PlayerMoveEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerMoveEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("from", returnsObject().noParams()) { it.setReturnRef(it.target?.from) }
                .function("setFrom", returnsVoid().params(Type.OBJECT)) { it.target?.setFrom(it.getRef(0) as Location) }
                .function("to", returnsObject().noParams()) { it.setReturnRef(it.target?.to) }
                .function("setTo", returnsVoid().params(Type.OBJECT)) { it.target?.setTo(it.getRef(0) as Location) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerMoveEvent.getHandlerList()) }
        }
    }
}
