package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.ItemCraftResult
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnItemCraftResult {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemCraftResult::class.java)
                .function("result", 0) { it.target?.result }
                .function("resultingMatrix", 0) { it.target?.resultingMatrix }
                .function("overflowItems", 0) { it.target?.overflowItems }
        }
    }
}
