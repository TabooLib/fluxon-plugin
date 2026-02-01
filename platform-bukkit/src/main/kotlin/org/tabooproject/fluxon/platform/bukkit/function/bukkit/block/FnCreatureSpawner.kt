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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.CreatureSpawner"])
@PlatformSide(Platform.BUKKIT)
object FnCreatureSpawner {

    val TYPE = Type.fromClass(CreatureSpawner::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CreatureSpawner::class.java)
                .function("spawnedType", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnedType) }
                .function("setSpawnedType", returnsVoid().params(Type.OBJECT)) { it.target?.setSpawnedType(it.getRef(0) as EntityType) }
                .function("setCreatureTypeByName", returnsVoid().params(Type.STRING)) { it.target?.setCreatureTypeByName(it.getString(0)) }
                .function("creatureTypeName", returnsObject().noParams()) { it.setReturnRef(it.target?.creatureTypeName) }
                .function("delay", returns(Type.I).noParams()) { it.setReturnInt(it.target?.delay ?: 0) }
                .function("setDelay", returnsVoid().params(Type.I)) { it.target?.setDelay(it.getInt(0).toInt()) }
                .function("minSpawnDelay", returns(Type.I).noParams()) { it.setReturnInt(it.target?.minSpawnDelay ?: 0) }
                .function("setMinSpawnDelay", returnsVoid().params(Type.I)) { it.target?.setMinSpawnDelay(it.getInt(0).toInt()) }
                .function("maxSpawnDelay", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxSpawnDelay ?: 0) }
                .function("setMaxSpawnDelay", returnsVoid().params(Type.I)) { it.target?.setMaxSpawnDelay(it.getInt(0).toInt()) }
                .function("spawnCount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.spawnCount ?: 0) }
                .function("setSpawnCount", returnsVoid().params(Type.I)) { it.target?.setSpawnCount(it.getInt(0).toInt()) }
                .function("maxNearbyEntities", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxNearbyEntities ?: 0) }
                .function("setMaxNearbyEntities", returnsVoid().params(Type.I)) { it.target?.setMaxNearbyEntities(it.getInt(0).toInt()) }
                .function("requiredPlayerRange", returns(Type.I).noParams()) { it.setReturnInt(it.target?.requiredPlayerRange ?: 0) }
                .function("setRequiredPlayerRange", returnsVoid().params(Type.I)) { it.target?.setRequiredPlayerRange(it.getInt(0).toInt()) }
                .function("spawnRange", returns(Type.I).noParams()) { it.setReturnInt(it.target?.spawnRange ?: 0) }
                .function("setSpawnRange", returnsVoid().params(Type.I)) { it.target?.setSpawnRange(it.getInt(0).toInt()) }
                .function("spawnedEntity", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnedEntity) }
                .function("setSpawnedEntity", returnsVoid().params(Type.OBJECT)) { it.target?.setSpawnedEntity(it.getRef(0) as EntitySnapshot) }
                .function("addPotentialSpawn", returnsVoid().params(Type.OBJECT)) {
                    it.target?.addPotentialSpawn(it.getRef(0) as SpawnerEntry)
                }
                .function("addPotentialSpawn", returnsVoid().params(Type.OBJECT, Type.I, Type.OBJECT)) {
                    it.target?.addPotentialSpawn(
                        it.getRef(0) as EntitySnapshot,
                        it.getInt(1).toInt(),
                        it.getRef(2) as SpawnRule
                    )
                }
                .function("setPotentialSpawns", returnsVoid().params(Type.OBJECT)) { it.target?.setPotentialSpawns(it.getRef(0) as Collection<SpawnerEntry>) }
                .function("potentialSpawns", returnsObject().noParams()) { it.setReturnRef(it.target?.potentialSpawns) }
        }
    }
}
