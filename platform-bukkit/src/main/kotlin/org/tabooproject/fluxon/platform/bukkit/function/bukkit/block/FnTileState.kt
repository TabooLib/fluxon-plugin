package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.TileState
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnTileState {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TileState::class.java)
                .function("persistentDataContainer", 0) { it.target?.persistentDataContainer }
        }
    }
}
