package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.FurnaceExtractEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnFurnaceExtractEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceExtractEvent::class.java)
                .function("player", 0) { it.target?.player }
                .function("itemType", 0) { it.target?.itemType }
                .function("itemAmount", 0) { it.target?.itemAmount }
        }
    }
}
