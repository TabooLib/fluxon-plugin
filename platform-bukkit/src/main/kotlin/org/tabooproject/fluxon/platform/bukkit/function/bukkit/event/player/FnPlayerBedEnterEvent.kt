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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerBedEnterEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerBedEnterEvent {

    val TYPE = Type.fromClass(PlayerBedEnterEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerBedEnterEvent::class.java)
                .function("bedEnterResult", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player.FnPlayerBedEnterEventBedEnterResult.TYPE).noParams()) { it.setReturnRef(it.target?.bedEnterResult) }
                .function("setUseBed",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnEventResult.TYPE)) { it.target?.setUseBed(it.getRef(0) as Event.Result) }
                .function("bed",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.bed) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerBedEnterEvent.getHandlerList()) }
        }
    }
}
