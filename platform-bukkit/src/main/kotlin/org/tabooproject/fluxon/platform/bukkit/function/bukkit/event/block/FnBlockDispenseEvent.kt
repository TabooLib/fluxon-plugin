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
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDispenseEvent::class.java)
                .function("item", 0) { it.target?.item }
                .syncFunction("setItem", 1) { it.target?.apply { item = it.getArgument(0) as ItemStack } }
                .function("velocity", 0) { it.target?.velocity }
                .syncFunction("setVelocity", 1) { it.target?.apply { velocity = it.getArgument(0) as Vector } }
        }
    }
}
