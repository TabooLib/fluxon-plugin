package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ItemDisplay
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnItemDisplay {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemDisplay::class.java)
                .function("itemStack", 0) { it.target?.itemStack }
                .function("setItemStack", 1) { it.target?.setItemStack(it.getArgument(0) as ItemStack) }
                .function("itemDisplayTransform", 0) { it.target?.itemDisplayTransform }
                .function(
                    "setItemDisplayTransform",
                    1
                ) { it.target?.setItemDisplayTransform(it.getArgument(0) as ItemDisplay.ItemDisplayTransform) }
        }
    }
}
