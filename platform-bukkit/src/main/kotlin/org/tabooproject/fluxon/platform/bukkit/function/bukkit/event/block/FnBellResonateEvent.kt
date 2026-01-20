package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BellResonateEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.block.BellResonateEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBellResonateEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BellResonateEvent::class.java)
                .function("resonatedEntities", 0) { it.target?.resonatedEntities }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BellResonateEvent.getHandlerList() }
        }
    }
}
