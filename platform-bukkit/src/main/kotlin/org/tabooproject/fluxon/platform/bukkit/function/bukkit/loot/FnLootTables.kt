package org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot

import org.bukkit.loot.LootTables
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLootTables {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LootTables::class.java)
                .function("key", 0) { it.target?.key }
                .function("lootTable", 0) { it.target?.lootTable }
        }
    }
}
