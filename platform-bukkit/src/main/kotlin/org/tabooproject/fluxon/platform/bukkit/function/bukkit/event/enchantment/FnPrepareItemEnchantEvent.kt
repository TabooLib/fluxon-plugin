package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.enchantment

import org.bukkit.event.enchantment.PrepareItemEnchantEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPrepareItemEnchantEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareItemEnchantEvent::class.java)
                .function("enchanter", 0) { it.target?.enchanter }
                .function("enchantBlock", 0) { it.target?.enchantBlock }
                .function("item", 0) { it.target?.item }
                .function("expLevelCostsOffered", 0) { it.target?.expLevelCostsOffered }
                .function("offers", 0) { it.target?.offers }
                .function("enchantmentBonus", 0) { it.target?.enchantmentBonus }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PrepareItemEnchantEvent.getHandlerList() }
        }
    }
}
