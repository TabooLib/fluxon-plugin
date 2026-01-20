package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BundleMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBundleMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BundleMeta::class.java)
                .function("hasItems", 0) { it.target?.hasItems() }
                .function("items", 0) { it.target?.items }
                .function("setItems", 1) { it.target?.setItems(it.getArgument(0) as List<ItemStack>) }
                .function("addItem", 1) { it.target?.addItem(it.getArgument(0) as ItemStack) }
        }
    }
}
