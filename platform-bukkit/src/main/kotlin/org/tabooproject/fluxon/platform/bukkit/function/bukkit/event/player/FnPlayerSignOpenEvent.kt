package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerSignOpenEvent
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

@Requires(classes = ["org.bukkit.event.player.PlayerSignOpenEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerSignOpenEvent {

    val TYPE = Type.fromClass(PlayerSignOpenEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerSignOpenEvent::class.java)
                .function("sign",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnSign.TYPE).noParams()) { it.setReturnRef(it.target?.sign) }
                .function("side",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.sign.FnSide.TYPE).noParams()) { it.setReturnRef(it.target?.side) }
                .function("cause", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player.FnPlayerSignOpenEventCause.TYPE).noParams()) { it.setReturnRef(it.target?.cause) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerSignOpenEvent.getHandlerList()) }
        }
    }
}
