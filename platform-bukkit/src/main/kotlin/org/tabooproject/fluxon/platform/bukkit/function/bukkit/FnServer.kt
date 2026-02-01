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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.Server"])
@PlatformSide(Platform.BUKKIT)
object FnServer {

    val TYPE = Type.fromClass(Server::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Server::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("version", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.version) }
                .function("bukkitVersion", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.bukkitVersion) }
                .function("maxPlayers", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxPlayers ?: 0) }
                .function("setMaxPlayers", returnsVoid().params(Type.I)) { it.target?.setMaxPlayers(it.getInt(0).toInt()) }
                .function("port", returns(Type.I).noParams()) { it.setReturnInt(it.target?.port ?: 0) }
                .function("viewDistance", returns(Type.I).noParams()) { it.setReturnInt(it.target?.viewDistance ?: 0) }
                .function("simulationDistance", returns(Type.I).noParams()) { it.setReturnInt(it.target?.simulationDistance ?: 0) }
                .function("ip", returnsObject().noParams()) { it.setReturnRef(it.target?.ip) }
                .function("worldType", returnsObject().noParams()) { it.setReturnRef(it.target?.worldType) }
                .function("generateStructures", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.generateStructures ?: false) }
                .function("maxWorldSize", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxWorldSize ?: 0) }
                .function("allowEnd", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.allowEnd ?: false) }
                .function("allowNether", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.allowNether ?: false) }
                .function("isLoggingIPs", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLoggingIPs ?: false) }
                .function("initialEnabledPacks", returnsObject().noParams()) { it.setReturnRef(it.target?.initialEnabledPacks) }
                .function("initialDisabledPacks", returnsObject().noParams()) { it.setReturnRef(it.target?.initialDisabledPacks) }
                .function("dataPackManager", returnsObject().noParams()) { it.setReturnRef(it.target?.dataPackManager) }
                .function("serverTickManager", returnsObject().noParams()) { it.setReturnRef(it.target?.serverTickManager) }
                .function("serverResourcePack", returnsObject().noParams()) { it.setReturnRef(it.target?.serverResourcePack) }
                .function("resourcePack", returnsObject().noParams()) { it.setReturnRef(it.target?.resourcePack) }
                .function("resourcePackHash", returnsObject().noParams()) { it.setReturnRef(it.target?.resourcePackHash) }
                .function("resourcePackPrompt", returnsObject().noParams()) { it.setReturnRef(it.target?.resourcePackPrompt) }
                .function("isResourcePackRequired", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isResourcePackRequired ?: false) }
                .function("hasWhitelist", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasWhitelist() ?: false) }
                .function("setWhitelist", returnsVoid().params(Type.Z)) { it.target?.setWhitelist(it.getBool(0)) }
                .function("isWhitelistEnforced", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isWhitelistEnforced ?: false) }
                .function("setWhitelistEnforced", returnsVoid().params(Type.Z)) { it.target?.setWhitelistEnforced(it.getBool(0)) }
                .function("whitelistedPlayers", returnsObject().noParams()) { it.setReturnRef(it.target?.whitelistedPlayers) }
                .function("reloadWhitelist", returnsVoid().noParams()) { it.target?.reloadWhitelist() }
                .function("broadcastMessage", returns(Type.I).params(Type.STRING)) {
                    it.setReturnInt(it.target?.broadcastMessage(it.getString(0)!!) ?: 0)
                }
                .function("updateFolder", returnsObject().noParams()) { it.setReturnRef(it.target?.updateFolder) }
                .function("updateFolderFile", returnsObject().noParams()) { it.setReturnRef(it.target?.updateFolderFile) }
                .function("connectionThrottle", returns(Type.J).noParams()) { it.setReturnLong(it.target?.connectionThrottle ?: 0) }
                .function("ticksPerAnimalSpawns", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksPerAnimalSpawns ?: 0) }
                .function("ticksPerMonsterSpawns", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksPerMonsterSpawns ?: 0) }
                .function("ticksPerWaterSpawns", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksPerWaterSpawns ?: 0) }
                .function("ticksPerWaterAmbientSpawns", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksPerWaterAmbientSpawns ?: 0) }
                .function("ticksPerWaterUndergroundCreatureSpawns", returns(Type.I).noParams()) {
                    it.setReturnInt(it.target?.ticksPerWaterUndergroundCreatureSpawns ?: 0)
                }
                .function("ticksPerAmbientSpawns", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksPerAmbientSpawns ?: 0) }
                .function("getTicksPerSpawns", returns(Type.I).params(Type.OBJECT)) {
                    it.setReturnInt(it.target?.getTicksPerSpawns(it.getRef(0) as SpawnCategory) ?: 0)
                }
                .function("getPlayer", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is String -> it.target?.getPlayer(var1)
                        is UUID -> it.target?.getPlayer(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 UUID 类型")
                    })
                }
                .function("getPlayerExact", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getPlayerExact(it.getString(0)!!)) }
                .function("matchPlayer", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.matchPlayer(it.getString(0)!!)) }
                .function("pluginManager", returnsObject().noParams()) { it.setReturnRef(it.target?.pluginManager) }
                .function("scheduler", returnsObject().noParams()) { it.setReturnRef(it.target?.scheduler) }
                .function("servicesManager", returnsObject().noParams()) { it.setReturnRef(it.target?.servicesManager) }
                .function("worlds", returnsObject().noParams()) { it.setReturnRef(it.target?.worlds) }
                .function("createWorld", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.createWorld(it.getRef(0) as WorldCreator)) }
                .function("unloadWorld", returns(Type.Z).params(Type.OBJECT, Type.Z)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is String -> it.target?.unloadWorld(var1, it.getBool(1))
                        is World -> it.target?.unloadWorld(var1, it.getBool(1))
                        else -> throw IllegalArgumentException("参数必须是 String 或 World 类型")
                    } ?: false)
                }
                .function("getWorld", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is String -> it.target?.getWorld(var1)
                        is UUID -> it.target?.getWorld(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 UUID 类型")
                    })
                }
                .function("createWorldBorder", returnsObject().noParams()) { it.setReturnRef(it.target?.createWorldBorder()) }
                .function("getMap", returnsObject().params(Type.I)) { it.setReturnRef(it.target?.getMap(it.getInt(0).toInt())) }
                .function("createMap", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.createMap(it.getRef(0) as World)) }
                .function("createExplorerMap", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.createExplorerMap(
                        it.getRef(0) as World,
                        it.getRef(1) as Location,
                        it.getRef(2) as StructureType
                    ))
                }
                .function("createExplorerMap", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.I, Type.Z)) {
                    it.setReturnRef(it.target?.createExplorerMap(
                        it.getRef(0) as World,
                        it.getRef(1) as Location,
                        it.getRef(2) as StructureType,
                        it.getInt(3).toInt(),
                        it.getBool(4)
                    ))
                }
                .function("reload", returnsVoid().noParams()) { it.target?.reload() }
                .function("reloadData", returnsVoid().noParams()) { it.target?.reloadData() }
                .function("logger", returnsObject().noParams()) { it.setReturnRef(it.target?.logger) }
                .function("getPluginCommand", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getPluginCommand(it.getString(0)!!)) }
                .function("savePlayers", returnsVoid().noParams()) { it.target?.savePlayers() }
                .syncFunction("dispatchCommand", returns(Type.Z).params(Type.OBJECT, Type.STRING)) {
                    it.setReturnBool(it.target?.dispatchCommand(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!
                    ) ?: false)
                }
                .function("addRecipe", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.addRecipe(it.getRef(0) as Recipe) ?: false)
                }
                .function("getRecipesFor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getRecipesFor(it.getRef(0) as ItemStack)) }
                .function("getRecipe", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getRecipe(it.getRef(0) as NamespacedKey)) }
                .function("getCraftingRecipe", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getCraftingRecipe(
                        it.getRef(0) as Array<ItemStack>,
                        it.getRef(1) as World
                    ))
                }
                .function("craftItem", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.craftItem(
                        it.getRef(0) as Array<ItemStack>,
                        it.getRef(1) as World
                    ))
                }
                .function("craftItem", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.craftItem(
                        it.getRef(0) as Array<ItemStack>,
                        it.getRef(1) as World,
                        it.getRef(2) as Player
                    ))
                }
                .function("craftItemResult", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.craftItemResult(
                        it.getRef(0) as Array<ItemStack>,
                        it.getRef(1) as World
                    ))
                }
                .function("craftItemResult", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.craftItemResult(
                        it.getRef(0) as Array<ItemStack>,
                        it.getRef(1) as World,
                        it.getRef(2) as Player
                    ))
                }
                .function("recipeIterator", returnsObject().noParams()) { it.setReturnRef(it.target?.recipeIterator()) }
                .function("clearRecipes", returnsVoid().noParams()) { it.target?.clearRecipes() }
                .function("resetRecipes", returnsVoid().noParams()) { it.target?.resetRecipes() }
                .function("removeRecipe", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.removeRecipe(it.getRef(0) as NamespacedKey) ?: false)
                }
                .function("spawnRadius", returns(Type.I).noParams()) { it.setReturnInt(it.target?.spawnRadius ?: 0) }
                .function("setSpawnRadius", returnsVoid().params(Type.I)) { it.target?.setSpawnRadius(it.getInt(0).toInt()) }
                .function("shouldSendChatPreviews", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.shouldSendChatPreviews() ?: false) }
                .function("isEnforcingSecureProfiles", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEnforcingSecureProfiles ?: false) }
                .function("isAcceptingTransfers", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAcceptingTransfers ?: false) }
                .function("hideOnlinePlayers", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hideOnlinePlayers ?: false) }
                .function("onlineMode", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.onlineMode ?: false) }
                .function("allowFlight", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.allowFlight ?: false) }
                .function("isHardcore", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isHardcore ?: false) }
                .function("shutdown", returnsVoid().noParams()) { it.target?.shutdown() }
                .function("broadcast", returns(Type.I).params(Type.STRING, Type.STRING)) {
                    it.setReturnInt(it.target?.broadcast(it.getString(0)!!, it.getString(1)!!) ?: 0)
                }
                .function("getOfflinePlayer", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is String -> it.target?.getOfflinePlayer(var1)
                        is UUID -> it.target?.getOfflinePlayer(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 UUID 类型")
                    })
                }
                .function("createPlayerProfile", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is UUID -> it.target?.createPlayerProfile(var1)
                        is String -> it.target?.createPlayerProfile(var1)
                        else -> throw IllegalArgumentException("参数必须是 UUID 或 String 类型")
                    })
                }
                .function("createPlayerProfile", returnsObject().params(Type.STRING, Type.STRING)) {
                    it.setReturnRef(it.target?.createPlayerProfile(
                        UUID.fromString(it.getString(0)),
                        it.getString(1)
                    ))
                }
                .function("iPBans", returnsObject().noParams()) { it.setReturnRef(it.target?.ipBans) }
                .function("banIP", returnsVoid().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.banIP(var1)
                        is InetAddress -> it.target?.banIP(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 InetAddress 类型")
                    }
                }
                .function("unbanIP", returnsVoid().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.unbanIP(var1)
                        is InetAddress -> it.target?.unbanIP(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 InetAddress 类型")
                    }
                }
                .function("bannedPlayers", returnsObject().noParams()) { it.setReturnRef(it.target?.bannedPlayers) }
                .function("operators", returnsObject().noParams()) { it.setReturnRef(it.target?.operators) }
                .function("defaultGameMode", returnsObject().noParams()) { it.setReturnRef(it.target?.defaultGameMode) }
                .function("setDefaultGameMode", returnsVoid().params(Type.OBJECT)) { it.target?.setDefaultGameMode(it.getRef(0) as GameMode) }
                .function("consoleSender", returnsObject().noParams()) { it.setReturnRef(it.target?.consoleSender) }
                .function("worldContainer", returnsObject().noParams()) { it.setReturnRef(it.target?.worldContainer) }
                .function("offlinePlayers", returnsObject().noParams()) { it.setReturnRef(it.target?.offlinePlayers) }
                .function("messenger", returnsObject().noParams()) { it.setReturnRef(it.target?.messenger) }
                .function("helpMap", returnsObject().noParams()) { it.setReturnRef(it.target?.helpMap) }
                .function("createInventory", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var2 = it.getRef(1)) {
                        is InventoryType -> it.target?.createInventory(it.getRef(0) as? InventoryHolder, var2)
                        is Int -> it.target?.createInventory(it.getRef(0) as? InventoryHolder, var2)
                        else -> throw IllegalArgumentException("参数 2 必须是 InventoryType 或 Int 类型")
                    })
                }
                .function("createInventory", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.STRING)) {
                    it.setReturnRef(when (val var2 = it.getRef(1)) {
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
                    })
                }
                .function("createMerchant", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.createMerchant(it.getString(0))) }
                .function("maxChainedNeighborUpdates", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxChainedNeighborUpdates ?: 0) }
                .function("monsterSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.monsterSpawnLimit ?: 0) }
                .function("animalSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.animalSpawnLimit ?: 0) }
                .function("waterAnimalSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.waterAnimalSpawnLimit ?: 0) }
                .function("waterAmbientSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.waterAmbientSpawnLimit ?: 0) }
                .function("waterUndergroundCreatureSpawnLimit", returns(Type.I).noParams()) {
                    it.setReturnInt(it.target?.waterUndergroundCreatureSpawnLimit ?: 0)
                }
                .function("ambientSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ambientSpawnLimit ?: 0) }
                .function("getSpawnLimit", returns(Type.I).params(Type.OBJECT)) {
                    it.setReturnInt(it.target?.getSpawnLimit(it.getRef(0) as SpawnCategory) ?: 0)
                }
                .function("isPrimaryThread", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPrimaryThread ?: false) }
                .function("motd", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.motd) }
                .function("setMotd", returnsVoid().params(Type.STRING)) { it.target?.setMotd(it.getString(0)!!) }
                .function("shutdownMessage", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.shutdownMessage) }
                .function("itemFactory", returnsObject().noParams()) { it.setReturnRef(it.target?.itemFactory) }
                .function("entityFactory", returnsObject().noParams()) { it.setReturnRef(it.target?.entityFactory) }
                .function("scoreboardManager", returnsObject().noParams()) { it.setReturnRef(it.target?.scoreboardManager) }
                .function("getScoreboardCriteria", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getScoreboardCriteria(it.getString(0)!!)) }
                .function("serverIcon", returnsObject().noParams()) { it.setReturnRef(it.target?.serverIcon) }
                .function("loadServerIcon", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is File -> it.target?.loadServerIcon(var1)
                        is BufferedImage -> it.target?.loadServerIcon(var1)
                        else -> throw IllegalArgumentException("参数必须是 File 或 BufferedImage 类型")
                    })
                }
                .function("setIdleTimeout", returnsVoid().params(Type.I)) { it.target?.setIdleTimeout(it.getInt(0).toInt()) }
                .function("idleTimeout", returns(Type.I).noParams()) { it.setReturnInt(it.target?.idleTimeout ?: 0) }
                .function("createBossBar", returnsObject().params(Type.STRING, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.createBossBar(
                        it.getString(0),
                        it.getRef(1) as BarColor,
                        it.getRef(2) as BarStyle
                    ))
                }
                .function("createBossBar", returnsObject().params(Type.OBJECT, Type.STRING, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.createBossBar(
                        it.getRef(0) as NamespacedKey,
                        it.getString(1),
                        it.getRef(2) as BarColor,
                        it.getRef(3) as BarStyle
                    ))
                }
                .function("bossBars", returnsObject().noParams()) { it.setReturnRef(it.target?.bossBars) }
                .function("getBossBar", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getBossBar(it.getRef(0) as NamespacedKey)) }
                .function("removeBossBar", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.removeBossBar(it.getRef(0) as NamespacedKey) ?: false)
                }
                .function("getEntity", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getEntity(UUID.fromString(it.getString(0)))) }
                .function("getAdvancement", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getAdvancement(it.getRef(0) as NamespacedKey)) }
                .function("advancementIterator", returnsObject().noParams()) { it.setReturnRef(it.target?.advancementIterator()) }
                .function("createBlockData", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.createBlockData(var1)
                        is String -> it.target?.createBlockData(var1)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 String 类型")
                    })
                }
                .function("createBlockData", returnsObject().params(Type.OBJECT, Type.STRING)) {
                    it.setReturnRef(it.target?.createBlockData(
                        it.getRef(0) as Material,
                        it.getString(1)
                    ))
                }
                .function("getLootTable", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getLootTable(it.getRef(0) as NamespacedKey)) }
                .function("selectEntities", returnsObject().params(Type.OBJECT, Type.STRING)) {
                    it.setReturnRef(it.target?.selectEntities(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!
                    ))
                }
                .function("structureManager", returnsObject().noParams()) { it.setReturnRef(it.target?.structureManager) }
                .function("unsafe", returnsObject().noParams()) { it.setReturnRef(it.target?.unsafe) }
        }
    }
}
