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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.Server"])
@PlatformSide(Platform.BUKKIT)
object FnServer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Server::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.target?.name }
                .function("version", returnsObject().noParams()) { it.target?.version }
                .function("bukkitVersion", returnsObject().noParams()) { it.target?.bukkitVersion }
                .function("maxPlayers", returnsObject().noParams()) { it.target?.maxPlayers }
                .function("setMaxPlayers", returnsObject().params(Type.OBJECT)) { it.target?.setMaxPlayers(it.getInt(0).toInt()) }
                .function("port", returnsObject().noParams()) { it.target?.port }
                .function("viewDistance", returnsObject().noParams()) { it.target?.viewDistance }
                .function("simulationDistance", returnsObject().noParams()) { it.target?.simulationDistance }
                .function("ip", returnsObject().noParams()) { it.target?.ip }
                .function("worldType", returnsObject().noParams()) { it.target?.worldType }
                .function("generateStructures", returnsObject().noParams()) { it.target?.generateStructures }
                .function("maxWorldSize", returnsObject().noParams()) { it.target?.maxWorldSize }
                .function("allowEnd", returnsObject().noParams()) { it.target?.allowEnd }
                .function("allowNether", returnsObject().noParams()) { it.target?.allowNether }
                .function("isLoggingIPs", returns(Type.Z).noParams()) { it.target?.isLoggingIPs }
                .function("initialEnabledPacks", returnsObject().noParams()) { it.target?.initialEnabledPacks }
                .function("initialDisabledPacks", returnsObject().noParams()) { it.target?.initialDisabledPacks }
                .function("dataPackManager", returnsObject().noParams()) { it.target?.dataPackManager }
                .function("serverTickManager", returnsObject().noParams()) { it.target?.serverTickManager }
                .function("serverResourcePack", returnsObject().noParams()) { it.target?.serverResourcePack }
                .function("resourcePack", returnsObject().noParams()) { it.target?.resourcePack }
                .function("resourcePackHash", returnsObject().noParams()) { it.target?.resourcePackHash }
                .function("resourcePackPrompt", returnsObject().noParams()) { it.target?.resourcePackPrompt }
                .function("isResourcePackRequired", returns(Type.Z).noParams()) { it.target?.isResourcePackRequired }
                .function("hasWhitelist", returns(Type.Z).noParams()) { it.target?.hasWhitelist() }
                .function("setWhitelist", returnsObject().params(Type.OBJECT)) { it.target?.setWhitelist(it.getBool(0)) }
                .function("isWhitelistEnforced", returns(Type.Z).noParams()) { it.target?.isWhitelistEnforced }
                .function("setWhitelistEnforced", returnsObject().params(Type.OBJECT)) { it.target?.setWhitelistEnforced(it.getBool(0)) }
                .function("whitelistedPlayers", returnsObject().noParams()) { it.target?.whitelistedPlayers }
                .function("reloadWhitelist", returnsObject().noParams()) { it.target?.reloadWhitelist() }
                .function("broadcastMessage", returnsObject().params(Type.OBJECT)) { it.target?.broadcastMessage(it.getString(0)!!) }
                .function("updateFolder", returnsObject().noParams()) { it.target?.updateFolder }
                .function("updateFolderFile", returnsObject().noParams()) { it.target?.updateFolderFile }
                .function("connectionThrottle", returnsObject().noParams()) { it.target?.connectionThrottle }
                .function("ticksPerAnimalSpawns", returnsObject().noParams()) { it.target?.ticksPerAnimalSpawns }
                .function("ticksPerMonsterSpawns", returnsObject().noParams()) { it.target?.ticksPerMonsterSpawns }
                .function("ticksPerWaterSpawns", returnsObject().noParams()) { it.target?.ticksPerWaterSpawns }
                .function("ticksPerWaterAmbientSpawns", returnsObject().noParams()) { it.target?.ticksPerWaterAmbientSpawns }
                .function("ticksPerWaterUndergroundCreatureSpawns", returnsObject().noParams()) { it.target?.ticksPerWaterUndergroundCreatureSpawns }
                .function("ticksPerAmbientSpawns", returnsObject().noParams()) { it.target?.ticksPerAmbientSpawns }
                .function("getTicksPerSpawns", returnsObject().params(Type.OBJECT)) { it.target?.getTicksPerSpawns(it.getRef(0) as SpawnCategory) }
                .function("getPlayer", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.getPlayer(var1)
                        is UUID -> it.target?.getPlayer(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 UUID 类型")
                    }
                }
                .function("getPlayerExact", returnsObject().params(Type.OBJECT)) { it.target?.getPlayerExact(it.getString(0)!!) }
                .function("matchPlayer", returnsObject().params(Type.OBJECT)) { it.target?.matchPlayer(it.getString(0)!!) }
                .function("pluginManager", returnsObject().noParams()) { it.target?.pluginManager }
                .function("scheduler", returnsObject().noParams()) { it.target?.scheduler }
                .function("servicesManager", returnsObject().noParams()) { it.target?.servicesManager }
                .function("worlds", returnsObject().noParams()) { it.target?.worlds }
                .function("createWorld", returnsObject().params(Type.OBJECT)) { it.target?.createWorld(it.getRef(0) as WorldCreator) }
                .function("unloadWorld", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.unloadWorld(var1, it.getBool(1))
                        is World -> it.target?.unloadWorld(var1, it.getBool(1))
                        else -> throw IllegalArgumentException("参数必须是 String 或 World 类型")
                    }
                }
                .function("getWorld", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.getWorld(var1)
                        is UUID -> it.target?.getWorld(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 UUID 类型")
                    }
                }
                .function("createWorldBorder", returnsObject().noParams()) { it.target?.createWorldBorder() }
                .function("getMap", returnsObject().params(Type.OBJECT)) { it.target?.getMap(it.getInt(0).toInt()) }
                .function("createMap", returnsObject().params(Type.OBJECT)) { it.target?.createMap(it.getRef(0) as World) }
                .function("createExplorerMap", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 3) {
                        it.target?.createExplorerMap(
                            it.getRef(0) as World,
                            it.getRef(1) as Location,
                            it.getRef(2) as StructureType
                        )
                    } else {
                        it.target?.createExplorerMap(
                            it.getRef(0) as World,
                            it.getRef(1) as Location,
                            it.getRef(2) as StructureType,
                            it.getInt(3).toInt(),
                            it.getBool(4)
                        )
                    }
                }
                .function("createExplorerMap", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 3) {
                        it.target?.createExplorerMap(
                            it.getRef(0) as World,
                            it.getRef(1) as Location,
                            it.getRef(2) as StructureType
                        )
                    } else {
                        it.target?.createExplorerMap(
                            it.getRef(0) as World,
                            it.getRef(1) as Location,
                            it.getRef(2) as StructureType,
                            it.getInt(3).toInt(),
                            it.getBool(4)
                        )
                    }
                }
                .function("reload", returnsObject().noParams()) { it.target?.reload() }
                .function("reloadData", returnsObject().noParams()) { it.target?.reloadData() }
                .function("logger", returnsObject().noParams()) { it.target?.logger }
                .function("getPluginCommand", returnsObject().params(Type.OBJECT)) { it.target?.getPluginCommand(it.getString(0)!!) }
                .function("savePlayers", returnsObject().noParams()) { it.target?.savePlayers() }
                .syncFunction("dispatchCommand", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.dispatchCommand(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!
                    )
                }
                .function("addRecipe", returnsObject().params(Type.OBJECT)) { it.target?.addRecipe(it.getRef(0) as Recipe) }
                .function("getRecipesFor", returnsObject().params(Type.OBJECT)) { it.target?.getRecipesFor(it.getRef(0) as ItemStack) }
                .function("getRecipe", returnsObject().params(Type.OBJECT)) { it.target?.getRecipe(it.getRef(0) as NamespacedKey) }
                .function("getCraftingRecipe", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.getCraftingRecipe(
                        it.getRef(0) as Array<ItemStack>,
                        it.getRef(1) as World
                    )
                }
                .function("craftItem", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.craftItem(
                            it.getRef(0) as Array<ItemStack>,
                            it.getRef(1) as World
                        )
                    } else {
                        it.target?.craftItem(
                            it.getRef(0) as Array<ItemStack>,
                            it.getRef(1) as World,
                            it.getRef(2) as Player
                        )
                    }
                }
                .function("craftItem", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.craftItem(
                            it.getRef(0) as Array<ItemStack>,
                            it.getRef(1) as World
                        )
                    } else {
                        it.target?.craftItem(
                            it.getRef(0) as Array<ItemStack>,
                            it.getRef(1) as World,
                            it.getRef(2) as Player
                        )
                    }
                }
                .function("craftItemResult", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.craftItemResult(
                            it.getRef(0) as Array<ItemStack>,
                            it.getRef(1) as World
                        )
                    } else {
                        it.target?.craftItemResult(
                            it.getRef(0) as Array<ItemStack>,
                            it.getRef(1) as World,
                            it.getRef(2) as Player
                        )
                    }
                }
                .function("craftItemResult", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.craftItemResult(
                            it.getRef(0) as Array<ItemStack>,
                            it.getRef(1) as World
                        )
                    } else {
                        it.target?.craftItemResult(
                            it.getRef(0) as Array<ItemStack>,
                            it.getRef(1) as World,
                            it.getRef(2) as Player
                        )
                    }
                }
                .function("recipeIterator", returnsObject().noParams()) { it.target?.recipeIterator() }
                .function("clearRecipes", returnsObject().noParams()) { it.target?.clearRecipes() }
                .function("resetRecipes", returnsObject().noParams()) { it.target?.resetRecipes() }
                .function("removeRecipe", returnsObject().params(Type.OBJECT)) { it.target?.removeRecipe(it.getRef(0) as NamespacedKey) }
                .function("spawnRadius", returnsObject().noParams()) { it.target?.spawnRadius }
                .function("setSpawnRadius", returnsObject().params(Type.OBJECT)) { it.target?.setSpawnRadius(it.getInt(0).toInt()) }
                .function("shouldSendChatPreviews", returns(Type.Z).noParams()) { it.target?.shouldSendChatPreviews() }
                .function("isEnforcingSecureProfiles", returns(Type.Z).noParams()) { it.target?.isEnforcingSecureProfiles }
                .function("isAcceptingTransfers", returns(Type.Z).noParams()) { it.target?.isAcceptingTransfers }
                .function("hideOnlinePlayers", returnsObject().noParams()) { it.target?.hideOnlinePlayers }
                .function("onlineMode", returnsObject().noParams()) { it.target?.onlineMode }
                .function("allowFlight", returnsObject().noParams()) { it.target?.allowFlight }
                .function("isHardcore", returns(Type.Z).noParams()) { it.target?.isHardcore }
                .function("shutdown", returnsObject().noParams()) { it.target?.shutdown() }
                .function("broadcast", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.broadcast(it.getString(0)!!, it.getString(1)!!) }
                .function("getOfflinePlayer", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.getOfflinePlayer(var1)
                        is UUID -> it.target?.getOfflinePlayer(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 UUID 类型")
                    }
                }
                .function("createPlayerProfile", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
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
                .function("createPlayerProfile", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
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
                .function("iPBans", returnsObject().noParams()) { it.target?.ipBans }
                .function("banIP", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.banIP(var1)
                        is InetAddress -> it.target?.banIP(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 InetAddress 类型")
                    }
                }
                .function("unbanIP", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.unbanIP(var1)
                        is InetAddress -> it.target?.unbanIP(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 InetAddress 类型")
                    }
                }
                .function("bannedPlayers", returnsObject().noParams()) { it.target?.bannedPlayers }
                .function("operators", returnsObject().noParams()) { it.target?.operators }
                .function("defaultGameMode", returnsObject().noParams()) { it.target?.defaultGameMode }
                .function("setDefaultGameMode", returnsObject().params(Type.OBJECT)) { it.target?.setDefaultGameMode(it.getRef(0) as GameMode) }
                .function("consoleSender", returnsObject().noParams()) { it.target?.consoleSender }
                .function("worldContainer", returnsObject().noParams()) { it.target?.worldContainer }
                .function("offlinePlayers", returnsObject().noParams()) { it.target?.offlinePlayers }
                .function("messenger", returnsObject().noParams()) { it.target?.messenger }
                .function("helpMap", returnsObject().noParams()) { it.target?.helpMap }
                .function("createInventory", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        when (val var2 = it.getRef(1)) {
                            is InventoryType -> it.target?.createInventory(it.getRef(0) as? InventoryHolder, var2)
                            is Int -> it.target?.createInventory(it.getRef(0) as? InventoryHolder, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 InventoryType 或 Int 类型")
                        }
                    } else {
                        when (val var2 = it.getRef(1)) {
                            is InventoryType -> it.target?.createInventory(
                                it.getRef(0) as? InventoryHolder,
                                var2,
                                it.getString(2)!!
                            )

                            is Int -> it.target?.createInventory(
                                it.getRef(0) as? InventoryHolder,
                                var2,
                                it.getString(2)!!
                            )

                            else -> throw IllegalArgumentException("参数 2 必须是 InventoryType 或 Int 类型")
                        }
                    }
                }
                .function("createInventory", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        when (val var2 = it.getRef(1)) {
                            is InventoryType -> it.target?.createInventory(it.getRef(0) as? InventoryHolder, var2)
                            is Int -> it.target?.createInventory(it.getRef(0) as? InventoryHolder, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 InventoryType 或 Int 类型")
                        }
                    } else {
                        when (val var2 = it.getRef(1)) {
                            is InventoryType -> it.target?.createInventory(
                                it.getRef(0) as? InventoryHolder,
                                var2,
                                it.getString(2)!!
                            )

                            is Int -> it.target?.createInventory(
                                it.getRef(0) as? InventoryHolder,
                                var2,
                                it.getString(2)!!
                            )

                            else -> throw IllegalArgumentException("参数 2 必须是 InventoryType 或 Int 类型")
                        }
                    }
                }
                .function("createMerchant", returnsObject().params(Type.OBJECT)) { it.target?.createMerchant(it.getString(0)) }
                .function("maxChainedNeighborUpdates", returnsObject().noParams()) { it.target?.maxChainedNeighborUpdates }
                .function("monsterSpawnLimit", returnsObject().noParams()) { it.target?.monsterSpawnLimit }
                .function("animalSpawnLimit", returnsObject().noParams()) { it.target?.animalSpawnLimit }
                .function("waterAnimalSpawnLimit", returnsObject().noParams()) { it.target?.waterAnimalSpawnLimit }
                .function("waterAmbientSpawnLimit", returnsObject().noParams()) { it.target?.waterAmbientSpawnLimit }
                .function("waterUndergroundCreatureSpawnLimit", returnsObject().noParams()) { it.target?.waterUndergroundCreatureSpawnLimit }
                .function("ambientSpawnLimit", returnsObject().noParams()) { it.target?.ambientSpawnLimit }
                .function("getSpawnLimit", returnsObject().params(Type.OBJECT)) { it.target?.getSpawnLimit(it.getRef(0) as SpawnCategory) }
                .function("isPrimaryThread", returns(Type.Z).noParams()) { it.target?.isPrimaryThread }
                .function("motd", returnsObject().noParams()) { it.target?.motd }
                .function("setMotd", returnsObject().params(Type.OBJECT)) { it.target?.setMotd(it.getString(0)!!) }
                .function("shutdownMessage", returnsObject().noParams()) { it.target?.shutdownMessage }
                .function("itemFactory", returnsObject().noParams()) { it.target?.itemFactory }
                .function("entityFactory", returnsObject().noParams()) { it.target?.entityFactory }
                .function("scoreboardManager", returnsObject().noParams()) { it.target?.scoreboardManager }
                .function("getScoreboardCriteria", returnsObject().params(Type.OBJECT)) { it.target?.getScoreboardCriteria(it.getString(0)!!) }
                .function("serverIcon", returnsObject().noParams()) { it.target?.serverIcon }
                .function("loadServerIcon", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is File -> it.target?.loadServerIcon(var1)
                        is BufferedImage -> it.target?.loadServerIcon(var1)
                        else -> throw IllegalArgumentException("参数必须是 File 或 BufferedImage 类型")
                    }
                }
                .function("setIdleTimeout", returnsObject().params(Type.OBJECT)) { it.target?.setIdleTimeout(it.getInt(0).toInt()) }
                .function("idleTimeout", returnsObject().noParams()) { it.target?.idleTimeout }
                .function("createBossBar", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 3) {
                        it.target?.createBossBar(
                            it.getString(0),
                            it.getRef(1) as BarColor,
                            it.getRef(2) as BarStyle
                        )
                    } else {
                        it.target?.createBossBar(
                            it.getRef(0) as NamespacedKey,
                            it.getString(1),
                            it.getRef(2) as BarColor,
                            it.getRef(3) as BarStyle
                        )
                    }
                }
                .function("createBossBar", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 3) {
                        it.target?.createBossBar(
                            it.getString(0),
                            it.getRef(1) as BarColor,
                            it.getRef(2) as BarStyle
                        )
                    } else {
                        it.target?.createBossBar(
                            it.getRef(0) as NamespacedKey,
                            it.getString(1),
                            it.getRef(2) as BarColor,
                            it.getRef(3) as BarStyle
                        )
                    }
                }
                .function("bossBars", returnsObject().noParams()) { it.target?.bossBars }
                .function("getBossBar", returnsObject().params(Type.OBJECT)) { it.target?.getBossBar(it.getRef(0) as NamespacedKey) }
                .function("removeBossBar", returnsObject().params(Type.OBJECT)) { it.target?.removeBossBar(it.getRef(0) as NamespacedKey) }
                .function("getEntity", returnsObject().params(Type.OBJECT)) { it.target?.getEntity(UUID.fromString(it.getString(0))) }
                .function("getAdvancement", returnsObject().params(Type.OBJECT)) { it.target?.getAdvancement(it.getRef(0) as NamespacedKey) }
                .function("advancementIterator", returnsObject().noParams()) { it.target?.advancementIterator() }
                .function("createBlockData", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Material -> it.target?.createBlockData(var1)
                            is String -> it.target?.createBlockData(var1)
                            else -> throw IllegalArgumentException("参数必须是 Material 或 String 类型")
                        }
                    } else {
                        it.target?.createBlockData(
                            it.getRef(0) as Material,
                            it.getString(1)
                        )
                    }
                }
                .function("createBlockData", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Material -> it.target?.createBlockData(var1)
                            is String -> it.target?.createBlockData(var1)
                            else -> throw IllegalArgumentException("参数必须是 Material 或 String 类型")
                        }
                    } else {
                        it.target?.createBlockData(
                            it.getRef(0) as Material,
                            it.getString(1)
                        )
                    }
                }
                .function("getLootTable", returnsObject().params(Type.OBJECT)) { it.target?.getLootTable(it.getRef(0) as NamespacedKey) }
                .function("selectEntities", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.selectEntities(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!
                    )
                }
                .function("structureManager", returnsObject().noParams()) { it.target?.structureManager }
                .function("unsafe", returnsObject().noParams()) { it.target?.unsafe }
        }
    }
}
