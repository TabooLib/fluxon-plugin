package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.SmithingInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSmithingInventory {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SmithingInventory::class.java)
                .function("result", 0) { it.target?.result }
                .function("setResult", 1) { it.target?.setResult(it.getArgument(0) as ItemStack) }
                .function("recipe", 0) { it.target?.recipe }
        }
    }
}
