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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.CreatureSpawner"])
@PlatformSide(Platform.BUKKIT)
object FnCreatureSpawner {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CreatureSpawner::class.java)
                .function("spawnedType", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnedType) }
                .function("setSpawnedType", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSpawnedType(it.getRef(0) as EntityType)) }
                .function("setCreatureTypeByName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCreatureTypeByName(it.getString(0))) }
                .function("creatureTypeName", returnsObject().noParams()) { it.setReturnRef(it.target?.creatureTypeName) }
                .function("delay", returnsObject().noParams()) { it.setReturnRef(it.target?.delay) }
                .function("setDelay", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDelay(it.getInt(0).toInt())) }
                .function("minSpawnDelay", returnsObject().noParams()) { it.setReturnRef(it.target?.minSpawnDelay) }
                .function("setMinSpawnDelay", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMinSpawnDelay(it.getInt(0).toInt())) }
                .function("maxSpawnDelay", returnsObject().noParams()) { it.setReturnRef(it.target?.maxSpawnDelay) }
                .function("setMaxSpawnDelay", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaxSpawnDelay(it.getInt(0).toInt())) }
                .function("spawnCount", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnCount) }
                .function("setSpawnCount", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSpawnCount(it.getInt(0).toInt())) }
                .function("maxNearbyEntities", returnsObject().noParams()) { it.setReturnRef(it.target?.maxNearbyEntities) }
                .function("setMaxNearbyEntities", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaxNearbyEntities(it.getInt(0).toInt())) }
                .function("requiredPlayerRange", returnsObject().noParams()) { it.setReturnRef(it.target?.requiredPlayerRange) }
                .function("setRequiredPlayerRange", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRequiredPlayerRange(it.getInt(0).toInt())) }
                .function("spawnRange", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnRange) }
                .function("setSpawnRange", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSpawnRange(it.getInt(0).toInt())) }
                .function("spawnedEntity", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnedEntity) }
                .function("setSpawnedEntity", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSpawnedEntity(it.getRef(0) as EntitySnapshot)) }
                .function("addPotentialSpawn", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.addPotentialSpawn(it.getRef(0) as SpawnerEntry)
                    } else {
                        it.target?.addPotentialSpawn(
                            it.getRef(0) as EntitySnapshot,
                            it.getInt(1).toInt(),
                            it.getRef(2) as SpawnRule
                        )
                    })
                }
                .function("addPotentialSpawn", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.addPotentialSpawn(it.getRef(0) as SpawnerEntry)
                    } else {
                        it.target?.addPotentialSpawn(
                            it.getRef(0) as EntitySnapshot,
                            it.getInt(1).toInt(),
                            it.getRef(2) as SpawnRule
                        )
                    })
                }
                .function("setPotentialSpawns", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPotentialSpawns(it.getRef(0) as Collection<SpawnerEntry>)) }
                .function("potentialSpawns", returnsObject().noParams()) { it.setReturnRef(it.target?.potentialSpawns) }
        }
    }
}
