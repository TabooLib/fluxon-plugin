package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.Event
import org.bukkit.event.player.PlayerBedEnterEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerBedEnterEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerBedEnterEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerBedEnterEvent::class.java)
                .function("bedEnterResult", returnsObject().noParams()) { it.setReturnRef(it.target?.bedEnterResult) }
                .function("setUseBed", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setUseBed(it.getRef(0) as Event.Result)) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelled(it.getBool(0))) }
                .function("bed", returnsObject().noParams()) { it.setReturnRef(it.target?.bed) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerBedEnterEvent.getHandlerList()) }
        }
    }
}
