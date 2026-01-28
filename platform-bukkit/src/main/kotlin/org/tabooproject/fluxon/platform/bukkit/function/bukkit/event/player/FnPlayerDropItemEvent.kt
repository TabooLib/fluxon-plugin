package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerDropItemEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerDropItemEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerDropItemEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerDropItemEvent::class.java)
                .function("itemDrop", returnsObject().noParams()) { it.target?.itemDrop }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PlayerDropItemEvent.getHandlerList() }
        }
    }
}
