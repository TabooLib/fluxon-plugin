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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.spawner.SpawnerEntry"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnerEntry {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnerEntry::class.java)
                .function("snapshot", returnsObject().noParams()) { it.setReturnRef(it.target?.snapshot) }
                .function("setSnapshot", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSnapshot(it.getRef(0) as EntitySnapshot)) }
                .function("spawnWeight", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnWeight) }
                .function("setSpawnWeight", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSpawnWeight(it.getInt(0).toInt())) }
                .function("spawnRule", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnRule) }
                .function("setSpawnRule", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSpawnRule(it.getRef(0) as SpawnRule)) }
                .function("equipment", returnsObject().noParams()) { it.setReturnRef(it.target?.equipment) }
                .function("setEquipment", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setEquipment(it.getRef(0) as SpawnerEntry.Equipment)) }
        }
    }
}

@Requires(classes = ["org.bukkit.block.spawner.SpawnerEntry.Equipment"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnerEntryEquipment {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnerEntry.Equipment::class.java)
                .function("equipmentLootTable", returnsObject().noParams()) { it.setReturnRef(it.target?.equipmentLootTable) }
                .function("setEquipmentLootTable", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setEquipmentLootTable(it.getRef(0) as LootTable)) }
        }
    }
}
