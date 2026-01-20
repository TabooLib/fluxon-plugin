package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Furnace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnFurnace {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Furnace::class.java)
                .function("burnTime", 0) { it.target?.burnTime }
                .function("setBurnTime", 1) { it.target?.setBurnTime(it.getNumber(0).toShort()) }
                .function("cookTime", 0) { it.target?.cookTime }
                .function("setCookTime", 1) { it.target?.setCookTime(it.getNumber(0).toShort()) }
                .function("cookTimeTotal", 0) { it.target?.cookTimeTotal }
                .function("setCookTimeTotal", 1) { it.target?.setCookTimeTotal(it.getNumber(0).toInt()) }
                .function("inventory", 0) { it.target?.inventory }
                .function("snapshotInventory", 0) { it.target?.snapshotInventory }
        }
    }
}
