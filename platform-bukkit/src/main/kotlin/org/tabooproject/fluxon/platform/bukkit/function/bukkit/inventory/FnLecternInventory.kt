package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.LecternInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLecternInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LecternInventory::class.java)
                .function("holder", 0) { it.target?.holder }
        }
    }
}
