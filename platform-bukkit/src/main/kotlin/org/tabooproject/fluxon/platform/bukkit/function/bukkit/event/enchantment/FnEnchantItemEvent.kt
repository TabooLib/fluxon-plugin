package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.enchantment

import org.bukkit.event.enchantment.EnchantItemEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.enchantment.EnchantItemEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantItemEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantItemEvent::class.java)
                .function("enchanter", 0) { it.target?.enchanter }
                .function("enchantBlock", 0) { it.target?.enchantBlock }
                .function("item", 0) { it.target?.item }
                .function("expLevelCost", 0) { it.target?.expLevelCost }
                .function("setExpLevelCost", 1) { it.target?.setExpLevelCost(it.getNumber(0).toInt()) }
                .function("enchantmentHint", 0) { it.target?.enchantmentHint }
                .function("levelHint", 0) { it.target?.levelHint }
                .function("whichButton", 0) { it.target?.whichButton() }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EnchantItemEvent.getHandlerList() }
        }
    }
}
