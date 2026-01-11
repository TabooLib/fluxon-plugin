package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.*
import org.bukkit.block.Biome
import org.bukkit.entity.Entity
import org.bukkit.entity.SpawnCategory
import org.bukkit.generator.structure.Structure
import org.bukkit.plugin.Plugin
import org.bukkit.util.BoundingBox
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnWorld {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(World::class.java)
                .function("blockAt", 3) {
                    it.target?.getBlockAt(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("blockAt", 1) { it.target?.getBlockAt(it.getArgument(0) as Location) }
                .function("highestBlockAt", 2) {
                    // Block getHighestBlockAt(int var1, int var2)
                    // Block getHighestBlockAt(@NotNull Location var1, @NotNull HeightMap var2)
                    TODO()
                }
                .function("highestBlockAt", 1) { it.target?.getHighestBlockAt(it.getArgument(0) as Location) }
                .function("highestBlockAt", 3) {
                    it.target?.getHighestBlockAt(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getArgument(2) as HeightMap
                    )
                }
                .function("chunkAt", 2) { it.target?.getChunkAt(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .function("chunkAt", 3) {
                    it.target?.getChunkAt(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getBoolean(2)
                    )
                }
                .function("chunkAt", 1) {
                    // Chunk getChunkAt(@NotNull Location var1)
                    // Chunk getChunkAt(@NotNull Block var1)
                    TODO()
                }
                .function("isChunkLoaded", 1) { it.target?.isChunkLoaded(it.getArgument(0) as Chunk) }
                .function("loadedChunks", 0) { it.target?.loadedChunks }
                .function("loadChunk", 1) { it.target?.loadChunk(it.getArgument(0) as Chunk) }
                .function("isChunkLoaded", 2) {
                    it.target?.isChunkLoaded(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
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
                .function("loadChunk", 2) { it.target?.loadChunk(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .function("loadChunk", 3) {
                    it.target?.loadChunk(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getBoolean(2)
                    )
                }
                .function("unloadChunk", 1) { it.target?.unloadChunk(it.getArgument(0) as Chunk) }
                .function("unloadChunk", 2) { it.target?.unloadChunk(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .function("unloadChunk", 3) {
                    it.target?.unloadChunk(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getBoolean(2)
                    )
                }
                .function("unloadChunkRequest", 2) {
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
                .function("playersSeeingChunk", 1) { it.target?.getPlayersSeeingChunk(it.getArgument(0) as Chunk) }
                .function("playersSeeingChunk", 2) {
                    it.target?.getPlayersSeeingChunk(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
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
                .function("pluginChunkTickets", 2) {
                    it.target?.getPluginChunkTickets(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function(
                    "intersectingChunks",
                    1
                ) { it.target?.getIntersectingChunks(it.getArgument(0) as BoundingBox) }
                .function("dropItem", 2) {
                    // Item dropItem(@NotNull Location var1, @NotNull ItemStack var2)
                    // Item dropItem(@NotNull Location var1, @NotNull ItemStack var2, @Nullable Consumer<? super Item> var3)
                    TODO()
                }
                .function("dropItemNaturally", 2) {
                    // Item dropItemNaturally(@NotNull Location var1, @NotNull ItemStack var2)
                    // Item dropItemNaturally(@NotNull Location var1, @NotNull ItemStack var2, @Nullable Consumer<? super Item> var3)
                    TODO()
                }
                .function("spawnArrow", 4) {
                    it.target?.spawnArrow(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Vector,
                        it.getNumber(2).toFloat(),
                        it.getNumber(3).toFloat()
                    )
                }
                .function("generateTree", 2) {
                    it.target?.generateTree(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as TreeType
                    )
                }
                .function("generateTree", 3) {
                    it.target?.generateTree(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as TreeType,
                        it.getArgument(2) as BlockChangeDelegate
                    )
                }
                .function("strikeLightning", 1) { it.target?.strikeLightning(it.getArgument(0) as Location) }
                .function(
                    "strikeLightningEffect",
                    1
                ) { it.target?.strikeLightningEffect(it.getArgument(0) as Location) }
                .function("entities", 0) { it.target?.entities }
                .function("livingEntities", 0) { it.target?.livingEntities }
                .function("entitiesByClasses", 0) { it.target?.getEntitiesByClasses() }
                .function("players", 0) { it.target?.players }
                .function("nearbyEntities", 4) {
                    // Collection<Entity> getNearbyEntities(@NotNull Location var1, double var2, double var4, double var6)
                    // Collection<Entity> getNearbyEntities(@NotNull Location var1, double var2, double var4, double var6, @Nullable Predicate<? super Entity> var8)
                    TODO()
                }
                .function("nearbyEntities", 1) {
                    // Collection<Entity> getNearbyEntities(@NotNull BoundingBox var1)
                    // Collection<Entity> getNearbyEntities(@NotNull BoundingBox var1, @Nullable Predicate<? super Entity> var2)
                    TODO()
                }
                .function("rayTraceEntities", 3) {
                    // RayTraceResult rayTraceEntities(@NotNull Location var1, @NotNull Vector var2, double var3)
                    // RayTraceResult rayTraceEntities(@NotNull Location var1, @NotNull Vector var2, double var3, @Nullable Predicate<? super Entity> var5)
                    TODO()
                }
                .function("rayTraceEntities", 4) {
                    // RayTraceResult rayTraceEntities(@NotNull Location var1, @NotNull Vector var2, double var3, double var5)
                    // RayTraceResult rayTraceEntities(@NotNull Location var1, @NotNull Vector var2, double var3, double var5, @Nullable Predicate<? super Entity> var7)
                    TODO()
                }
                .function("rayTraceBlocks", 3) {
                    it.target?.rayTraceBlocks(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Vector,
                        it.getNumber(2).toDouble()
                    )
                }
                .function("rayTraceBlocks", 4) {
                    it.target?.rayTraceBlocks(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Vector,
                        it.getNumber(2).toDouble(),
                        it.getArgument(3) as FluidCollisionMode
                    )
                }
                .function("rayTraceBlocks", 5) {
                    it.target?.rayTraceBlocks(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Vector,
                        it.getNumber(2).toDouble(),
                        it.getArgument(3) as FluidCollisionMode,
                        it.getBoolean(4)
                    )
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
                .function("setSpawnLocation", 1) { it.target?.setSpawnLocation(it.getArgument(0) as Location) }
                .function("setSpawnLocation", 4) {
                    it.target?.setSpawnLocation(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toFloat()
                    )
                }
                .function("setSpawnLocation", 3) {
                    it.target?.setSpawnLocation(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
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
                .function("createExplosion", 4) {
                    // boolean createExplosion(double var1, double var3, double var5, float var7)
                    // boolean createExplosion(@NotNull Location var1, float var2, boolean var3, boolean var4)
                    TODO()
                }
                .function("createExplosion", 5) {
                    // boolean createExplosion(double var1, double var3, double var5, float var7, boolean var8)
                    // boolean createExplosion(@NotNull Location var1, float var2, boolean var3, boolean var4, @Nullable Entity var5)
                    TODO()
                }
                .function("createExplosion", 6) {
                    it.target?.createExplosion(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toFloat(),
                        it.getBoolean(4),
                        it.getBoolean(5)
                    )
                }
                .function("createExplosion", 7) {
                    it.target?.createExplosion(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toFloat(),
                        it.getBoolean(4),
                        it.getBoolean(5),
                        it.getArgument(6) as Entity
                    )
                }
                .function("createExplosion", 2) {
                    it.target?.createExplosion(
                        it.getArgument(0) as Location,
                        it.getNumber(1).toFloat()
                    )
                }
                .function("createExplosion", 3) {
                    it.target?.createExplosion(
                        it.getArgument(0) as Location,
                        it.getNumber(1).toFloat(),
                        it.getBoolean(2)
                    )
                }
                .function("pVP", 0) { it.target?.pvp }
                .function("setPVP", 1) { it.target?.setPVP(it.getBoolean(0)) }
                .function("generator", 0) { it.target?.generator }
                .function("biomeProvider", 0) { it.target?.biomeProvider }
                .function("save", 0) { it.target?.save() }
                .function("populators", 0) { it.target?.populators }
                .function("spawnFallingBlock", 2) {
                    // FallingBlock spawnFallingBlock(@NotNull Location var1, @NotNull MaterialData var2)
                    // FallingBlock spawnFallingBlock(@NotNull Location var1, @NotNull BlockData var2)
                    TODO()
                }
                .function("spawnFallingBlock", 3) {
                    it.target?.spawnFallingBlock(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Material,
                        it.getNumber(2).toByte()
                    )
                }
                .function("playEffect", 3) {
                    it.target?.playEffect(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Effect,
                        it.getNumber(2).toInt()
                    )
                }
                .function("playEffect", 4) {
                    it.target?.playEffect(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Effect,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt()
                    )
                }
                .function("emptyChunkSnapshot", 4) {
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
                .function("biome", 2) { it.target?.getBiome(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .function("setBiome", 3) {
                    it.target?.setBiome(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getArgument(2) as Biome
                    )
                }
                .function("temperature", 2) {
                    it.target?.getTemperature(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("temperature", 3) {
                    it.target?.getTemperature(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("humidity", 2) { it.target?.getHumidity(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .function("humidity", 3) {
                    it.target?.getHumidity(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
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
                .function("ticksPerSpawns", 1) { it.target?.getTicksPerSpawns(it.getArgument(0) as SpawnCategory) }
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
                .function("spawnLimit", 1) { it.target?.getSpawnLimit(it.getArgument(0) as SpawnCategory) }
                .function("setSpawnLimit", 2) {
                    it.target?.setSpawnLimit(
                        it.getArgument(0) as SpawnCategory,
                        it.getNumber(1).toInt()
                    )
                }
                .function("playNote", 3) {
                    it.target?.playNote(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Instrument,
                        it.getArgument(2) as Note
                    )
                }
                .function("playSound", 4) {
                    // void playSound(@NotNull Location var1, @NotNull Sound var2, float var3, float var4)
                    // void playSound(@NotNull Location var1, @NotNull String var2, float var3, float var4)
                    // void playSound(@NotNull Entity var1, @NotNull Sound var2, float var3, float var4)
                    // void playSound(@NotNull Entity var1, @NotNull String var2, float var3, float var4)
                    TODO()
                }
                .function("playSound", 5) {
                    // void playSound(@NotNull Location var1, @NotNull Sound var2, @NotNull SoundCategory var3, float var4, float var5)
                    // void playSound(@NotNull Location var1, @NotNull String var2, @NotNull SoundCategory var3, float var4, float var5)
                    // void playSound(@NotNull Entity var1, @NotNull Sound var2, @NotNull SoundCategory var3, float var4, float var5)
                    // void playSound(@NotNull Entity var1, @NotNull String var2, @NotNull SoundCategory var3, float var4, float var5)
                    TODO()
                }
                .function("playSound", 6) {
                    // void playSound(@NotNull Location var1, @NotNull Sound var2, @NotNull SoundCategory var3, float var4, float var5, long var6)
                    // void playSound(@NotNull Location var1, @NotNull String var2, @NotNull SoundCategory var3, float var4, float var5, long var6)
                    // void playSound(@NotNull Entity var1, @NotNull Sound var2, @NotNull SoundCategory var3, float var4, float var5, long var6)
                    // void playSound(@NotNull Entity var1, @NotNull String var2, @NotNull SoundCategory var3, float var4, float var5, long var6)
                    TODO()
                }
                .function("gameRules", 0) { it.target?.gameRules }
                .function("gameRuleValue", 1) { it.target?.getGameRuleValue(it.getString(0)) }
                .function("setGameRuleValue", 2) { it.target?.setGameRuleValue(it.getString(0)!!, it.getString(1)!!) }
                .function("isGameRule", 1) { it.target?.isGameRule(it.getString(0)!!) }
                .function("worldBorder", 0) { it.target?.worldBorder }
                .function("spawnParticle", 3) {
                    it.target?.spawnParticle(
                        it.getArgument(0) as Particle,
                        it.getArgument(1) as Location,
                        it.getNumber(2).toInt()
                    )
                }
                .function("spawnParticle", 5) {
                    it.target?.spawnParticle(
                        it.getArgument(0) as Particle,
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toDouble(),
                        it.getNumber(4).toInt()
                    )
                }
                .function("spawnParticle", 6) {
                    it.target?.spawnParticle(
                        it.getArgument(0) as Particle,
                        it.getArgument(1) as Location,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toDouble(),
                        it.getNumber(4).toDouble(),
                        it.getNumber(5).toDouble()
                    )
                }
                .function("spawnParticle", 8) {
                    it.target?.spawnParticle(
                        it.getArgument(0) as Particle,
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toDouble(),
                        it.getNumber(4).toInt(),
                        it.getNumber(5).toDouble(),
                        it.getNumber(6).toDouble(),
                        it.getNumber(7).toDouble()
                    )
                }
                .function("spawnParticle", 7) {
                    it.target?.spawnParticle(
                        it.getArgument(0) as Particle,
                        it.getArgument(1) as Location,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toDouble(),
                        it.getNumber(4).toDouble(),
                        it.getNumber(5).toDouble(),
                        it.getNumber(6).toDouble()
                    )
                }
                .function("spawnParticle", 9) {
                    it.target?.spawnParticle(
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
                }
                .function("locateNearestStructure", 4) {
                    // Location locateNearestStructure(@NotNull Location var1, @NotNull StructureType var2, int var3, boolean var4)
                    // StructureSearchResult locateNearestStructure(@NotNull Location var1, @NotNull org.bukkit.generator.structure.StructureType var2, int var3, boolean var4)
                    // StructureSearchResult locateNearestStructure(@NotNull Location var1, @NotNull Structure var2, int var3, boolean var4)
                    TODO()
                }
                .function("spigot", 0) { it.target?.spigot() }
                .function("locateNearestBiome", 2) {
                    it.target?.locateNearestBiome(
                        it.getArgument(0) as Location,
                        it.getNumber(1).toInt()
                    )
                }
                .function("locateNearestBiome", 4) {
                    it.target?.locateNearestBiome(
                        it.getArgument(0) as Location,
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt()
                    )
                }
                .function("locateNearestRaid", 2) {
                    it.target?.locateNearestRaid(
                        it.getArgument(0) as Location,
                        it.getNumber(1).toInt()
                    )
                }
                .function("raids", 0) { it.target?.raids }
                .function("enderDragonBattle", 0) { it.target?.enderDragonBattle }
                .function("featureFlags", 0) { it.target?.featureFlags }
                .function("structures", 2) {
                    it.target?.getStructures(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("structures", 3) {
                    it.target?.getStructures(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getArgument(2) as Structure
                    )
                }
            registerExtension(World.Environment::class.java)
                .function("id", 0) { it.target?.id }
                // static
                .function("environment", 1) { World.Environment.getEnvironment(it.getNumber(0).toInt()) }
        }
    }
}
