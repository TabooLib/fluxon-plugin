package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.CrossbowMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCrossbowMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CrossbowMeta::class.java)
                .function("hasChargedProjectiles", 0) { it.target?.hasChargedProjectiles() }
                .function("chargedProjectiles", 0) { it.target?.chargedProjectiles }
                .function(
                    "setChargedProjectiles",
                    1
                ) { it.target?.setChargedProjectiles(it.getArgument(0) as List<ItemStack>) }
                .function("addChargedProjectile", 1) { it.target?.addChargedProjectile(it.getArgument(0) as ItemStack) }
        }
    }
}
