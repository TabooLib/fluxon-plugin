package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockMultiPlaceEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.block.BlockMultiPlaceEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockMultiPlaceEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockMultiPlaceEvent::class.java)
                .function("replacedBlockStates", 0) { it.target?.replacedBlockStates }
        }
    }
}
