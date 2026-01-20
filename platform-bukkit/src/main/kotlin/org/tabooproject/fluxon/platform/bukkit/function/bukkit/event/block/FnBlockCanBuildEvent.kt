package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockCanBuildEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnBlockCanBuildEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockCanBuildEvent::class.java)
                .function("isBuildable", 0) { it.target?.isBuildable }
                .function("setBuildable", 1) { it.target?.setBuildable(it.getBoolean(0)) }
                .function("material", 0) { it.target?.material }
                .function("blockData", 0) { it.target?.blockData }
                .function("player", 0) { it.target?.player }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BlockCanBuildEvent.getHandlerList() }
        }
    }
}
