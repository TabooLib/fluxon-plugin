package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.ChiseledBookshelf
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnChiseledBookshelf {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChiseledBookshelf::class.java)
                .function("isSlotOccupied", 1) { it.target?.isSlotOccupied(it.getNumber(0).toInt()) }
                .function("setSlotOccupied", 2) {
                    it.target?.setSlotOccupied(
                        it.getNumber(0).toInt(),
                        it.getBoolean(1)
                    )
                }
                .function("occupiedSlots", 0) { it.target?.occupiedSlots }
                .function("maximumOccupiedSlots", 0) { it.target?.maximumOccupiedSlots }
        }
    }
}
