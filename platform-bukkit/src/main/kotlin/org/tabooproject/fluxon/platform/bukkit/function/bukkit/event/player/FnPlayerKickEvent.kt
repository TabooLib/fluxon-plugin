package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerKickEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerKickEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerKickEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerKickEvent::class.java)
                .function("reason", returnsObject().noParams()) { it.target?.reason }
                .function("leaveMessage", returnsObject().noParams()) { it.target?.leaveMessage }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("setReason", returnsObject().params(Type.OBJECT)) { it.target?.setReason(it.getString(0)!!) }
                .function("setLeaveMessage", returnsObject().params(Type.OBJECT)) { it.target?.setLeaveMessage(it.getString(0)!!) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PlayerKickEvent.getHandlerList() }
        }
    }
}
