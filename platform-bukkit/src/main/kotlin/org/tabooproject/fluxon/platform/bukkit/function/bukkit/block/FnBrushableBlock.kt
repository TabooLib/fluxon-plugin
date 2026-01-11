package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.BrushableBlock
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBrushableBlock {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrushableBlock::class.java)
                .function("item", 0) { it.target?.item }
                .function("setItem", 1) { it.target?.setItem(it.getArgument(0) as ItemStack) }
        }
    }
}
