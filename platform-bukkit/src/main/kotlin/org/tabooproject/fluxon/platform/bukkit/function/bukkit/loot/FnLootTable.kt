package org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot

import org.bukkit.inventory.Inventory
import org.bukkit.loot.LootContext
import org.bukkit.loot.LootTable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLootTable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LootTable::class.java)
                .function("populateLoot", 2) {
                    it.target?.populateLoot(
                        it.getArgument(0) as Random,
                        it.getArgument(1) as LootContext
                    )
                }
                .function("fillInventory", 3) {
                    it.target?.fillInventory(
                        it.getArgument(0) as Inventory,
                        it.getArgument(1) as Random,
                        it.getArgument(2) as LootContext
                    )
                }
        }
    }
}
