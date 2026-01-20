package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerSwapHandItemsEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerSwapHandItemsEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerSwapHandItemsEvent::class.java)
                .function("mainHandItem", 0) { it.target?.mainHandItem }
                .function("setMainHandItem", 1) { it.target?.setMainHandItem(it.getArgument(0) as ItemStack) }
                .function("offHandItem", 0) { it.target?.offHandItem }
                .function("setOffHandItem", 1) { it.target?.setOffHandItem(it.getArgument(0) as ItemStack) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerSwapHandItemsEvent.getHandlerList() }
        }
    }
}
