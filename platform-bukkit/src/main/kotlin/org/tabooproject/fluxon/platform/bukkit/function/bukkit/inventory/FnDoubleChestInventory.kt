package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.DoubleChestInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnDoubleChestInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DoubleChestInventory::class.java)
                .function("leftSide", 0) { it.target?.leftSide }
                .function("rightSide", 0) { it.target?.rightSide }
                .function("holder", 0) { it.target?.holder }
        }
    }
}
