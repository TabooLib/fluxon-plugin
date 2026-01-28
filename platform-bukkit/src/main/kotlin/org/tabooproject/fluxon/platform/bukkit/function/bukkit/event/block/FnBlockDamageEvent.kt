package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockDamageEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.event.block.BlockDamageEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockDamageEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDamageEvent::class.java)
                .function("player", returnsObject().noParams()) { it.target?.player }
                .function("instaBreak", returnsObject().noParams()) { it.target?.instaBreak }
                .function("setInstaBreak", returnsObject().params(Type.OBJECT)) { it.target?.setInstaBreak(it.getBool(0)) }
                .function("itemInHand", returnsObject().noParams()) { it.target?.itemInHand }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { BlockDamageEvent.getHandlerList() }
        }
    }
}
