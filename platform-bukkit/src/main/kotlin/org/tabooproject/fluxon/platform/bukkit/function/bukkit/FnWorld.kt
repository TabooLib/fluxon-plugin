package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.*
import org.bukkit.block.Biome
import org.bukkit.block.Block
import org.bukkit.block.data.BlockData
import org.bukkit.entity.Entity
import org.bukkit.entity.SpawnCategory
import org.bukkit.generator.structure.Structure
import org.bukkit.generator.structure.StructureType
import org.bukkit.inventory.ItemStack
import org.bukkit.material.MaterialData
import org.bukkit.plugin.Plugin
import org.bukkit.util.BoundingBox
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnWorld {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("world", 1) {
                when (val id = it.getArgument(0)) {
                    is UUID -> Bukkit.getWorld(id)
                    is String -> Bukkit.getWorld(id)
                    else -> null
                }
            }
            registerFunction("worlds", 0) { Bukkit.getWorlds() }

            registerExtension(World::class.java)
                .function("getBlockAt", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        it.target?.getBlockAt(it.getArgument(0) as Location)
                    } else {
                        it.target?.getBlockAt(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                .syncFunction("getHighestBlockAt", listOf(1, 2, 3)) {
                    when (it.arguments.size) {
                        1 -> it.target?.getHighestBlockAt(it.getArgument(0) as Location)
                        2 -> when (val var1 = it.getArgument(0)) {
                            is Int -> it.target?.getHighestBlockAt(var1, it.getNumber(1).toInt())
                            is Location -> it.target?.getHighestBlockAt(var1, it.getArgument(1) as HeightMap)
                            else -> throw IllegalArgumentException("参数必须是 Int 或 Location 类型")
                        }

                        3 -> it.target?.getHighestBlockAt(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getArgument(2) as HeightMap
                        )
                        else -> error("World#highestBlockAt 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .syncFunction("getChunkAt", listOf(1, 2, 3)) {
                    when (it.arguments.size) {
                        1 -> when (val var1 = it.getArgument(0)) {
                            is Location -> it.target?.getChunkAt(var1)
                            is Block -> it.target?.getChunkAt(var1)
                            else -> throw IllegalArgumentException("参数必须是 Location 或 Block 类型")
                        }

                        2 -> it.target?.getChunkAt(it.getNumber(0).toInt(), it.getNumber(1).toInt())
                        3 -> it.target?.getChunkAt(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getBoolean(2)
                        )
                        else -> error("World#chunkAt 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("isChunkLoaded", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.isChunkLoaded(it.getArgument(0) as Chunk)
                    } else {
                        it.target?.isChunkLoaded(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt()
                        )
                    }
                }
                .function("loadedChunks", 0) { it.target?.loadedChunks }
                .syncFunction("loadChunk", listOf(1, 2, 3)) {
                    when (it.arguments.size) {
                        1 -> it.target?.loadChunk(it.getArgument(0) as Chunk)
                        2 -> it.target?.loadChunk(it.getNumber(0).toInt(), it.getNumber(1).toInt())
                        3 -> it.target?.loadChunk(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getBoolean(2)
                        )
                        else -> error("World#loadChunk 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("isChunkGenerated", 2) {
                    it.target?.isChunkGenerated(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("isChunkInUse", 2) {
                    it.target?.isChunkInUse(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .syncFunction("unloadChunk", listOf(1, 2, 3)) {
                    when (it.arguments.size) {
                        1 -> it.target?.unloadChunk(it.getArgument(0) as Chunk)
                        2 -> it.target?.unloadChunk(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt()
                        )

                        3 -> it.target?.unloadChunk(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getBoolean(2)
                        )
                        else -> error("World#unloadChunk 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .syncFunction("unloadChunkRequest", 2) {
                    it.target?.unloadChunkRequest(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("regenerateChunk", 2) {
                    it.target?.regenerateChunk(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("refreshChunk", 2) {
                    it.target?.refreshChunk(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("getPlayersSeeingChunk", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.getPlayersSeeingChunk(it.getArgument(0) as Chunk)
                    } else {
                        it.target?.getPlayersSeeingChunk(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt()
                        )
                    }
                }
                .function("isChunkForceLoaded", 2) {
                    it.target?.isChunkForceLoaded(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("setChunkForceLoaded", 3) {
                    it.target?.setChunkForceLoaded(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getBoolean(2)
                    )
                }
                .function("forceLoadedChunks", 0) { it.target?.forceLoadedChunks }
                .function("addPluginChunkTicket", 3) {
                    it.target?.addPluginChunkTicket(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getArgument(2) as Plugin
                    )
                }
                .function("removePluginChunkTicket", 3) {
                    it.target?.removePluginChunkTicket(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getArgument(2) as Plugin
                    )
                }
                .function(
                    "removePluginChunkTickets",
                    1
                ) { it.target?.removePluginChunkTickets(it.getArgument(0) as Plugin) }
                .function("pluginChunkTickets", 0) { it.target?.pluginChunkTickets }
                .function("getPluginChunkTickets", 2) {
                    it.target?.getPluginChunkTickets(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function(
                    "getIntersectingChunks",
                    1
                ) { it.target?.getIntersectingChunks(it.getArgument(0) as BoundingBox) }
                .syncFunction("dropItem", 2) {
                    it.target?.dropItem(it.getArgument(0) as Location, it.getArgument(1) as ItemStack)
                }
                .syncFunction("dropItemNaturally", 2) {
                    it.target?.dropItemNaturally(it.getArgument(0) as Location, it.getArgument(1) as ItemStack)
                }
                .syncFunction("spawnArrow", 4) {
                    it.target?.spawnArrow(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Vector,
                        it.getNumber(2).toFloat(),
                        it.getNumber(3).toFloat()
                    )
                }
                .syncFunction("generateTree", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.generateTree(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as TreeType
                        )
                    } else {
                        it.target?.generateTree(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as TreeType,
                            it.getArgument(2) as BlockChangeDelegate
                        )
                    }
                }
                .syncFunction("strikeLightning", 1) { it.target?.strikeLightning(it.getArgument(0) as Location) }
                .syncFunction(
                    "strikeLightningEffect",
                    1
                ) { it.target?.strikeLightningEffect(it.getArgument(0) as Location) }
                .syncFunction("entities", 0) { it.target?.entities }
                .syncFunction("livingEntities", 0) { it.target?.livingEntities }
                .syncFunction("entitiesByClasses", 0) { it.target?.getEntitiesByClasses() }
                .syncFunction("players", 0) { it.target?.players }
                .syncFunction("getNearbyEntities", listOf(1, 4)) {
                    if (it.arguments.size == 1) {
                        it.target?.getNearbyEntities(it.getArgument(0) as BoundingBox)
                    } else {
                        it.target?.getNearbyEntities(
                            it.getArgument(0) as Location,
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble()
                        )
                    }
                }
                .syncFunction("rayTraceEntities", listOf(3, 4)) {
                    if (it.arguments.size == 3) {
                        it.target?.rayTraceEntities(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Vector,
                            it.getNumber(2).toDouble()
                        )
                    } else {
                        it.target?.rayTraceEntities(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Vector,
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble()
                        )
                    }
                }
                .function("rayTraceBlocks", listOf(3, 4, 5)) {
                    when (it.arguments.size) {
                        3 -> it.target?.rayTraceBlocks(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Vector,
                            it.getNumber(2).toDouble()
                        )

                        4 -> it.target?.rayTraceBlocks(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Vector,
                            it.getNumber(2).toDouble(),
                            it.getArgument(3) as FluidCollisionMode
                        )

                        5 -> it.target?.rayTraceBlocks(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Vector,
                            it.getNumber(2).toDouble(),
                            it.getArgument(3) as FluidCollisionMode,
                            it.getBoolean(4)
                        )
                        else -> error("World#rayTraceBlocks 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
//                .function("rayTrace", 7) {
//                    it.target?.rayTrace(
//                        it.getArgument(0) as Location,
//                        it.getArgument(1) as Vector,
//                        it.getNumber(2).toDouble(),
//                        it.getArgument(3) as FluidCollisionMode,
//                        it.getBoolean(4),
//                        it.getNumber(5).toDouble(),
//                        it.getArgument(6) as Predicate<Entity>
//                    )
//                }
                .function("spawnLocation", 0) { it.target?.spawnLocation }
                .function("setSpawnLocation", listOf(1, 3, 4)) {
                    when (it.arguments.size) {
                        1 -> it.target?.setSpawnLocation(it.getArgument(0) as Location)
                        3 -> it.target?.setSpawnLocation(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )

                        4 -> it.target?.setSpawnLocation(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toFloat()
                        )
                        else -> error("World#setSpawnLocation 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("time", 0) { it.target?.time }
                .function("setTime", 1) { it.target?.setTime(it.getNumber(0).toLong()) }
                .function("fullTime", 0) { it.target?.fullTime }
                .function("setFullTime", 1) { it.target?.setFullTime(it.getNumber(0).toLong()) }
                .function("gameTime", 0) { it.target?.gameTime }
                .function("hasStorm", 0) { it.target?.hasStorm() }
                .function("setStorm", 1) { it.target?.setStorm(it.getBoolean(0)) }
                .function("weatherDuration", 0) { it.target?.weatherDuration }
                .function("setWeatherDuration", 1) { it.target?.setWeatherDuration(it.getNumber(0).toInt()) }
                .function("isThundering", 0) { it.target?.isThundering }
                .function("setThundering", 1) { it.target?.setThundering(it.getBoolean(0)) }
                .function("thunderDuration", 0) { it.target?.thunderDuration }
                .function("setThunderDuration", 1) { it.target?.setThunderDuration(it.getNumber(0).toInt()) }
                .function("isClearWeather", 0) { it.target?.isClearWeather }
                .function("setClearWeatherDuration", 1) { it.target?.setClearWeatherDuration(it.getNumber(0).toInt()) }
                .function("clearWeatherDuration", 0) { it.target?.clearWeatherDuration }
                .syncFunction("createExplosion", listOf(2, 3, 4, 5, 6, 7)) {
                    when (it.arguments.size) {
                        2 -> it.target?.createExplosion(
                            it.getArgument(0) as Location,
                            it.getNumber(1).toFloat()
                        )

                        3 -> it.target?.createExplosion(
                            it.getArgument(0) as Location,
                            it.getNumber(1).toFloat(),
                            it.getBoolean(2)
                        )

                        4 -> when (val var1 = it.getArgument(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getNumber(1).toDouble(),
                                it.getNumber(2).toDouble(),
                                it.getNumber(3).toFloat()
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getNumber(1).toFloat(),
                                it.getBoolean(2),
                                it.getBoolean(3)
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        5 -> when (val var1 = it.getArgument(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getNumber(1).toDouble(),
                                it.getNumber(2).toDouble(),
                                it.getNumber(3).toFloat(),
                                it.getBoolean(4)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getNumber(1).toFloat(),
                                it.getBoolean(2),
                                it.getBoolean(3),
                                it.getArgument(4) as Entity?
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        6 -> it.target?.createExplosion(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toFloat(),
                            it.getBoolean(4),
                            it.getBoolean(5)
                        )

                        7 -> it.target?.createExplosion(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toFloat(),
                            it.getBoolean(4),
                            it.getBoolean(5),
                            it.getArgument(6) as Entity
                        )
                        else -> error("World#createExplosion 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("pvp", 0) { it.target?.pvp }
                .function("setPVP", 1) { it.target?.setPVP(it.getBoolean(0)) }
                .function("generator", 0) { it.target?.generator }
                .function("biomeProvider", 0) { it.target?.biomeProvider }
                .syncFunction("save", 0) { it.target?.save() }
                .function("populators", 0) { it.target?.populators }
                .syncFunction("spawnFallingBlock", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        when (val var2 = it.getArgument(1)) {
                            is MaterialData -> it.target?.spawnFallingBlock(it.getArgument(0) as Location, var2)
                            is BlockData -> it.target?.spawnFallingBlock(it.getArgument(0) as Location, var2)
                            else -> throw IllegalArgumentException("参数必须是 MaterialData 或 BlockData 类型")
                        }
                    } else {
                        it.target?.spawnFallingBlock(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Material,
                            it.getNumber(2).toByte()
                        )
                    }
                }
                .function("playEffect", listOf(3, 4)) {
                    if (it.arguments.size == 3) {
                        it.target?.playEffect(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Effect,
                            it.getNumber(2).toInt()
                        )
                    } else {
                        it.target?.playEffect(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Effect,
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt()
                        )
                    }
                }
                .function("getEmptyChunkSnapshot", 4) {
                    it.target?.getEmptyChunkSnapshot(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getBoolean(2),
                        it.getBoolean(3)
                    )
                }
                .function("setSpawnFlags", 2) { it.target?.setSpawnFlags(it.getBoolean(0), it.getBoolean(1)) }
                .function("allowAnimals", 0) { it.target?.allowAnimals }
                .function("allowMonsters", 0) { it.target?.allowMonsters }
                .syncFunction("getBiome", 2) { it.target?.getBiome(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .syncFunction("setBiome", 3) {
                    it.target?.setBiome(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getArgument(2) as Biome
                    )
                }
                .function("getTemperature", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.getTemperature(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt()
                        )
                    } else {
                        it.target?.getTemperature(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                .function("getHumidity", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.getHumidity(it.getNumber(0).toInt(), it.getNumber(1).toInt())
                    } else {
                        it.target?.getHumidity(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                .function("logicalHeight", 0) { it.target?.logicalHeight }
                .function("isNatural", 0) { it.target?.isNatural }
                .function("isBedWorks", 0) { it.target?.isBedWorks }
                .function("hasSkyLight", 0) { it.target?.hasSkyLight() }
                .function("hasCeiling", 0) { it.target?.hasCeiling() }
                .function("isPiglinSafe", 0) { it.target?.isPiglinSafe }
                .function("isRespawnAnchorWorks", 0) { it.target?.isRespawnAnchorWorks }
                .function("hasRaids", 0) { it.target?.hasRaids() }
                .function("isUltraWarm", 0) { it.target?.isUltraWarm }
                .function("seaLevel", 0) { it.target?.seaLevel }
                .function("keepSpawnInMemory", 0) { it.target?.keepSpawnInMemory }
                .function("setKeepSpawnInMemory", 1) { it.target?.setKeepSpawnInMemory(it.getBoolean(0)) }
                .function("isAutoSave", 0) { it.target?.isAutoSave }
                .function("setAutoSave", 1) { it.target?.setAutoSave(it.getBoolean(0)) }
                .function("setDifficulty", 1) { it.target?.setDifficulty(it.getArgument(0) as Difficulty) }
                .function("difficulty", 0) { it.target?.difficulty }
                .function("viewDistance", 0) { it.target?.viewDistance }
                .function("simulationDistance", 0) { it.target?.simulationDistance }
                .function("worldFolder", 0) { it.target?.worldFolder }
                .function("worldType", 0) { it.target?.worldType }
                .function("canGenerateStructures", 0) { it.target?.canGenerateStructures() }
                .function("isHardcore", 0) { it.target?.isHardcore }
                .function("setHardcore", 1) { it.target?.setHardcore(it.getBoolean(0)) }
                .function("ticksPerAnimalSpawns", 0) { it.target?.ticksPerAnimalSpawns }
                .function("setTicksPerAnimalSpawns", 1) { it.target?.setTicksPerAnimalSpawns(it.getNumber(0).toInt()) }
                .function("ticksPerMonsterSpawns", 0) { it.target?.ticksPerMonsterSpawns }
                .function("setTicksPerMonsterSpawns", 1) {
                    it.target?.setTicksPerMonsterSpawns(
                        it.getNumber(0).toInt()
                    )
                }
                .function("ticksPerWaterSpawns", 0) { it.target?.ticksPerWaterSpawns }
                .function("setTicksPerWaterSpawns", 1) { it.target?.setTicksPerWaterSpawns(it.getNumber(0).toInt()) }
                .function("ticksPerWaterAmbientSpawns", 0) { it.target?.ticksPerWaterAmbientSpawns }
                .function("setTicksPerWaterAmbientSpawns", 1) {
                    it.target?.setTicksPerWaterAmbientSpawns(
                        it.getNumber(0).toInt()
                    )
                }
                .function(
                    "ticksPerWaterUndergroundCreatureSpawns",
                    0
                ) { it.target?.ticksPerWaterUndergroundCreatureSpawns }
                .function(
                    "setTicksPerWaterUndergroundCreatureSpawns",
                    1
                ) { it.target?.setTicksPerWaterUndergroundCreatureSpawns(it.getNumber(0).toInt()) }
                .function("ticksPerAmbientSpawns", 0) { it.target?.ticksPerAmbientSpawns }
                .function("setTicksPerAmbientSpawns", 1) {
                    it.target?.setTicksPerAmbientSpawns(
                        it.getNumber(0).toInt()
                    )
                }
                .function("getTicksPerSpawns", 1) { it.target?.getTicksPerSpawns(it.getArgument(0) as SpawnCategory) }
                .function("setTicksPerSpawns", 2) {
                    it.target?.setTicksPerSpawns(
                        it.getArgument(0) as SpawnCategory,
                        it.getNumber(1).toInt()
                    )
                }
                .function("monsterSpawnLimit", 0) { it.target?.monsterSpawnLimit }
                .function("setMonsterSpawnLimit", 1) { it.target?.setMonsterSpawnLimit(it.getNumber(0).toInt()) }
                .function("animalSpawnLimit", 0) { it.target?.animalSpawnLimit }
                .function("setAnimalSpawnLimit", 1) { it.target?.setAnimalSpawnLimit(it.getNumber(0).toInt()) }
                .function("waterAnimalSpawnLimit", 0) { it.target?.waterAnimalSpawnLimit }
                .function("setWaterAnimalSpawnLimit", 1) {
                    it.target?.setWaterAnimalSpawnLimit(
                        it.getNumber(0).toInt()
                    )
                }
                .function(
                    "waterUndergroundCreatureSpawnLimit",
                    0
                ) { it.target?.waterUndergroundCreatureSpawnLimit }
                .function(
                    "setWaterUndergroundCreatureSpawnLimit",
                    1
                ) { it.target?.setWaterUndergroundCreatureSpawnLimit(it.getNumber(0).toInt()) }
                .function("waterAmbientSpawnLimit", 0) { it.target?.waterAmbientSpawnLimit }
                .function("setWaterAmbientSpawnLimit", 1) {
                    it.target?.setWaterAmbientSpawnLimit(
                        it.getNumber(0).toInt()
                    )
                }
                .function("ambientSpawnLimit", 0) { it.target?.ambientSpawnLimit }
                .function("setAmbientSpawnLimit", 1) { it.target?.setAmbientSpawnLimit(it.getNumber(0).toInt()) }
                .function("getSpawnLimit", 1) { it.target?.getSpawnLimit(it.getArgument(0) as SpawnCategory) }
                .function("setSpawnLimit", 2) {
                    it.target?.setSpawnLimit(
                        it.getArgument(0) as SpawnCategory,
                        it.getNumber(1).toInt()
                    )
                }
                .syncFunction("playNote", 3) {
                    it.target?.playNote(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Instrument,
                        it.getArgument(2) as Note
                    )
                }
                .syncFunction("playSound", listOf(4, 5, 6)) {
                    when (it.arguments.size) {
                        4 -> when (val var1 = it.getArgument(0)) {
                            is Location -> when (val var2 = it.getArgument(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getNumber(2).toFloat(),
                                    it.getNumber(3).toFloat()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getNumber(2).toFloat(),
                                    it.getNumber(3).toFloat()
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getArgument(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getNumber(2).toFloat(),
                                    it.getNumber(3).toFloat()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getNumber(2).toFloat(),
                                    it.getNumber(3).toFloat()
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("第一个参数必须是 Location 或 Entity 类型")
                        }

                        5 -> when (val var1 = it.getArgument(0)) {
                            is Location -> when (val var2 = it.getArgument(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat()
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getArgument(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat()
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("第一个参数必须是 Location 或 Entity 类型")
                        }

                        6 -> when (val var1 = it.getArgument(0)) {
                            is Location -> when (val var2 = it.getArgument(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat(),
                                    it.getNumber(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat(),
                                    it.getNumber(5).toLong()
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getArgument(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat(),
                                    it.getNumber(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat(),
                                    it.getNumber(5).toLong()
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("第一个参数必须是 Location 或 Entity 类型")
                        }
                        else -> error("World#playSound 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("gameRules", 0) { it.target?.gameRules }
                .function("getGameRuleValue", 1) { it.target?.getGameRuleValue(it.getString(0)) }
                .function("setGameRuleValue", 2) { it.target?.setGameRuleValue(it.getString(0)!!, it.getString(1)!!) }
                .function("isGameRule", 1) { it.target?.isGameRule(it.getString(0)!!) }
                .function("worldBorder", 0) { it.target?.worldBorder }
                .function("spawnParticle", listOf(3, 5, 6, 7, 8, 9)) {
                    when (it.arguments.size) {
                        3 -> it.target?.spawnParticle(
                            it.getArgument(0) as Particle,
                            it.getArgument(1) as Location,
                            it.getNumber(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getArgument(0) as Particle,
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getArgument(0) as Particle,
                            it.getArgument(1) as Location,
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toDouble(),
                            it.getNumber(5).toDouble()
                        )

                        7 -> it.target?.spawnParticle(
                            it.getArgument(0) as Particle,
                            it.getArgument(1) as Location,
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toDouble(),
                            it.getNumber(5).toDouble(),
                            it.getNumber(6).toDouble()
                        )

                        8 -> it.target?.spawnParticle(
                            it.getArgument(0) as Particle,
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toInt(),
                            it.getNumber(5).toDouble(),
                            it.getNumber(6).toDouble(),
                            it.getNumber(7).toDouble()
                        )

                        9 -> it.target?.spawnParticle(
                            it.getArgument(0) as Particle,
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toInt(),
                            it.getNumber(5).toDouble(),
                            it.getNumber(6).toDouble(),
                            it.getNumber(7).toDouble(),
                            it.getNumber(8).toDouble()
                        )
                        else -> error("World#spawnParticle 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .syncFunction("locateNearestStructure", 4) {
                    when (val var2 = it.getArgument(1)) {
                        is StructureType -> it.target?.locateNearestStructure(
                            it.getArgument(0) as Location,
                            var2,
                            it.getNumber(2).toInt(),
                            it.getBoolean(3)
                        )

                        is Structure -> it.target?.locateNearestStructure(
                            it.getArgument(0) as Location,
                            var2,
                            it.getNumber(2).toInt(),
                            it.getBoolean(3)
                        )

                        else -> throw IllegalArgumentException("第二个参数必须是 StructureType 或 Structure 类型")
                    }
                }
                .syncFunction("locateNearestBiome", listOf(2, 4)) {
                    if (it.arguments.size == 2) {
                        it.target?.locateNearestBiome(
                            it.getArgument(0) as Location,
                            it.getNumber(1).toInt()
                        )
                    } else {
                        it.target?.locateNearestBiome(
                            it.getArgument(0) as Location,
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt()
                        )
                    }
                }
                .syncFunction("locateNearestRaid", 2) {
                    it.target?.locateNearestRaid(
                        it.getArgument(0) as Location,
                        it.getNumber(1).toInt()
                    )
                }
                .function("raids", 0) { it.target?.raids }
                .function("enderDragonBattle", 0) { it.target?.enderDragonBattle }
                .function("featureFlags", 0) { it.target?.featureFlags }
                .syncFunction("getStructures", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.getStructures(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt()
                        )
                    } else {
                        it.target?.getStructures(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getArgument(2) as Structure
                        )
                    }
                }
                .function("isDay", 0) { it.target?.isDay }
                .function("isNight", 0) { it.target?.isNight }

            registerExtension(World.Environment::class.java)
                .function("id", 0) { it.target?.id }
                // static
                .function("getEnvironment", 1) { World.Environment.getEnvironment(it.getNumber(0).toInt()) }
        }
    }

    /**
     * 世界是否为白天
     *
     * 根据世界时间判断是否为白天（时间在 0-12300 或 23850-24000 之间）。
     * Minecraft 中一天为 24000 刻，白天约为 0-12300 刻。
     */
    private val World.isDay: Boolean
        get() = time !in 12300..23850

    /**
     * 世界是否为黑夜
     *
     * 根据世界时间判断是否为黑夜（时间在 12301-23849 之间）。
     * 黑夜期间怪物会自然生成。
     */
    private val World.isNight: Boolean
        get() = time in 12301..23849
}
