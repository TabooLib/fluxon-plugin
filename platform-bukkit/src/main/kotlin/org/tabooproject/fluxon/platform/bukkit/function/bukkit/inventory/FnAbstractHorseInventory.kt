package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.AbstractHorseInventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAbstractHorseInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractHorseInventory::class.java)
                .function("saddle", 0) { it.target?.saddle }
                .function("setSaddle", 1) { it.target?.setSaddle(it.getArgument(0) as ItemStack) }
        }
    }
}
