package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerVelocityEvent
import org.bukkit.util.Vector
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

@Requires(classes = ["org.bukkit.event.player.PlayerVelocityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerVelocityEvent {

    val TYPE = Type.fromClass(PlayerVelocityEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerVelocityEvent::class.java)
                .function("velocity",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.velocity) }
                .function("setVelocity",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.target?.setVelocity(it.getRef(0) as Vector) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerVelocityEvent.getHandlerList()) }
        }
    }
}
