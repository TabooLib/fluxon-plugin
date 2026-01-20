package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.spawner

import org.bukkit.block.spawner.SpawnRule
import org.bukkit.block.spawner.SpawnerEntry
import org.bukkit.entity.EntitySnapshot
import org.bukkit.loot.LootTable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSpawnerEntry {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnerEntry::class.java)
                .function("snapshot", 0) { it.target?.snapshot }
                .function("setSnapshot", 1) { it.target?.setSnapshot(it.getArgument(0) as EntitySnapshot) }
                .function("spawnWeight", 0) { it.target?.spawnWeight }
                .function("setSpawnWeight", 1) { it.target?.setSpawnWeight(it.getNumber(0).toInt()) }
                .function("spawnRule", 0) { it.target?.spawnRule }
                .function("setSpawnRule", 1) { it.target?.setSpawnRule(it.getArgument(0) as SpawnRule) }
                .function("equipment", 0) { it.target?.equipment }
                .function("setEquipment", 1) { it.target?.setEquipment(it.getArgument(0) as SpawnerEntry.Equipment) }

            registerExtension(SpawnerEntry.Equipment::class.java)
                .function("equipmentLootTable", 0) { it.target?.equipmentLootTable }
                .function(
                    "setEquipmentLootTable",
                    1
                ) { it.target?.setEquipmentLootTable(it.getArgument(0) as LootTable) }
        }
    }
}
