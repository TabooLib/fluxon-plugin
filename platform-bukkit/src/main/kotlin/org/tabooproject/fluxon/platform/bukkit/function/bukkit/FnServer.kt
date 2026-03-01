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
                .function("ip", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.ip) }
                .function("worldType", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.worldType) }
                .function("generateStructures", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.generateStructures ?: false) }
                .function("maxWorldSize", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxWorldSize ?: 0) }
                .function("allowEnd", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.allowEnd ?: false) }
                .function("allowNether", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.allowNether ?: false) }
                .function("isLoggingIPs", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLoggingIPs ?: false) }
                .function("initialEnabledPacks", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.initialEnabledPacks) }
                .function("initialDisabledPacks", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.initialDisabledPacks) }
                .function("dataPackManager", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.packs.FnDataPackManager.TYPE).noParams()) { it.setReturnRef(it.target?.dataPackManager) }
                .function("serverTickManager", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnServerTickManager.TYPE).noParams()) { it.setReturnRef(it.target?.serverTickManager) }
                .function("serverResourcePack", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.packs.FnResourcePack.TYPE).noParams()) { it.setReturnRef(it.target?.serverResourcePack) }
                .function("resourcePack", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.resourcePack) }
                .function("resourcePackHash", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.resourcePackHash) }
                .function("resourcePackPrompt", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.resourcePackPrompt) }
                .function("isResourcePackRequired", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isResourcePackRequired ?: false) }
                .function("hasWhitelist", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasWhitelist() ?: false) }
                .function("setWhitelist", returnsVoid().params(Type.Z)) { it.target?.setWhitelist(it.getBool(0)) }
                .function("isWhitelistEnforced", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isWhitelistEnforced ?: false) }
                .function("setWhitelistEnforced", returnsVoid().params(Type.Z)) { it.target?.setWhitelistEnforced(it.getBool(0)) }
                .function("whitelistedPlayers", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.whitelistedPlayers) }
                .function("reloadWhitelist", returnsVoid().noParams()) { it.target?.reloadWhitelist() }
                .function("broadcastMessage", returns(Type.I).params(Type.STRING)) {
                    it.setReturnInt(it.target?.broadcastMessage(it.getString(0)!!) ?: 0)
                }
                .function("updateFolder", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.updateFolder) }
                .function("updateFolderFile", returns(Type.FILE).noParams()) { it.setReturnRef(it.target?.updateFolderFile) }
                .function("connectionThrottle", returns(Type.J).noParams()) { it.setReturnLong(it.target?.connectionThrottle ?: 0) }
                .function("ticksPerAnimalSpawns", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksPerAnimalSpawns ?: 0) }
                .function("ticksPerMonsterSpawns", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksPerMonsterSpawns ?: 0) }
                .function("ticksPerWaterSpawns", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksPerWaterSpawns ?: 0) }
                .function("ticksPerWaterAmbientSpawns", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksPerWaterAmbientSpawns ?: 0) }
                .function("ticksPerWaterUndergroundCreatureSpawns", returns(Type.I).noParams()) {
                    it.setReturnInt(it.target?.ticksPerWaterUndergroundCreatureSpawns ?: 0)
                }
                .function("ticksPerAmbientSpawns", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksPerAmbientSpawns ?: 0) }
                .function("getTicksPerSpawns", returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpawnCategory.TYPE)) {
                    it.setReturnInt(it.target?.getTicksPerSpawns(it.getRef(0) as SpawnCategory) ?: 0)
                }
                .function("getTicksPerSpawns", returns(Type.I).params(Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpawnCategory.enumValue(it.getString(0))?.let { p0 ->
                        it.setReturnInt(it.target?.getTicksPerSpawns(p0) ?: 0)
                    }
                }
                .function("getPlayer", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getPlayer(it.getString(0)!!)) }
                .function("getPlayer", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE).params(org.tabooproject.fluxon.util.StandardTypes.UUID)) { it.setReturnRef(it.target?.getPlayer(it.getRef(0) as UUID)) }
                .function("getPlayerExact", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getPlayerExact(it.getString(0)!!)) }
                .function("matchPlayer", returns(Type.LIST).params(Type.STRING)) { it.setReturnRef(it.target?.matchPlayer(it.getString(0)!!)) }
                .function("pluginManager", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPluginManager.TYPE).noParams()) { it.setReturnRef(it.target?.pluginManager) }
                .function("scheduler", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler.FnBukkitScheduler.TYPE).noParams()) { it.setReturnRef(it.target?.scheduler) }
                .function("servicesManager", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnServicesManager.TYPE).noParams()) { it.setReturnRef(it.target?.servicesManager) }
                .function("worlds", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.worlds) }
                .function("createWorld",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE)) { it.setReturnRef(it.target?.createWorld(it.getRef(0) as WorldCreator)) }
                .function("unloadWorld", returns(Type.Z).params(Type.STRING, Type.Z)) { it.setReturnBool(it.target?.unloadWorld(it.getString(0)!!, it.getBool(1)) ?: false) }
                .function("unloadWorld", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE, Type.Z)) { it.setReturnBool(it.target?.unloadWorld(it.getRef(0) as World, it.getBool(1)) ?: false) }
                .function("getWorld", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getWorld(it.getString(0)!!)) }
                .function("getWorld", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE).params(org.tabooproject.fluxon.util.StandardTypes.UUID)) { it.setReturnRef(it.target?.getWorld(it.getRef(0) as UUID)) }
                .function("createWorldBorder", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldBorder.TYPE).noParams()) { it.setReturnRef(it.target?.createWorldBorder()) }
                .function("getMap", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapView.TYPE).params(Type.I)) { it.setReturnRef(it.target?.getMap(it.getInt(0).toInt())) }
                .function("createMap",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapView.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) { it.setReturnRef(it.target?.createMap(it.getRef(0) as World)) }
                .function("createExplorerMap",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure.FnStructureType.TYPE)) {
                    it.setReturnRef(it.target?.createExplorerMap(
                        it.getRef(0) as World,
                        it.getRef(1) as Location,
                        it.getRef(2) as StructureType
                    ))
                }
                .function("createExplorerMap",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure.FnStructureType.TYPE, Type.I, Type.Z)) {
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
                .function("logger", returns(Type.fromClass(java.util.logging.Logger::class.java)).noParams()) { it.setReturnRef(it.target?.logger) }
                .function("getPluginCommand", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnPluginCommand.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getPluginCommand(it.getString(0)!!)) }
                .function("savePlayers", returnsVoid().noParams()) { it.target?.savePlayers() }
                .syncFunction("dispatchCommand",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE, Type.STRING)) {
                    it.setReturnBool(it.target?.dispatchCommand(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!
                    ) ?: false)
                }
                .function("addRecipe",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipe.TYPE)) {
                    it.setReturnBool(it.target?.addRecipe(it.getRef(0) as Recipe) ?: false)
                }
                .function("getRecipesFor",returns(Type.LIST).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.setReturnRef(it.target?.getRecipesFor(it.getRef(0) as ItemStack)) }
                .function("getRecipe",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipe.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) { it.setReturnRef(it.target?.getRecipe(it.getRef(0) as NamespacedKey)) }
                .function("getCraftingRecipe",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipe.TYPE).params(Type.fromClass(Array<ItemStack>::class.java), org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) {
                    it.setReturnRef(it.target?.getCraftingRecipe(
                        it.getRef(0) as Array<ItemStack>,
                        it.getRef(1) as World
                    ))
                }
                .function("craftItem",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(Type.fromClass(Array<ItemStack>::class.java), org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) {
                    it.setReturnRef(it.target?.craftItem(
                        it.getRef(0) as Array<ItemStack>,
                        it.getRef(1) as World
                    ))
                }
                .function("craftItem",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(Type.fromClass(Array<ItemStack>::class.java), org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) {
                    it.setReturnRef(it.target?.craftItem(
                        it.getRef(0) as Array<ItemStack>,
                        it.getRef(1) as World,
                        it.getRef(2) as Player
                    ))
                }
                .function("craftItemResult",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemCraftResult.TYPE).params(Type.fromClass(Array<ItemStack>::class.java), org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) {
                    it.setReturnRef(it.target?.craftItemResult(
                        it.getRef(0) as Array<ItemStack>,
                        it.getRef(1) as World
                    ))
                }
                .function("craftItemResult",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemCraftResult.TYPE).params(Type.fromClass(Array<ItemStack>::class.java), org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) {
                    it.setReturnRef(it.target?.craftItemResult(
                        it.getRef(0) as Array<ItemStack>,
                        it.getRef(1) as World,
                        it.getRef(2) as Player
                    ))
                }
                .function("recipeIterator", returns(Type.fromClass(java.util.Iterator::class.java)).noParams()) { it.setReturnRef(it.target?.recipeIterator()) }
                .function("clearRecipes", returnsVoid().noParams()) { it.target?.clearRecipes() }
                .function("resetRecipes", returnsVoid().noParams()) { it.target?.resetRecipes() }
                .function("removeRecipe",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) {
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
                .function("getOfflinePlayer", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnOfflinePlayer.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getOfflinePlayer(it.getString(0)!!)) }
                .function("getOfflinePlayer", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnOfflinePlayer.TYPE).params(org.tabooproject.fluxon.util.StandardTypes.UUID)) { it.setReturnRef(it.target?.getOfflinePlayer(it.getRef(0) as UUID)) }
                .function("createPlayerProfile", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile.FnPlayerProfile.TYPE).params(org.tabooproject.fluxon.util.StandardTypes.UUID)) { it.setReturnRef(it.target?.createPlayerProfile(it.getRef(0) as UUID)) }
                .function("createPlayerProfile", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile.FnPlayerProfile.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.createPlayerProfile(it.getString(0)!!)) }
                .function("createPlayerProfile", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile.FnPlayerProfile.TYPE).params(org.tabooproject.fluxon.util.StandardTypes.UUID, Type.STRING)) {
                    it.setReturnRef(it.target?.createPlayerProfile(it.getRef(0) as UUID, it.getString(1)))
                }
                .function("iPBans", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.ipBans) }
                .function("banIP", returnsVoid().params(Type.STRING)) { it.target?.banIP(it.getString(0)!!) }
                .function("banIP", returnsVoid().params(Type.fromClass(InetAddress::class.java))) { it.target?.banIP(it.getRef(0) as InetAddress) }
                .function("unbanIP", returnsVoid().params(Type.STRING)) { it.target?.unbanIP(it.getString(0)!!) }
                .function("unbanIP", returnsVoid().params(Type.fromClass(InetAddress::class.java))) { it.target?.unbanIP(it.getRef(0) as InetAddress) }
                .function("bannedPlayers", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.bannedPlayers) }
                .function("operators", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.operators) }
                .function("defaultGameMode", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnGameMode.TYPE).noParams()) { it.setReturnRef(it.target?.defaultGameMode) }
                .function("setDefaultGameMode",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnGameMode.TYPE)) { it.target?.setDefaultGameMode(it.getRef(0) as GameMode) }
                .function("consoleSender", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnConsoleCommandSender.TYPE).noParams()) { it.setReturnRef(it.target?.consoleSender) }
                .function("worldContainer", returns(Type.FILE).noParams()) { it.setReturnRef(it.target?.worldContainer) }
                .function("offlinePlayers", returns(Type.fromClass(Array<OfflinePlayer>::class.java)).noParams()) { it.setReturnRef(it.target?.offlinePlayers) }
                .function("messenger", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging.FnMessenger.TYPE).noParams()) { it.setReturnRef(it.target?.messenger) }
                .function("helpMap", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.help.FnHelpMap.TYPE).noParams()) { it.setReturnRef(it.target?.helpMap) }
                .function("createInventory", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryHolder.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory.FnInventoryType.TYPE)) {
                    it.setReturnRef(it.target?.createInventory(it.getRef(0) as? InventoryHolder, it.getRef(1) as InventoryType))
                }
                .function("createInventory", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryHolder.TYPE, Type.I)) {
                    it.setReturnRef(it.target?.createInventory(it.getRef(0) as? InventoryHolder, it.getInt(1)))
                }
                .function("createInventory", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryHolder.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory.FnInventoryType.TYPE, Type.STRING)) {
                    it.setReturnRef(it.target?.createInventory(it.getRef(0) as? InventoryHolder, it.getRef(1) as InventoryType, it.getString(2)!!))
                }
                .function("createInventory", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryHolder.TYPE, Type.I, Type.STRING)) {
                    it.setReturnRef(it.target?.createInventory(it.getRef(0) as? InventoryHolder, it.getInt(1), it.getString(2)!!))
                }
                .function("createMerchant", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnMerchant.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.createMerchant(it.getString(0))) }
                .function("maxChainedNeighborUpdates", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxChainedNeighborUpdates ?: 0) }
                .function("monsterSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.monsterSpawnLimit ?: 0) }
                .function("animalSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.animalSpawnLimit ?: 0) }
                .function("waterAnimalSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.waterAnimalSpawnLimit ?: 0) }
                .function("waterAmbientSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.waterAmbientSpawnLimit ?: 0) }
                .function("waterUndergroundCreatureSpawnLimit", returns(Type.I).noParams()) {
                    it.setReturnInt(it.target?.waterUndergroundCreatureSpawnLimit ?: 0)
                }
                .function("ambientSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ambientSpawnLimit ?: 0) }
                .function("getSpawnLimit", returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpawnCategory.TYPE)) { it.setReturnInt(it.target?.getSpawnLimit(it.getRef(0) as SpawnCategory) ?: 0) }
                .function("getSpawnLimit", returns(Type.I).params(Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpawnCategory.enumValue(it.getString(0))?.let { p0 ->
                        it.setReturnInt(it.target?.getSpawnLimit(p0) ?: 0)
                    }
                }
                .function("isPrimaryThread", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPrimaryThread ?: false) }
                .function("motd", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.motd) }
                .function("setMotd", returnsVoid().params(Type.STRING)) { it.target?.setMotd(it.getString(0)!!) }
                .function("shutdownMessage", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.shutdownMessage) }
                .function("itemFactory", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemFactory.TYPE).noParams()) { it.setReturnRef(it.target?.itemFactory) }
                .function("entityFactory", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityFactory.TYPE).noParams()) { it.setReturnRef(it.target?.entityFactory) }
                .function("scoreboardManager", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnScoreboardManager.TYPE).noParams()) { it.setReturnRef(it.target?.scoreboardManager) }
                .function("getScoreboardCriteria", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnCriteria.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getScoreboardCriteria(it.getString(0)!!)) }
                .function("serverIcon", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnCachedServerIcon.TYPE).noParams()) { it.setReturnRef(it.target?.serverIcon) }
                .function("loadServerIcon", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnCachedServerIcon.TYPE).params(Type.FILE)) { it.setReturnRef(it.target?.loadServerIcon(it.getRef(0) as File)) }
                .function("loadServerIcon", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnCachedServerIcon.TYPE).params(Type.fromClass(BufferedImage::class.java))) { it.setReturnRef(it.target?.loadServerIcon(it.getRef(0) as BufferedImage)) }
                .function("setIdleTimeout", returnsVoid().params(Type.I)) { it.target?.setIdleTimeout(it.getInt(0).toInt()) }
                .function("idleTimeout", returns(Type.I).noParams()) { it.setReturnInt(it.target?.idleTimeout ?: 0) }
                .function("createBossBar", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBossBar.TYPE).params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarColor.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarStyle.TYPE)) {
                    it.setReturnRef(it.target?.createBossBar(
                        it.getString(0),
                        it.getRef(1) as BarColor,
                        it.getRef(2) as BarStyle
                    ))
                }
                .function("createBossBar", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBossBar.TYPE).params(Type.STRING, Type.STRING, Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarColor.enumValue(it.getString(1))?.let { p1 ->
                        org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarStyle.enumValue(it.getString(2))?.let { p2 ->
                            it.setReturnRef(it.target?.createBossBar(it.getString(0), p1, p2))
                        }
                    }
                }
                .function("createBossBar",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBossBar.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarColor.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarStyle.TYPE)) {
                    it.setReturnRef(it.target?.createBossBar(
                        it.getRef(0) as NamespacedKey,
                        it.getString(1),
                        it.getRef(2) as BarColor,
                        it.getRef(3) as BarStyle
                    ))
                }
                .function("createBossBar", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBossBar.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE, Type.STRING, Type.STRING, Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarColor.enumValue(it.getString(2))?.let { p2 ->
                        org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarStyle.enumValue(it.getString(3))?.let { p3 ->
                            it.setReturnRef(it.target?.createBossBar(it.getRef(0) as NamespacedKey, it.getString(1), p2, p3))
                        }
                    }
                }
                .function("bossBars", returns(Type.fromClass(java.util.Iterator::class.java)).noParams()) { it.setReturnRef(it.target?.bossBars) }
                .function("getBossBar",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBossBar.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) { it.setReturnRef(it.target?.getBossBar(it.getRef(0) as NamespacedKey)) }
                .function("removeBossBar",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) {
                    it.setReturnBool(it.target?.removeBossBar(it.getRef(0) as NamespacedKey) ?: false)
                }
                .function("getEntity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).params(org.tabooproject.fluxon.util.StandardTypes.UUID)) { it.setReturnRef(it.target?.getEntity(it.getRef(0) as UUID)) }
                .function("getEntity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getEntity(UUID.fromString(it.getString(0)))) }
                .function("getAdvancement",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement.FnAdvancement.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) { it.setReturnRef(it.target?.getAdvancement(it.getRef(0) as NamespacedKey)) }
                .function("advancementIterator", returns(Type.fromClass(java.util.Iterator::class.java)).noParams()) { it.setReturnRef(it.target?.advancementIterator()) }
                .function("createBlockData", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnRef(it.target?.createBlockData(it.getRef(0) as Material)) }
                .function("createBlockData", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.createBlockData(it.getString(0)!!)) }
                .function("createBlockData", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, Type.STRING)) { it.setReturnRef(it.target?.createBlockData(it.getRef(0) as Material, it.getString(1))) }
                .function("getLootTable",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot.FnLootTable.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) { it.setReturnRef(it.target?.getLootTable(it.getRef(0) as NamespacedKey)) }
                .function("selectEntities",returns(Type.LIST).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE, Type.STRING)) {
                    it.setReturnRef(it.target?.selectEntities(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!
                    ))
                }
                .function("structureManager", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.structure.FnStructureManager.TYPE).noParams()) { it.setReturnRef(it.target?.structureManager) }
                .function("unsafe", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnUnsafeValues.TYPE).noParams()) { it.setReturnRef(it.target?.unsafe) }
        }
    }
}
