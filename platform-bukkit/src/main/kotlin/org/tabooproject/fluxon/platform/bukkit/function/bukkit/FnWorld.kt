package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Bukkit
import org.bukkit.World
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import java.util.*

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
                .function("canGenerateStructures", 0) { it.target?.canGenerateStructures() }
                .function("allowAnimals", 0) { it.target?.allowAnimals }
                .function("allowMonsters", 0) { it.target?.allowMonsters }
                .function("biomeProvider", 0) { it.target?.biomeProvider }
                .function("clearWeatherDuration", 0) { it.target?.clearWeatherDuration }
                .function("difficulty", 0) { it.target?.difficulty }
                .function("enderDragonBattle", 0) { it.target?.enderDragonBattle }
                .function("entities", 0) { it.target?.entities }
                .function("featureFlags", 0) { it.target?.featureFlags }
                .function("forceLoadedChunks", 0) { it.target?.forceLoadedChunks }
                .function("fullTime", 0) { it.target?.fullTime }
                .function("gameRules", 0) { it.target?.gameRules }
                .function("gameTime", 0) { it.target?.gameTime }
                .function("generator", 0) { it.target?.generator }
                .function("keepSpawnInMemory", 0) { it.target?.keepSpawnInMemory }
                .function("livingEntities", 0) { it.target?.livingEntities }
                .function("loadedChunks", 0) { it.target?.loadedChunks }
                .function("logicalHeight", 0) { it.target?.logicalHeight }
                .function("players", 0) { it.target?.players }
                .function("pluginChunkTickets", 0) { it.target?.pluginChunkTickets }
                .function("populators", 0) { it.target?.populators }
                .function("pvp", 0) { it.target?.pvp }
                .function("raids", 0) { it.target?.raids }
                .function("seaLevel", 0) { it.target?.seaLevel }
                .function("simulationDistance", 0) { it.target?.simulationDistance }
                .function("spawnLocation", 0) { it.target?.spawnLocation }
                .function("thunderDuration", 0) { it.target?.thunderDuration }
                .function("time", 0) { it.target?.time }
                .function("viewDistance", 0) { it.target?.viewDistance }
                .function("weatherDuration", 0) { it.target?.weatherDuration }
                .function("worldBorder", 0) { it.target?.worldBorder }
                .function("worldFolder", 0) { it.target?.worldFolder }
                .function("hasCelling", 0) { it.target?.hasCeiling() }
                .function("hasRaids", 0) { it.target?.hasRaids() }
                .function("hasSkyLight", 0) { it.target?.hasSkyLight() }
                .function("hasStorm", 0) { it.target?.hasStorm() }
                .function("isAutoSave", 0) { it.target?.isAutoSave }
                .function("isBedWorks", 0) { it.target?.isBedWorks }
                .function("isClearWeather", 0) { it.target?.isClearWeather }
                .function("isHardcore", 0) { it.target?.isHardcore }
                .function("isNatural", 0) { it.target?.isNatural }
                .function("isPiglinSafe", 0) { it.target?.isPiglinSafe }
                .function("isRespawnAnchorWorks", 0) { it.target?.isRespawnAnchorWorks }
                .function("isThundering", 0) { it.target?.isThundering }
                .function("isUltraWarm", 0) { it.target?.isUltraWarm }
                .function("isDay", 0) { it.target?.isDay }
                .function("isNight", 0) { it.target?.isNight }
        }
    }

    /**
     * 世界是否为白天
     *
     * 根据世界时间判断是否为白天（时间在 0-12300 或 23850-24000 之间）。
     * Minecraft 中一天为 24000 刻，白天约为 0-12300 刻。
     */
    private val World.isDay: Boolean
        get() = time < 12300 || time > 23850

    /**
     * 世界是否为黑夜
     *
     * 根据世界时间判断是否为黑夜（时间在 12301-23849 之间）。
     * 黑夜期间怪物会自然生成。
     */
    private val World.isNight: Boolean
        get() = time in 12301..23849
}