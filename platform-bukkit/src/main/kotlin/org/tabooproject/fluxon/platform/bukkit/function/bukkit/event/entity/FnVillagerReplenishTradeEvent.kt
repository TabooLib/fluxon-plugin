package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.VillagerReplenishTradeEvent
import org.bukkit.inventory.MerchantRecipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnVillagerReplenishTradeEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VillagerReplenishTradeEvent::class.java)
                .function("recipe", 0) { it.target?.recipe }
                .function("setRecipe", 1) { it.target?.setRecipe(it.getArgument(0) as MerchantRecipe) }
                .function("bonus", 0) { it.target?.bonus }
                .function("setBonus", 1) { it.target?.setBonus(it.getNumber(0).toInt()) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("entity", 0) { it.target?.getEntity() }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { VillagerReplenishTradeEvent.getHandlerList() }
        }
    }
}
