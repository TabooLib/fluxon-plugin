package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockDispenseEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnBlockDispenseEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDispenseEvent::class.java)
                .function("item", 0) { it.target?.item }
                .function("setItem", 1) { it.target?.setItem(it.getArgument(0) as ItemStack) }
                .function("velocity", 0) { it.target?.velocity }
                .function("setVelocity", 1) { it.target?.setVelocity(it.getArgument(0) as Vector) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { BlockDispenseEvent.getHandlerList() }
        }
    }
}
