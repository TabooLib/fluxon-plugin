package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnInventoryType {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryType::class.java)
                .function("defaultSize", 0) { it.target?.defaultSize }
                .function("defaultTitle", 0) { it.target?.defaultTitle }
                .function("isCreatable", 0) { it.target?.isCreatable }
        }
    }
}
