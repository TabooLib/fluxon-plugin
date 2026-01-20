package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Lectern
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLectern {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lectern::class.java)
                .function("page", 0) { it.target?.page }
                .function("setPage", 1) { it.target?.setPage(it.getNumber(0).toInt()) }
                .function("inventory", 0) { it.target?.inventory }
                .function("snapshotInventory", 0) { it.target?.snapshotInventory }
        }
    }
}
