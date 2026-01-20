package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Chest
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnChest {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Chest::class.java)
                .function("blockInventory", 0) { it.target?.blockInventory }
        }
    }
}
