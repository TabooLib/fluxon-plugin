package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.EnchantingInventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.inventory.EnchantingInventory"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantingInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantingInventory::class.java)
                .function("setItem", 1) { it.target?.setItem(it.getArgument(0) as ItemStack) }
                .function("item", 0) { it.target?.item }
                .function("setSecondary", 1) { it.target?.setSecondary(it.getArgument(0) as ItemStack) }
                .function("secondary", 0) { it.target?.secondary }
        }
    }
}
