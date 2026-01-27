package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.HorseJumpEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.entity.HorseJumpEvent"])
@PlatformSide(Platform.BUKKIT)
object FnHorseJumpEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HorseJumpEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("entity", 0) { it.target?.getEntity() }
                .function("power", 0) { it.target?.power }
                .function("setPower", 1) { it.target?.setPower(it.getNumber(0).toFloat()) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { HorseJumpEvent.getHandlerList() }
        }
    }
}
