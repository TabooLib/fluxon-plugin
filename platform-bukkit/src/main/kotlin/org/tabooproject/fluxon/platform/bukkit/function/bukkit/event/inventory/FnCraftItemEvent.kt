package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.CraftItemEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCraftItemEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CraftItemEvent::class.java)
                .function("recipe", 0) { it.target?.recipe }
                .function("inventory", 0) { it.target?.inventory }
        }
    }
}
