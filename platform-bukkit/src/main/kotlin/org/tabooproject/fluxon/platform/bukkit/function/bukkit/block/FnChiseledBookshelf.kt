package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.ChiseledBookshelf
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnChiseledBookshelf {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChiseledBookshelf::class.java)
                .function("lastInteractedSlot", 0) { it.target?.lastInteractedSlot }
                .function("setLastInteractedSlot", 1) { it.target?.setLastInteractedSlot(it.getNumber(0).toInt()) }
                .function("inventory", 0) { it.target?.inventory }
                .function("snapshotInventory", 0) { it.target?.snapshotInventory }
                .function("slot", 1) { it.target?.getSlot(it.getArgument(0) as Vector) }
        }
    }
}
