package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerItemMendEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnPlayerItemMendEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerItemMendEvent::class.java)
                .function("item", 0) { it.target?.item }
                .function("slot", 0) { it.target?.slot }
                .function("experienceOrb", 0) { it.target?.experienceOrb }
                .function("repairAmount", 0) { it.target?.repairAmount }
                .function("setRepairAmount", 1) { it.target?.setRepairAmount(it.getNumber(0).toInt()) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerItemMendEvent.getHandlerList() }
        }
    }
}
