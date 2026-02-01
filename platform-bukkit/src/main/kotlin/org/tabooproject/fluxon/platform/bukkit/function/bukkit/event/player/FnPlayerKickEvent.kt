package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerKickEvent
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

@Requires(classes = ["org.bukkit.event.player.PlayerKickEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerKickEvent {

    val TYPE = Type.fromClass(PlayerKickEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerKickEvent::class.java)
                .function("reason", returnsObject().noParams()) { it.setReturnRef(it.target?.reason) }
                .function("leaveMessage", returnsObject().noParams()) { it.setReturnRef(it.target?.leaveMessage) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("setReason", returnsVoid().params(Type.STRING)) { it.target?.setReason(it.getString(0)!!) }
                .function("setLeaveMessage", returnsVoid().params(Type.STRING)) { it.target?.setLeaveMessage(it.getString(0)!!) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerKickEvent.getHandlerList()) }
        }
    }
}
