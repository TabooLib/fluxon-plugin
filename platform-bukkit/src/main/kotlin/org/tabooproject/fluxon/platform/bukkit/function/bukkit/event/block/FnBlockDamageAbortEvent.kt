package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockDamageAbortEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockDamageAbortEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockDamageAbortEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDamageAbortEvent::class.java)
                .function("player", 0) { it.target?.player }
                .function("itemInHand", 0) { it.target?.itemInHand }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BlockDamageAbortEvent.getHandlerList() }
        }
    }
}
