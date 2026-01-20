package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Material
import org.bukkit.block.Jukebox
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnJukebox {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Jukebox::class.java)
                .function("playing", 0) { it.target?.playing }
                .function("setPlaying", 1) { it.target?.setPlaying(it.getArgument(0) as Material) }
                .function("hasRecord", 0) { it.target?.hasRecord() }
                .function("record", 0) { it.target?.record }
                .function("setRecord", 1) { it.target?.setRecord(it.getArgument(0) as ItemStack) }
                .function("isPlaying", 0) { it.target?.isPlaying }
                .function("startPlaying", 0) { it.target?.startPlaying() }
                .function("stopPlaying", 0) { it.target?.stopPlaying() }
                .function("eject", 0) { it.target?.eject() }
                .function("inventory", 0) { it.target?.inventory }
                .function("snapshotInventory", 0) { it.target?.snapshotInventory }
        }
    }
}
