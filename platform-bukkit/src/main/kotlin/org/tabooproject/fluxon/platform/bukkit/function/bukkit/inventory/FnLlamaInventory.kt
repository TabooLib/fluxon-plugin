package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.LlamaInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLlamaInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LlamaInventory::class.java)
                .function("decor", 0) { it.target?.decor }
                .function("setDecor", 1) { it.target?.setDecor(it.getArgument(0) as ItemStack) }
        }
    }
}
