package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.*
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.entity.SpawnCategory
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.Recipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.awt.image.BufferedImage
import java.io.File
import java.net.InetAddress
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnServer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Server::class.java)
                .function("name", 0) { it.target?.name }
                .function("version", 0) { it.target?.version }
                .function("bukkitVersion", 0) { it.target?.bukkitVersion }
                .function("maxPlayers", 0) { it.target?.maxPlayers }
                .function("setMaxPlayers", 1) { it.target?.setMaxPlayers(it.getNumber(0).toInt()) }
                .function("port", 0) { it.target?.port }
                .function("viewDistance", 0) { it.target?.viewDistance }
                .function("simulationDistance", 0) { it.target?.simulationDistance }
                .function("ip", 0) { it.target?.ip }
                .function("worldType", 0) { it.target?.worldType }
                .function("generateStructures", 0) { it.target?.generateStructures }
                .function("maxWorldSize", 0) { it.target?.maxWorldSize }
                .function("allowEnd", 0) { it.target?.allowEnd }
                .function("allowNether", 0) { it.target?.allowNether }
                .function("isLoggingIPs", 0) { it.target?.isLoggingIPs }
                .function("initialEnabledPacks", 0) { it.target?.initialEnabledPacks }
                .function("initialDisabledPacks", 0) { it.target?.initialDisabledPacks }
                .function("dataPackManager", 0) { it.target?.dataPackManager }
                .function("serverTickManager", 0) { it.target?.serverTickManager }
                .function("serverResourcePack", 0) { it.target?.serverResourcePack }
                .function("resourcePack", 0) { it.target?.resourcePack }
                .function("resourcePackHash", 0) { it.target?.resourcePackHash }
                .function("resourcePackPrompt", 0) { it.target?.resourcePackPrompt }
                .function("isResourcePackRequired", 0) { it.target?.isResourcePackRequired }
                .function("hasWhitelist", 0) { it.target?.hasWhitelist() }
                .function("setWhitelist", 1) { it.target?.setWhitelist(it.getBoolean(0)) }
                .function("isWhitelistEnforced", 0) { it.target?.isWhitelistEnforced }
                .function("setWhitelistEnforced", 1) { it.target?.setWhitelistEnforced(it.getBoolean(0)) }
                .function("whitelistedPlayers", 0) { it.target?.whitelistedPlayers }
                .function("reloadWhitelist", 0) { it.target?.reloadWhitelist() }
                .function("broadcastMessage", 1) { it.target?.broadcastMessage(it.getString(0)!!) }
                .function("updateFolder", 0) { it.target?.updateFolder }
                .function("updateFolderFile", 0) { it.target?.updateFolderFile }
                .function("connectionThrottle", 0) { it.target?.connectionThrottle }
                .function("ticksPerAnimalSpawns", 0) { it.target?.ticksPerAnimalSpawns }
                .function("ticksPerMonsterSpawns", 0) { it.target?.ticksPerMonsterSpawns }
                .function("ticksPerWaterSpawns", 0) { it.target?.ticksPerWaterSpawns }
                .function("ticksPerWaterAmbientSpawns", 0) { it.target?.ticksPerWaterAmbientSpawns }
                .function(
                    "ticksPerWaterUndergroundCreatureSpawns",
                    0
                ) { it.target?.ticksPerWaterUndergroundCreatureSpawns }
                .function("ticksPerAmbientSpawns", 0) { it.target?.ticksPerAmbientSpawns }
                .function("getTicksPerSpawns", 1) { it.target?.getTicksPerSpawns(it.getArgument(0) as SpawnCategory) }
                .function("getPlayer", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.getPlayer(var1)
                        is UUID -> it.target?.getPlayer(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 UUID 类型")
                    }
                }
                .function("getPlayerExact", 1) { it.target?.getPlayerExact(it.getString(0)!!) }
                .function("matchPlayer", 1) { it.target?.matchPlayer(it.getString(0)!!) }
                .function("pluginManager", 0) { it.target?.pluginManager }
                .function("scheduler", 0) { it.target?.scheduler }
                .function("servicesManager", 0) { it.target?.servicesManager }
                .function("worlds", 0) { it.target?.worlds }
                .function("createWorld", 1) { it.target?.createWorld(it.getArgument(0) as WorldCreator) }
                .function("unloadWorld", 2) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.unloadWorld(var1, it.getBoolean(1))
                        is World -> it.target?.unloadWorld(var1, it.getBoolean(1))
                        else -> throw IllegalArgumentException("参数必须是 String 或 World 类型")
                    }
                }
                .function("getWorld", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.getWorld(var1)
                        is UUID -> it.target?.getWorld(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 UUID 类型")
                    }
                }
                .function("createWorldBorder", 0) { it.target?.createWorldBorder() }
                .function("getMap", 1) { it.target?.getMap(it.getNumber(0).toInt()) }
                .function("createMap", 1) { it.target?.createMap(it.getArgument(0) as World) }
                .function("createExplorerMap", listOf(3, 5)) {
                    if (it.arguments.size == 3) {
                        it.target?.createExplorerMap(
                            it.getArgument(0) as World,
                            it.getArgument(1) as Location,
                            it.getArgument(2) as StructureType
                        )
                    } else {
                        it.target?.createExplorerMap(
                            it.getArgument(0) as World,
                            it.getArgument(1) as Location,
                            it.getArgument(2) as StructureType,
                            it.getNumber(3).toInt(),
                            it.getBoolean(4)
                        )
                    }
                }
                .function("reload", 0) { it.target?.reload() }
                .function("reloadData", 0) { it.target?.reloadData() }
                .function("logger", 0) { it.target?.logger }
                .function("getPluginCommand", 1) { it.target?.getPluginCommand(it.getString(0)!!) }
                .function("savePlayers", 0) { it.target?.savePlayers() }
                .syncFunction("dispatchCommand", 2) {
                    it.target?.dispatchCommand(
                        it.getArgument(0) as CommandSender,
                        it.getString(1)!!
                    )
                }
                .function("addRecipe", 1) { it.target?.addRecipe(it.getArgument(0) as Recipe) }
                .function("getRecipesFor", 1) { it.target?.getRecipesFor(it.getArgument(0) as ItemStack) }
                .function("getRecipe", 1) { it.target?.getRecipe(it.getArgument(0) as NamespacedKey) }
                .function("getCraftingRecipe", 2) {
                    it.target?.getCraftingRecipe(
                        it.getArgument(0) as Array<ItemStack>,
                        it.getArgument(1) as World
                    )
                }
                .function("craftItem", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.craftItem(
                            it.getArgument(0) as Array<ItemStack>,
                            it.getArgument(1) as World
                        )
                    } else {
                        it.target?.craftItem(
                            it.getArgument(0) as Array<ItemStack>,
                            it.getArgument(1) as World,
                            it.getArgument(2) as Player
                        )
                    }
                }
                .function("craftItemResult", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.craftItemResult(
                            it.getArgument(0) as Array<ItemStack>,
                            it.getArgument(1) as World
                        )
                    } else {
                        it.target?.craftItemResult(
                            it.getArgument(0) as Array<ItemStack>,
                            it.getArgument(1) as World,
                            it.getArgument(2) as Player
                        )
                    }
                }
                .function("recipeIterator", 0) { it.target?.recipeIterator() }
                .function("clearRecipes", 0) { it.target?.clearRecipes() }
                .function("resetRecipes", 0) { it.target?.resetRecipes() }
                .function("removeRecipe", 1) { it.target?.removeRecipe(it.getArgument(0) as NamespacedKey) }
                .function("spawnRadius", 0) { it.target?.spawnRadius }
                .function("setSpawnRadius", 1) { it.target?.setSpawnRadius(it.getNumber(0).toInt()) }
                .function("shouldSendChatPreviews", 0) { it.target?.shouldSendChatPreviews() }
                .function("isEnforcingSecureProfiles", 0) { it.target?.isEnforcingSecureProfiles }
                .function("isAcceptingTransfers", 0) { it.target?.isAcceptingTransfers }
                .function("hideOnlinePlayers", 0) { it.target?.hideOnlinePlayers }
                .function("onlineMode", 0) { it.target?.onlineMode }
                .function("allowFlight", 0) { it.target?.allowFlight }
                .function("isHardcore", 0) { it.target?.isHardcore }
                .function("shutdown", 0) { it.target?.shutdown() }
                .function("broadcast", 2) { it.target?.broadcast(it.getString(0)!!, it.getString(1)!!) }
                .function("getOfflinePlayer", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.getOfflinePlayer(var1)
                        is UUID -> it.target?.getOfflinePlayer(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 UUID 类型")
                    }
                }
                .function("createPlayerProfile", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        when (val var1 = it.getArgument(0)) {
                            is UUID -> it.target?.createPlayerProfile(var1)
                            is String -> it.target?.createPlayerProfile(var1)
                            else -> throw IllegalArgumentException("参数必须是 UUID 或 String 类型")
                        }
                    } else {
                        it.target?.createPlayerProfile(
                            UUID.fromString(it.getString(0)),
                            it.getString(1)
                        )
                    }
                }
                .function("iPBans", 0) { it.target?.ipBans }
                .function("banIP", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.banIP(var1)
                        is InetAddress -> it.target?.banIP(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 InetAddress 类型")
                    }
                }
                .function("unbanIP", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.unbanIP(var1)
                        is InetAddress -> it.target?.unbanIP(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 InetAddress 类型")
                    }
                }
                .function("bannedPlayers", 0) { it.target?.bannedPlayers }
                .function("operators", 0) { it.target?.operators }
                .function("defaultGameMode", 0) { it.target?.defaultGameMode }
                .function("setDefaultGameMode", 1) { it.target?.setDefaultGameMode(it.getArgument(0) as GameMode) }
                .function("consoleSender", 0) { it.target?.consoleSender }
                .function("worldContainer", 0) { it.target?.worldContainer }
                .function("offlinePlayers", 0) { it.target?.offlinePlayers }
                .function("messenger", 0) { it.target?.messenger }
                .function("helpMap", 0) { it.target?.helpMap }
                .function("createInventory", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        when (val var2 = it.getArgument(1)) {
                            is InventoryType -> it.target?.createInventory(it.getArgument(0) as? InventoryHolder, var2)
                            is Int -> it.target?.createInventory(it.getArgument(0) as? InventoryHolder, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 InventoryType 或 Int 类型")
                        }
                    } else {
                        when (val var2 = it.getArgument(1)) {
                            is InventoryType -> it.target?.createInventory(
                                it.getArgument(0) as? InventoryHolder,
                                var2,
                                it.getString(2)!!
                            )

                            is Int -> it.target?.createInventory(
                                it.getArgument(0) as? InventoryHolder,
                                var2,
                                it.getString(2)!!
                            )

                            else -> throw IllegalArgumentException("参数 2 必须是 InventoryType 或 Int 类型")
                        }
                    }
                }
                .function("createMerchant", 1) { it.target?.createMerchant(it.getString(0)) }
                .function("maxChainedNeighborUpdates", 0) { it.target?.maxChainedNeighborUpdates }
                .function("monsterSpawnLimit", 0) { it.target?.monsterSpawnLimit }
                .function("animalSpawnLimit", 0) { it.target?.animalSpawnLimit }
                .function("waterAnimalSpawnLimit", 0) { it.target?.waterAnimalSpawnLimit }
                .function("waterAmbientSpawnLimit", 0) { it.target?.waterAmbientSpawnLimit }
                .function(
                    "waterUndergroundCreatureSpawnLimit",
                    0
                ) { it.target?.waterUndergroundCreatureSpawnLimit }
                .function("ambientSpawnLimit", 0) { it.target?.ambientSpawnLimit }
                .function("getSpawnLimit", 1) { it.target?.getSpawnLimit(it.getArgument(0) as SpawnCategory) }
                .function("isPrimaryThread", 0) { it.target?.isPrimaryThread }
                .function("motd", 0) { it.target?.motd }
                .function("setMotd", 1) { it.target?.setMotd(it.getString(0)!!) }
                .function("shutdownMessage", 0) { it.target?.shutdownMessage }
                .function("itemFactory", 0) { it.target?.itemFactory }
                .function("entityFactory", 0) { it.target?.entityFactory }
                .function("scoreboardManager", 0) { it.target?.scoreboardManager }
                .function("getScoreboardCriteria", 1) { it.target?.getScoreboardCriteria(it.getString(0)!!) }
                .function("serverIcon", 0) { it.target?.serverIcon }
                .function("loadServerIcon", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is File -> it.target?.loadServerIcon(var1)
                        is BufferedImage -> it.target?.loadServerIcon(var1)
                        else -> throw IllegalArgumentException("参数必须是 File 或 BufferedImage 类型")
                    }
                }
                .function("setIdleTimeout", 1) { it.target?.setIdleTimeout(it.getNumber(0).toInt()) }
                .function("idleTimeout", 0) { it.target?.idleTimeout }
                .function("createBossBar", listOf(3, 4)) {
                    if (it.arguments.size == 3) {
                        it.target?.createBossBar(
                            it.getString(0),
                            it.getArgument(1) as BarColor,
                            it.getArgument(2) as BarStyle
                        )
                    } else {
                        it.target?.createBossBar(
                            it.getArgument(0) as NamespacedKey,
                            it.getString(1),
                            it.getArgument(2) as BarColor,
                            it.getArgument(3) as BarStyle
                        )
                    }
                }
                .function("bossBars", 0) { it.target?.bossBars }
                .function("getBossBar", 1) { it.target?.getBossBar(it.getArgument(0) as NamespacedKey) }
                .function("removeBossBar", 1) { it.target?.removeBossBar(it.getArgument(0) as NamespacedKey) }
                .function("getEntity", 1) { it.target?.getEntity(UUID.fromString(it.getString(0))) }
                .function("getAdvancement", 1) { it.target?.getAdvancement(it.getArgument(0) as NamespacedKey) }
                .function("advancementIterator", 0) { it.target?.advancementIterator() }
                .function("createBlockData", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        when (val var1 = it.getArgument(0)) {
                            is Material -> it.target?.createBlockData(var1)
                            is String -> it.target?.createBlockData(var1)
                            else -> throw IllegalArgumentException("参数必须是 Material 或 String 类型")
                        }
                    } else {
                        it.target?.createBlockData(
                            it.getArgument(0) as Material,
                            it.getString(1)
                        )
                    }
                }
                .function("getLootTable", 1) { it.target?.getLootTable(it.getArgument(0) as NamespacedKey) }
                .function("selectEntities", 2) {
                    it.target?.selectEntities(
                        it.getArgument(0) as CommandSender,
                        it.getString(1)!!
                    )
                }
                .function("structureManager", 0) { it.target?.structureManager }
                .function("unsafe", 0) { it.target?.unsafe }
        }
    }
}
