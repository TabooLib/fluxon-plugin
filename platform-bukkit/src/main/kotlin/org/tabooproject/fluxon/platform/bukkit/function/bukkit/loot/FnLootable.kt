package org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot

import org.bukkit.loot.LootTable
import org.bukkit.loot.Lootable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLootable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lootable::class.java)
                .function("setLootTable", 1) { it.target?.setLootTable(it.getArgument(0) as LootTable) }
                .function("lootTable", 0) { it.target?.lootTable }
                .function("setSeed", 1) { it.target?.setSeed(it.getNumber(0).toLong()) }
                .function("seed", 0) { it.target?.seed }
        }
    }
}
