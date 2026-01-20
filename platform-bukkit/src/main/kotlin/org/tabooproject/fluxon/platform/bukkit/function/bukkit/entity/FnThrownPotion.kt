package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ThrownPotion
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnThrownPotion {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ThrownPotion::class.java)
                .function("effects", 0) { it.target?.effects }
                .function("item", 0) { it.target?.item }
                .function("setItem", 1) { it.target?.setItem(it.getArgument(0) as ItemStack) }
        }
    }
}
