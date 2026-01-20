package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.JukeboxInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnJukeboxInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(JukeboxInventory::class.java)
                .function("setRecord", 1) { it.target?.setRecord(it.getArgument(0) as ItemStack) }
                .function("record", 0) { it.target?.record }
                .function("holder", 0) { it.target?.holder }
        }
    }
}
