package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.LootGenerateEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLootGenerateEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LootGenerateEvent::class.java)
                .function("entity", 0) { it.target?.entity }
                .function("inventoryHolder", 0) { it.target?.inventoryHolder }
                .function("lootTable", 0) { it.target?.lootTable }
                .function("lootContext", 0) { it.target?.lootContext }
                .function("setLoot", 1) { it.target?.setLoot(it.getArgument(0) as Collection<ItemStack>) }
                .function("loot", 0) { it.target?.loot }
                .function("isPlugin", 0) { it.target?.isPlugin }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { LootGenerateEvent.getHandlerList() }
        }
    }
}
