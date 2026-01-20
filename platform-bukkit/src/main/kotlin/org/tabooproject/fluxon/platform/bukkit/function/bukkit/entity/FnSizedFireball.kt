package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.SizedFireball
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSizedFireball {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SizedFireball::class.java)
                .function("displayItem", 0) { it.target?.displayItem }
                .function("setDisplayItem", 1) { it.target?.setDisplayItem(it.getArgument(0) as ItemStack) }
        }
    }
}
