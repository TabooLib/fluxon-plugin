package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerExpChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.player.PlayerExpChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerExpChangeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerExpChangeEvent::class.java)
                .function("amount", returnsObject().noParams()) { it.target?.amount }
                .function("setAmount", returnsObject().params(Type.OBJECT)) { it.target?.setAmount(it.getInt(0).toInt()) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PlayerExpChangeEvent.getHandlerList() }
        }
    }
}
