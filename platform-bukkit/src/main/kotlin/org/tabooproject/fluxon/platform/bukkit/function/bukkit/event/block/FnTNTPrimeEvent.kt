package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.TNTPrimeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnTNTPrimeEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TNTPrimeEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("cause", 0) { it.target?.cause }
                .function("primingEntity", 0) { it.target?.primingEntity }
                .function("primingBlock", 0) { it.target?.primingBlock }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { TNTPrimeEvent.getHandlerList() }
        }
    }
}
