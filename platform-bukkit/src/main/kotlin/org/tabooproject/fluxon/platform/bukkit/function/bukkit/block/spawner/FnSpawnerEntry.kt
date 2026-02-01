package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.spawner

import org.bukkit.block.spawner.SpawnRule
import org.bukkit.block.spawner.SpawnerEntry
import org.bukkit.entity.EntitySnapshot
import org.bukkit.loot.LootTable
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntitySnapshot
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot.FnLootTable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.spawner.SpawnerEntry"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnerEntry {

    val TYPE = Type.fromClass(SpawnerEntry::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnerEntry::class.java)
                .function("snapshot", returns(FnEntitySnapshot.TYPE).noParams()) { it.setReturnRef(it.target?.snapshot) }
                .function("setSnapshot", returnsVoid().params(FnEntitySnapshot.TYPE)) { it.target?.setSnapshot(it.getRef(0) as EntitySnapshot) }
                .function("spawnWeight", returns(Type.I).noParams()) { it.setReturnInt(it.target?.spawnWeight ?: 0) }
                .function("setSpawnWeight", returnsVoid().params(Type.I)) { it.target?.setSpawnWeight(it.getInt(0).toInt()) }
                .function("spawnRule", returns(FnSpawnRule.TYPE).noParams()) { it.setReturnRef(it.target?.spawnRule) }
                .function("setSpawnRule", returnsVoid().params(FnSpawnRule.TYPE)) { it.target?.setSpawnRule(it.getRef(0) as SpawnRule) }
                .function("equipment", returns(FnSpawnerEntryEquipment.TYPE).noParams()) { it.setReturnRef(it.target?.equipment) }
                .function("setEquipment", returnsVoid().params(FnSpawnerEntryEquipment.TYPE)) { it.target?.setEquipment(it.getRef(0) as SpawnerEntry.Equipment) }
        }
    }
}

@Requires(classes = ["org.bukkit.block.spawner.SpawnerEntry.Equipment"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnerEntryEquipment {

    val TYPE = Type.fromClass(SpawnerEntry.Equipment::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnerEntry.Equipment::class.java)
                .function("equipmentLootTable", returns(FnLootTable.TYPE).noParams()) { it.setReturnRef(it.target?.equipmentLootTable) }
                .function("setEquipmentLootTable", returnsVoid().params(FnLootTable.TYPE)) { it.target?.setEquipmentLootTable(it.getRef(0) as LootTable) }
        }
    }
}
