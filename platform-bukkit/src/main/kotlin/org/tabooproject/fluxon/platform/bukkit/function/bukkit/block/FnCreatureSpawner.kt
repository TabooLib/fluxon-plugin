package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.CreatureSpawner
import org.bukkit.block.spawner.SpawnRule
import org.bukkit.block.spawner.SpawnerEntry
import org.bukkit.entity.EntitySnapshot
import org.bukkit.entity.EntityType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCreatureSpawner {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CreatureSpawner::class.java)
                .function("spawnedType", 0) { it.target?.spawnedType }
                .function("setSpawnedType", 1) { it.target?.setSpawnedType(it.getArgument(0) as EntityType) }
                .function("setCreatureTypeByName", 1) { it.target?.setCreatureTypeByName(it.getString(0)) }
                .function("creatureTypeName", 0) { it.target?.creatureTypeName }
                .function("delay", 0) { it.target?.delay }
                .function("setDelay", 1) { it.target?.setDelay(it.getNumber(0).toInt()) }
                .function("minSpawnDelay", 0) { it.target?.minSpawnDelay }
                .function("setMinSpawnDelay", 1) { it.target?.setMinSpawnDelay(it.getNumber(0).toInt()) }
                .function("maxSpawnDelay", 0) { it.target?.maxSpawnDelay }
                .function("setMaxSpawnDelay", 1) { it.target?.setMaxSpawnDelay(it.getNumber(0).toInt()) }
                .function("spawnCount", 0) { it.target?.spawnCount }
                .function("setSpawnCount", 1) { it.target?.setSpawnCount(it.getNumber(0).toInt()) }
                .function("maxNearbyEntities", 0) { it.target?.maxNearbyEntities }
                .function("setMaxNearbyEntities", 1) { it.target?.setMaxNearbyEntities(it.getNumber(0).toInt()) }
                .function("requiredPlayerRange", 0) { it.target?.requiredPlayerRange }
                .function("setRequiredPlayerRange", 1) { it.target?.setRequiredPlayerRange(it.getNumber(0).toInt()) }
                .function("spawnRange", 0) { it.target?.spawnRange }
                .function("setSpawnRange", 1) { it.target?.setSpawnRange(it.getNumber(0).toInt()) }
                .function("spawnedEntity", 0) { it.target?.spawnedEntity }
                .function("setSpawnedEntity", 1) { it.target?.setSpawnedEntity(it.getArgument(0) as EntitySnapshot) }
                .function("addPotentialSpawn", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        it.target?.addPotentialSpawn(it.getArgument(0) as SpawnerEntry)
                    } else {
                        it.target?.addPotentialSpawn(
                            it.getArgument(0) as EntitySnapshot,
                            it.getNumber(1).toInt(),
                            it.getArgument(2) as SpawnRule
                        )
                    }
                }
                .function(
                    "setPotentialSpawns",
                    1
                ) { it.target?.setPotentialSpawns(it.getArgument(0) as Collection<SpawnerEntry>) }
                .function("potentialSpawns", 0) { it.target?.potentialSpawns }
        }
    }
}
