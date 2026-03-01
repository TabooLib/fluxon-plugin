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
                .function("reason",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.reason) }
                .function("leaveMessage",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.leaveMessage) }
                .function("setReason", returnsVoid().params(Type.STRING)) { it.target?.setReason(it.getString(0)!!) }
                .function("setLeaveMessage", returnsVoid().params(Type.STRING)) { it.target?.setLeaveMessage(it.getString(0)!!) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerKickEvent.getHandlerList()) }
        }
    }
}
