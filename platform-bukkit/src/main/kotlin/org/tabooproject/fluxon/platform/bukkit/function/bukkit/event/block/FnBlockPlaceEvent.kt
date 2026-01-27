package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockPlaceEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.block.BlockPlaceEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockPlaceEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPlaceEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("player", 0) { it.target?.getPlayer() }
                .function("blockPlaced", 0) { it.target?.blockPlaced }
                .function("blockReplacedState", 0) { it.target?.blockReplacedState }
                .function("blockAgainst", 0) { it.target?.blockAgainst }
                .function("itemInHand", 0) { it.target?.getItemInHand() }
                .function("hand", 0) { it.target?.getHand() }
                .function("canBuild", 0) { it.target?.canBuild() }
                .function("setBuild", 1) { it.target?.setBuild(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BlockPlaceEvent.getHandlerList() }
        }
    }
}
