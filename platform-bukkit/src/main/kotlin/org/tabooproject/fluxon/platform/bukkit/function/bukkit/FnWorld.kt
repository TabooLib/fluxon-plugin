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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.World"])
@PlatformSide(Platform.BUKKIT)
object FnWorld {

    val TYPE = Type.fromClass(World::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("world", returns(TYPE).params(org.tabooproject.fluxon.util.StandardTypes.UUID)) { it.setReturnRef(Bukkit.getWorld(it.getRef(0) as UUID)) }
            registerFunction("world", returns(TYPE).params(Type.STRING)) { it.setReturnRef(Bukkit.getWorld(it.getString(0))) }
            registerFunction("worlds", returns(Type.LIST).noParams()) { it.setReturnRef(Bukkit.getWorlds()) }

            registerExtension(World::class.java)
                .function("getBlockAt",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.setReturnRef(it.target?.getBlockAt(it.getRef(0) as Location))
                }
                .function("getBlockAt", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBlockAt(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getHighestBlockAt",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.setReturnRef(it.target?.getHighestBlockAt(it.getRef(0) as Location))
                }
                .function("getHighestBlockAt", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).params(Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getHighestBlockAt(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("getHighestBlockAt",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnHeightMap.TYPE)) {
                    it.setReturnRef(it.target?.getHighestBlockAt(
                        it.getRef(0) as Location,
                        it.getRef(1) as HeightMap
                    ))
                }
                .function("getHighestBlockAt", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnHeightMap.enumValue(it.getString(1))?.let { p1 ->
                        it.setReturnRef(it.target?.getHighestBlockAt(
                            it.getRef(0) as Location,
                            p1
                        ))
                    }
                }
                .function("getHighestBlockAt", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).params(Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnHeightMap.TYPE)) {
                    it.setReturnRef(it.target?.getHighestBlockAt(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getRef(2) as HeightMap
                    ))
                }
                .function("getHighestBlockAt", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).params(Type.I, Type.I, Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnHeightMap.enumValue(it.getString(2))?.let { p2 ->
                        it.setReturnRef(it.target?.getHighestBlockAt(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            p2
                        ))
                    }
                }
                .function("getChunkAt", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunk.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.setReturnRef(it.target?.getChunkAt(it.getRef(0) as Location)) }
                .function("getChunkAt", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunk.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE)) { it.setReturnRef(it.target?.getChunkAt(it.getRef(0) as Block)) }
                .function("getChunkAt", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunk.TYPE).params(Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getChunkAt(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("getChunkAt", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunk.TYPE).params(Type.I, Type.I, Type.Z)) {
                    it.setReturnRef(it.target?.getChunkAt(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getBool(2)
                    ))
                }
                .function("isChunkLoaded",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunk.TYPE)) {
                    it.setReturnBool(it.target?.isChunkLoaded(it.getRef(0) as Chunk) ?: false)
                }
                .function("isChunkLoaded", returns(Type.Z).params(Type.I, Type.I)) {
                    it.setReturnBool(it.target?.isChunkLoaded(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ) ?: false)
                }
                .function("loadedChunks", returns(Type.fromClass(Array<Chunk>::class.java)).noParams()) { it.setReturnRef(it.target?.loadedChunks) }
                .syncFunction("loadChunk",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunk.TYPE)) {
                    it.target?.loadChunk(it.getRef(0) as Chunk) ?: false
                }
                .syncFunction("loadChunk", returnsVoid().params(Type.I, Type.I)) {
                    it.target?.loadChunk(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ) ?: false
                }
                .syncFunction("loadChunk", returns(Type.Z).params(Type.I, Type.I, Type.Z)) {
                    it.setReturnBool(it.target?.loadChunk(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getBool(2)
                    ) ?: false)
                }
                .function("isChunkGenerated", returns(Type.Z).params(Type.I, Type.I)) {
                    it.setReturnBool(it.target?.isChunkGenerated(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ) ?: false)
                }
                .function("isChunkInUse", returns(Type.Z).params(Type.I, Type.I)) {
                    it.setReturnBool(it.target?.isChunkInUse(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ) ?: false)
                }
                .syncFunction("unloadChunk",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunk.TYPE)) {
                    it.setReturnBool(it.target?.unloadChunk(it.getRef(0) as Chunk) ?: false)
                }
                .syncFunction("unloadChunk", returns(Type.Z).params(Type.I, Type.I)) {
                    it.setReturnBool(it.target?.unloadChunk(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ) ?: false)
                }
                .syncFunction("unloadChunk", returns(Type.Z).params(Type.I, Type.I, Type.Z)) {
                    it.setReturnBool(it.target?.unloadChunk(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getBool(2)
                    ) ?: false)
                }
                .syncFunction("unloadChunkRequest", returns(Type.Z).params(Type.I, Type.I)) {
                    it.setReturnBool(it.target?.unloadChunkRequest(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ) ?: false)
                }
                .function("regenerateChunk", returns(Type.Z).params(Type.I, Type.I)) {
                    it.setReturnBool(it.target?.regenerateChunk(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ) ?: false)
                }
                .function("refreshChunk", returns(Type.Z).params(Type.I, Type.I)) {
                    it.setReturnBool(it.target?.refreshChunk(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ) ?: false)
                }
                .function("getPlayersSeeingChunk",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunk.TYPE)) {
                    it.setReturnRef(it.target?.getPlayersSeeingChunk(it.getRef(0) as Chunk))
                }
                .function("getPlayersSeeingChunk", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getPlayersSeeingChunk(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("isChunkForceLoaded", returns(Type.Z).params(Type.I, Type.I)) {
                    it.setReturnBool(it.target?.isChunkForceLoaded(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ) ?: false)
                }
                .function("setChunkForceLoaded", returnsVoid().params(Type.I, Type.I, Type.Z)) {
                    it.target?.setChunkForceLoaded(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getBool(2)
                    )
                }
                .function("forceLoadedChunks", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.forceLoadedChunks) }
                .function("addPluginChunkTicket",returns(Type.Z).params(Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.setReturnBool(it.target?.addPluginChunkTicket(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getRef(2) as Plugin
                    ) ?: false)
                }
                .function("removePluginChunkTicket",returns(Type.Z).params(Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.setReturnBool(it.target?.removePluginChunkTicket(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getRef(2) as Plugin
                    ) ?: false)
                }
                .function("removePluginChunkTickets",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.target?.removePluginChunkTickets(it.getRef(0) as Plugin) }
                .function("pluginChunkTickets", returns(Type.MAP).noParams()) { it.setReturnRef(it.target?.pluginChunkTickets) }
                .function("getPluginChunkTickets", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getPluginChunkTickets(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("getIntersectingChunks",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE)) { it.setReturnRef(it.target?.getIntersectingChunks(it.getRef(0) as BoundingBox)) }
                .syncFunction("dropItem",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnItem.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.setReturnRef(it.target?.dropItem(it.getRef(0) as Location, it.getRef(1) as ItemStack)) }
                .syncFunction("dropItemNaturally",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnItem.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.setReturnRef(it.target?.dropItemNaturally(it.getRef(0) as Location, it.getRef(1) as ItemStack)) }
                .syncFunction("spawnArrow",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnArrow.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.F, Type.F)) {
                    it.setReturnRef(it.target?.spawnArrow(
                        it.getRef(0) as Location,
                        it.getRef(1) as Vector,
                        it.getFloat(2),
                        it.getFloat(3)
                    ))
                }
                .syncFunction("generateTree",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnTreeType.TYPE)) {
                    it.setReturnBool(it.target?.generateTree(
                        it.getRef(0) as Location,
                        it.getRef(1) as TreeType
                    ) ?: false)
                }
                .syncFunction("generateTree",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnTreeType.enumValue(it.getString(1))?.let { p1 ->
                        it.setReturnBool(it.target?.generateTree(
                            it.getRef(0) as Location,
                            p1
                        ) ?: false)
                    }
                }
                .syncFunction("generateTree",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnTreeType.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBlockChangeDelegate.TYPE)) {
                    it.setReturnBool(it.target?.generateTree(
                        it.getRef(0) as Location,
                        it.getRef(1) as TreeType,
                        it.getRef(2) as BlockChangeDelegate
                    ) ?: false)
                }
                .syncFunction("generateTree",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBlockChangeDelegate.TYPE)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnTreeType.enumValue(it.getString(1))?.let { p1 ->
                        it.setReturnBool(it.target?.generateTree(
                            it.getRef(0) as Location,
                            p1,
                            it.getRef(2) as BlockChangeDelegate
                        ) ?: false)
                    }
                }
                .syncFunction("strikeLightning",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLightningStrike.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.setReturnRef(it.target?.strikeLightning(it.getRef(0) as Location)) }
                .syncFunction("strikeLightningEffect",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLightningStrike.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.setReturnRef(it.target?.strikeLightningEffect(it.getRef(0) as Location)) }
                .function("entities", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.entities) }
                .function("livingEntities", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.livingEntities) }
                .function("entitiesByClasses", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.getEntitiesByClasses()) }
                .function("players", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.players) }
                .function("getNearbyEntities",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE)) {
                    it.setReturnRef(it.target?.getNearbyEntities(it.getRef(0) as BoundingBox))
                }
                .function("getNearbyEntities",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.getNearbyEntities(
                        it.getRef(0) as Location,
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3)
                    ))
                }
                .function("rayTraceEntities",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnRayTraceResult.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.D)) {
                    it.setReturnRef(it.target?.rayTraceEntities(
                        it.getRef(0) as Location,
                        it.getRef(1) as Vector,
                        it.getDouble(2)
                    ))
                }
                .function("rayTraceEntities",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnRayTraceResult.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.rayTraceEntities(
                        it.getRef(0) as Location,
                        it.getRef(1) as Vector,
                        it.getDouble(2),
                        it.getDouble(3)
                    ))
                }
                .function("rayTraceBlocks",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnRayTraceResult.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.D)) {
                    it.setReturnRef(it.target?.rayTraceBlocks(
                        it.getRef(0) as Location,
                        it.getRef(1) as Vector,
                        it.getDouble(2)
                    ))
                }
                .function("rayTraceBlocks",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnRayTraceResult.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.D, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFluidCollisionMode.TYPE)) {
                    it.setReturnRef(it.target?.rayTraceBlocks(
                        it.getRef(0) as Location,
                        it.getRef(1) as Vector,
                        it.getDouble(2),
                        it.getRef(3) as FluidCollisionMode
                    ))
                }
                .function("rayTraceBlocks",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnRayTraceResult.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.D, Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFluidCollisionMode.enumValue(it.getString(3))?.let { p3 ->
                        it.setReturnRef(it.target?.rayTraceBlocks(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getDouble(2),
                            p3
                        ))
                    }
                }
                .function("rayTraceBlocks",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnRayTraceResult.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.D, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFluidCollisionMode.TYPE, Type.Z)) {
                    it.setReturnRef(it.target?.rayTraceBlocks(
                        it.getRef(0) as Location,
                        it.getRef(1) as Vector,
                        it.getDouble(2),
                        it.getRef(3) as FluidCollisionMode,
                        it.getBool(4)
                    ))
                }
                .function("rayTraceBlocks",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnRayTraceResult.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.D, Type.STRING, Type.Z)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFluidCollisionMode.enumValue(it.getString(3))?.let { p3 ->
                        it.setReturnRef(it.target?.rayTraceBlocks(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getDouble(2),
                            p3,
                            it.getBool(4)
                        ))
                    }
                }
//                .function("rayTrace",returns(Type.I).params(Type.STRING, Type.STRING, Type.I, Type.I, Type.I, Type.J, Type.D)) {
//                    it.setReturnRef(it.target?.rayTrace(
//                        it.getRef(0) as Location,
//                        it.getRef(1) as Vector,
//                        it.getDouble(2),
//                        it.getRef(3) as FluidCollisionMode,
//                        it.getBool(4),
//                        it.getDouble(5),
//                        it.getRef(6) as Predicate<Entity>
//                    ))
//                }
                .function("spawnLocation", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.spawnLocation) }
                .function("setSpawnLocation",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.setReturnBool(it.target?.setSpawnLocation(it.getRef(0) as Location) ?: false)
                }
                .function("setSpawnLocation", returns(Type.Z).params(Type.I, Type.I, Type.I)) {
                    it.setReturnBool(it.target?.setSpawnLocation(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ) ?: false)
                }
                .function("setSpawnLocation", returns(Type.Z).params(Type.I, Type.I, Type.I, Type.F)) {
                    it.setReturnBool(it.target?.setSpawnLocation(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getFloat(3)
                    ) ?: false)
                }
                .function("time", returns(Type.J).noParams()) { it.setReturnLong(it.target?.time ?: 0L) }
                .function("setTime", returnsVoid().params(Type.J)) { it.target?.setTime(it.getLong(0)) }
                .function("fullTime", returns(Type.J).noParams()) { it.setReturnLong(it.target?.fullTime ?: 0L) }
                .function("setFullTime", returnsVoid().params(Type.J)) { it.target?.setFullTime(it.getLong(0)) }
                .function("gameTime", returns(Type.J).noParams()) { it.setReturnLong(it.target?.gameTime ?: 0L) }
                .function("hasStorm", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasStorm() ?: false) }
                .function("setStorm", returnsVoid().params(Type.Z)) { it.target?.setStorm(it.getBool(0)) }
                .function("weatherDuration", returns(Type.I).noParams()) { it.setReturnInt(it.target?.weatherDuration ?: 0) }
                .function("setWeatherDuration", returnsVoid().params(Type.I)) { it.target?.setWeatherDuration(it.getInt(0).toInt()) }
                .function("isThundering", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isThundering ?: false) }
                .function("setThundering", returnsVoid().params(Type.Z)) { it.target?.setThundering(it.getBool(0)) }
                .function("thunderDuration", returns(Type.I).noParams()) { it.setReturnInt(it.target?.thunderDuration ?: 0) }
                .function("setThunderDuration", returnsVoid().params(Type.I)) { it.target?.setThunderDuration(it.getInt(0).toInt()) }
                .function("isClearWeather", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isClearWeather ?: false) }
                .function("setClearWeatherDuration", returnsVoid().params(Type.I)) { it.target?.setClearWeatherDuration(it.getInt(0).toInt()) }
                .function("clearWeatherDuration", returns(Type.I).noParams()) { it.setReturnInt(it.target?.clearWeatherDuration ?: 0) }
                .syncFunction("createExplosion",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.F)) {
                    it.setReturnBool(it.target?.createExplosion(
                        it.getRef(0) as Location,
                        it.getFloat(1)
                    ) ?: false)
                }
                .syncFunction("createExplosion",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.F, Type.Z)) {
                    it.setReturnBool(it.target?.createExplosion(
                        it.getRef(0) as Location,
                        it.getFloat(1),
                        it.getBool(2)
                    ) ?: false)
                }
                .syncFunction("createExplosion",returns(Type.Z).params(Type.D, Type.F, Type.D, Type.F)) {
                    it.setReturnBool(when (it.getRef(0)) {
                        is Location -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1),
                            it.getBool(2),
                            it.getBool(3)
                        )

                        is Number -> it.target?.createExplosion(
                            it.getDouble(0),
                            it.getDouble(1),
                            it.getDouble(2),
                            it.getFloat(3)
                        )

                        else -> throw IllegalArgumentException("参数必须是 Location 或 Number 类型")
                    } ?: false)
                }
                .syncFunction("createExplosion",returns(Type.Z).params(Type.D, Type.F, Type.D, Type.F, Type.Z)) {
                    it.setReturnBool(when (it.getRef(0)) {
                        is Location -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1),
                            it.getBool(2),
                            it.getBool(3),
                            it.getRef(4) as Entity?
                        )

                        is Number -> it.target?.createExplosion(
                            it.getDouble(0),
                            it.getDouble(1),
                            it.getDouble(2),
                            it.getFloat(3),
                            it.getBool(4)
                        )

                        else -> throw IllegalArgumentException("参数必须是 Location 或 Number 类型")
                    } ?: false)
                }
                .syncFunction("createExplosion",returns(Type.Z).params(Type.D, Type.D, Type.D, Type.F, Type.Z, Type.Z)) {
                    it.setReturnBool(it.target?.createExplosion(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getFloat(3),
                        it.getBool(4),
                        it.getBool(5)
                    ) ?: false)
                }
                .syncFunction("createExplosion",returns(Type.Z).params(Type.D, Type.D, Type.D, Type.F, Type.Z, Type.Z, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) {
                    it.setReturnBool(it.target?.createExplosion(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getFloat(3),
                        it.getBool(4),
                        it.getBool(5),
                        it.getRef(6) as Entity
                    ) ?: false)
                }
                .function("pvp", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.pvp ?: false) }
                .function("setPVP", returnsVoid().params(Type.Z)) { it.target?.setPVP(it.getBool(0)) }
                .function("generator", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnChunkGenerator.TYPE).noParams()) { it.setReturnRef(it.target?.generator) }
                .function("biomeProvider", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnBiomeProvider.TYPE).noParams()) { it.setReturnRef(it.target?.biomeProvider) }
                .syncFunction("save", returnsVoid().noParams()) { it.target?.save() }
                .function("populators", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.populators) }
                .syncFunction("spawnFallingBlock",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnFallingBlock.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE)) { it.setReturnRef(it.target?.spawnFallingBlock(it.getRef(0) as Location, it.getRef(1) as MaterialData)) }
                .syncFunction("spawnFallingBlock",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnFallingBlock.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE)) { it.setReturnRef(it.target?.spawnFallingBlock(it.getRef(0) as Location, it.getRef(1) as BlockData)) }
                .syncFunction("spawnFallingBlock",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnFallingBlock.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, Type.I)) {
                    it.setReturnRef(it.target?.spawnFallingBlock(
                        it.getRef(0) as Location,
                        it.getRef(1) as Material,
                        it.getInt(2).toByte()
                    ))
                }
                .function("playEffect",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnEffect.TYPE, Type.I)) {
                    it.target?.playEffect(
                        it.getRef(0) as Location,
                        it.getRef(1) as Effect,
                        it.getInt(2).toInt()
                    )
                }
                .function("playEffect",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnEffect.TYPE, Type.I, Type.I)) {
                    it.target?.playEffect(
                        it.getRef(0) as Location,
                        it.getRef(1) as Effect,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt()
                    )
                }
                .function("getEmptyChunkSnapshot",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunkSnapshot.TYPE).params(Type.I, Type.I, Type.Z, Type.Z)) {
                    it.setReturnRef(it.target?.getEmptyChunkSnapshot(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getBool(2),
                        it.getBool(3)
                    ))
                }
                .function("setSpawnFlags", returnsVoid().params(Type.Z, Type.Z)) { it.target?.setSpawnFlags(it.getBool(0), it.getBool(1)) }
                .function("allowAnimals", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.allowAnimals ?: false) }
                .function("allowMonsters", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.allowMonsters ?: false) }
                .function("getBiome",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.TYPE).params(Type.I, Type.I)) { it.setReturnRef(it.target?.getBiome(it.getInt(0).toInt(), it.getInt(1).toInt())) }
                .syncFunction("setBiome",returnsVoid().params(Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.TYPE)) {
                    it.target?.setBiome(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getRef(2) as Biome
                    )
                }
                .function("getTemperature", returns(Type.D).params(Type.I, Type.I)) {
                    it.setReturnDouble(it.target?.getTemperature(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    )?.toDouble() ?: 0.0)
                }
                .function("getTemperature", returns(Type.D).params(Type.I, Type.I, Type.I)) {
                    it.setReturnDouble(it.target?.getTemperature(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    )?.toDouble() ?: 0.0)
                }
                .function("getHumidity", returns(Type.D).params(Type.I, Type.I)) {
                    it.setReturnDouble(it.target?.getHumidity(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    )?.toDouble() ?: 0.0)
                }
                .function("getHumidity", returns(Type.D).params(Type.I, Type.I, Type.I)) {
                    it.setReturnDouble(it.target?.getHumidity(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    )?.toDouble() ?: 0.0)
                }
                .function("logicalHeight", returns(Type.I).noParams()) { it.setReturnInt(it.target?.logicalHeight ?: 0) }
                .function("isNatural", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isNatural ?: false) }
                .function("isBedWorks", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBedWorks ?: false) }
                .function("hasSkyLight", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasSkyLight() ?: false) }
                .function("hasCeiling", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasCeiling() ?: false) }
                .function("isPiglinSafe", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPiglinSafe ?: false) }
                .function("isRespawnAnchorWorks", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRespawnAnchorWorks ?: false) }
                .function("hasRaids", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasRaids() ?: false) }
                .function("isUltraWarm", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isUltraWarm ?: false) }
                .function("seaLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.seaLevel ?: 0) }
                .function("keepSpawnInMemory", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.keepSpawnInMemory ?: false) }
                .function("setKeepSpawnInMemory", returnsVoid().params(Type.Z)) { it.target?.setKeepSpawnInMemory(it.getBool(0)) }
                .function("isAutoSave", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAutoSave ?: false) }
                .function("setAutoSave", returnsVoid().params(Type.Z)) { it.target?.setAutoSave(it.getBool(0)) }
                .function("setDifficulty",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDifficulty.TYPE)) { it.target?.setDifficulty(it.getRef(0) as Difficulty) }
                .function("difficulty", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDifficulty.TYPE).noParams()) { it.setReturnRef(it.target?.difficulty) }
                .function("viewDistance", returns(Type.I).noParams()) { it.setReturnInt(it.target?.viewDistance ?: 0) }
                .function("simulationDistance", returns(Type.I).noParams()) { it.setReturnInt(it.target?.simulationDistance ?: 0) }
                .function("worldFolder", returns(Type.FILE).noParams()) { it.setReturnRef(it.target?.worldFolder) }
                .function("worldType", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldType.TYPE).noParams()) { it.setReturnRef(it.target?.worldType) }
                .function("canGenerateStructures", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canGenerateStructures() ?: false) }
                .function("isHardcore", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isHardcore ?: false) }
                .function("setHardcore", returnsVoid().params(Type.Z)) { it.target?.setHardcore(it.getBool(0)) }
                .function("ticksPerAnimalSpawns", returns(Type.J).noParams()) { it.setReturnLong(it.target?.ticksPerAnimalSpawns ?: 0) }
                .function("setTicksPerAnimalSpawns", returnsVoid().params(Type.I)) { it.target?.setTicksPerAnimalSpawns(it.getInt(0).toInt()) }
                .function("ticksPerMonsterSpawns", returns(Type.J).noParams()) { it.setReturnLong(it.target?.ticksPerMonsterSpawns ?: 0) }
                .function("setTicksPerMonsterSpawns", returnsVoid().params(Type.I)) {
                    it.target?.setTicksPerMonsterSpawns(
                        it.getInt(0).toInt()
                    )
                }
                .function("ticksPerWaterSpawns", returns(Type.J).noParams()) { it.setReturnLong(it.target?.ticksPerWaterSpawns ?: 0) }
                .function("setTicksPerWaterSpawns", returnsVoid().params(Type.I)) { it.target?.setTicksPerWaterSpawns(it.getInt(0).toInt()) }
                .function("ticksPerWaterAmbientSpawns", returns(Type.J).noParams()) { it.setReturnLong(it.target?.ticksPerWaterAmbientSpawns ?: 0) }
                .function("setTicksPerWaterAmbientSpawns", returnsVoid().params(Type.I)) {
                    it.target?.setTicksPerWaterAmbientSpawns(
                        it.getInt(0).toInt()
                    )
                }
                .function("ticksPerWaterUndergroundCreatureSpawns", returns(Type.J).noParams()) { it.setReturnLong(it.target?.ticksPerWaterUndergroundCreatureSpawns ?: 0) }
                .function("setTicksPerWaterUndergroundCreatureSpawns", returnsVoid().params(Type.I)) { it.target?.setTicksPerWaterUndergroundCreatureSpawns(it.getInt(0).toInt()) }
                .function("ticksPerAmbientSpawns", returns(Type.J).noParams()) { it.setReturnLong(it.target?.ticksPerAmbientSpawns ?: 0) }
                .function("setTicksPerAmbientSpawns", returnsVoid().params(Type.I)) {
                    it.target?.setTicksPerAmbientSpawns(
                        it.getInt(0).toInt()
                    )
                }
                .function("getTicksPerSpawns", returns(Type.J).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpawnCategory.TYPE)) { it.setReturnLong(it.target?.getTicksPerSpawns(it.getRef(0) as SpawnCategory) ?: 0L) }
                .function("getTicksPerSpawns", returns(Type.J).params(Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpawnCategory.enumValue(it.getString(0))?.let { p0 ->
                        it.setReturnLong(it.target?.getTicksPerSpawns(p0) ?: 0L)
                    }
                }
                .function("setTicksPerSpawns", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpawnCategory.TYPE, Type.I)) {
                    it.target?.setTicksPerSpawns(
                        it.getRef(0) as SpawnCategory,
                        it.getInt(1).toInt()
                    )
                }
                .function("setTicksPerSpawns", returnsVoid().params(Type.STRING, Type.I)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpawnCategory.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.setTicksPerSpawns(
                            p0,
                            it.getInt(1).toInt()
                        )
                    }
                }
                .function("monsterSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.monsterSpawnLimit ?: 0) }
                .function("setMonsterSpawnLimit", returnsVoid().params(Type.I)) { it.target?.setMonsterSpawnLimit(it.getInt(0).toInt()) }
                .function("animalSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.animalSpawnLimit ?: 0) }
                .function("setAnimalSpawnLimit", returnsVoid().params(Type.I)) { it.target?.setAnimalSpawnLimit(it.getInt(0).toInt()) }
                .function("waterAnimalSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.waterAnimalSpawnLimit ?: 0) }
                .function("setWaterAnimalSpawnLimit", returnsVoid().params(Type.I)) {
                    it.target?.setWaterAnimalSpawnLimit(
                        it.getInt(0).toInt()
                    )
                }
                .function("waterUndergroundCreatureSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.waterUndergroundCreatureSpawnLimit ?: 0) }
                .function("setWaterUndergroundCreatureSpawnLimit", returnsVoid().params(Type.I)) { it.target?.setWaterUndergroundCreatureSpawnLimit(it.getInt(0).toInt()) }
                .function("waterAmbientSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.waterAmbientSpawnLimit ?: 0) }
                .function("setWaterAmbientSpawnLimit", returnsVoid().params(Type.I)) {
                    it.target?.setWaterAmbientSpawnLimit(
                        it.getInt(0).toInt()
                    )
                }
                .function("ambientSpawnLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ambientSpawnLimit ?: 0) }
                .function("setAmbientSpawnLimit", returnsVoid().params(Type.I)) { it.target?.setAmbientSpawnLimit(it.getInt(0).toInt()) }
                .function("getSpawnLimit", returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpawnCategory.TYPE)) { it.setReturnInt(it.target?.getSpawnLimit(it.getRef(0) as SpawnCategory) ?: 0)  }
                .function("getSpawnLimit", returns(Type.I).params(Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpawnCategory.enumValue(it.getString(0))?.let { p0 ->
                        it.setReturnInt(it.target?.getSpawnLimit(p0) ?: 0)
                    }
                }
                .function("setSpawnLimit", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpawnCategory.TYPE, Type.I)) {
                    it.target?.setSpawnLimit(
                        it.getRef(0) as SpawnCategory,
                        it.getInt(1).toInt()
                    )
                }
                .function("setSpawnLimit", returnsVoid().params(Type.STRING, Type.I)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpawnCategory.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.setSpawnLimit(
                            p0,
                            it.getInt(1).toInt()
                        )
                    }
                }
                .syncFunction("playNote",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnInstrument.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNote.TYPE)) {
                    it.target?.playNote(
                        it.getRef(0) as Location,
                        it.getRef(1) as Instrument,
                        it.getRef(2) as Note
                    )
                }
                .syncFunction("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, Type.F, Type.F)) {
                    it.target?.playSound(it.getRef(0) as Location, it.getRef(1) as Sound, it.getFloat(2), it.getFloat(3))
                }
                .syncFunction("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.STRING, Type.F, Type.F)) {
                    it.target?.playSound(it.getRef(0) as Location, it.getString(1)!!, it.getFloat(2), it.getFloat(3))
                }
                .syncFunction("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, Type.F, Type.F)) {
                    it.target?.playSound(it.getRef(0) as Entity, it.getRef(1) as Sound, it.getFloat(2), it.getFloat(3))
                }
                .syncFunction("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, Type.STRING, Type.F, Type.F)) {
                    it.target?.playSound(it.getRef(0) as Entity, it.getString(1)!!, it.getFloat(2), it.getFloat(3))
                }
                .syncFunction("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F)) {
                    it.target?.playSound(it.getRef(0) as Location, it.getRef(1) as Sound, it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4))
                }
                .syncFunction("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F)) {
                    it.target?.playSound(it.getRef(0) as Location, it.getString(1)!!, it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4))
                }
                .syncFunction("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F)) {
                    it.target?.playSound(it.getRef(0) as Entity, it.getRef(1) as Sound, it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4))
                }
                .syncFunction("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F)) {
                    it.target?.playSound(it.getRef(0) as Entity, it.getString(1)!!, it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4))
                }
                .syncFunction("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F, Type.J)) {
                    it.target?.playSound(it.getRef(0) as Location, it.getRef(1) as Sound, it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4), it.getLong(5))
                }
                .syncFunction("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F, Type.J)) {
                    it.target?.playSound(it.getRef(0) as Location, it.getString(1)!!, it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4), it.getLong(5))
                }
                .syncFunction("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F, Type.J)) {
                    it.target?.playSound(it.getRef(0) as Entity, it.getRef(1) as Sound, it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4), it.getLong(5))
                }
                .syncFunction("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F, Type.J)) {
                    it.target?.playSound(it.getRef(0) as Entity, it.getString(1)!!, it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4), it.getLong(5))
                }
                .function("gameRules", returns(org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY).noParams()) { it.setReturnRef(it.target?.gameRules) }
                .function("getGameRuleValue", returns(Type.STRING).params(Type.STRING)) { it.setReturnRef(it.target?.getGameRuleValue(it.getString(0))) }
                .function("setGameRuleValue", returns(Type.Z).params(Type.STRING, Type.STRING)) {
                    it.setReturnBool(it.target?.setGameRuleValue(it.getString(0)!!, it.getString(1)!!) ?: false)
                }
                .function("isGameRule", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isGameRule(it.getString(0)!!) ?: false) }
                .function("worldBorder", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldBorder.TYPE).noParams()) { it.setReturnRef(it.target?.worldBorder) }
                .function("spawnParticle", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I)) {
                    it.target?.spawnParticle(it.getRef(0) as Particle, it.getRef(1) as Location, it.getInt(2).toInt())
                }
                .function("spawnParticle", returnsVoid().params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.spawnParticle(p0, it.getRef(1) as Location, it.getInt(2).toInt())
                    }
                }
                .function("spawnParticle", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE, Type.D, Type.D, Type.D, Type.I)) {
                    it.target?.spawnParticle(it.getRef(0) as Particle, it.getDouble(1), it.getDouble(2), it.getDouble(3), it.getInt(4).toInt())
                }
                .function("spawnParticle", returnsVoid().params(Type.STRING, Type.D, Type.D, Type.D, Type.I)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.spawnParticle(p0, it.getDouble(1), it.getDouble(2), it.getDouble(3), it.getInt(4).toInt())
                    }
                }
                .function("spawnParticle", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I, Type.D, Type.D, Type.D)) {
                    it.target?.spawnParticle(it.getRef(0) as Particle, it.getRef(1) as Location, it.getInt(2).toInt(), it.getDouble(3), it.getDouble(4), it.getDouble(5))
                }
                .function("spawnParticle", returnsVoid().params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I, Type.D, Type.D, Type.D)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.spawnParticle(p0, it.getRef(1) as Location, it.getInt(2).toInt(), it.getDouble(3), it.getDouble(4), it.getDouble(5))
                    }
                }
                .function("spawnParticle", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I, Type.D, Type.D, Type.D, Type.D)) {
                    it.target?.spawnParticle(it.getRef(0) as Particle, it.getRef(1) as Location, it.getInt(2).toInt(), it.getDouble(3), it.getDouble(4), it.getDouble(5), it.getDouble(6))
                }
                .function("spawnParticle", returnsVoid().params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I, Type.D, Type.D, Type.D, Type.D)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.spawnParticle(p0, it.getRef(1) as Location, it.getInt(2).toInt(), it.getDouble(3), it.getDouble(4), it.getDouble(5), it.getDouble(6))
                    }
                }
                .function("spawnParticle", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE, Type.D, Type.D, Type.D, Type.I, Type.D, Type.D, Type.D)) {
                    it.target?.spawnParticle(it.getRef(0) as Particle, it.getDouble(1), it.getDouble(2), it.getDouble(3), it.getInt(4).toInt(), it.getDouble(5), it.getDouble(6), it.getDouble(7))
                }
                .function("spawnParticle", returnsVoid().params(Type.STRING, Type.D, Type.D, Type.D, Type.I, Type.D, Type.D, Type.D)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.spawnParticle(p0, it.getDouble(1), it.getDouble(2), it.getDouble(3), it.getInt(4).toInt(), it.getDouble(5), it.getDouble(6), it.getDouble(7))
                    }
                }
                .function("spawnParticle", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE, Type.D, Type.D, Type.D, Type.I, Type.D, Type.D, Type.D, Type.D)) {
                    it.target?.spawnParticle(it.getRef(0) as Particle, it.getDouble(1), it.getDouble(2), it.getDouble(3), it.getInt(4).toInt(), it.getDouble(5), it.getDouble(6), it.getDouble(7), it.getDouble(8))
                }
                .function("spawnParticle", returnsVoid().params(Type.STRING, Type.D, Type.D, Type.D, Type.I, Type.D, Type.D, Type.D, Type.D)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.spawnParticle(p0, it.getDouble(1), it.getDouble(2), it.getDouble(3), it.getInt(4).toInt(), it.getDouble(5), it.getDouble(6), it.getDouble(7), it.getDouble(8))
                    }
                }
                .function("locateNearestStructure",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnStructureSearchResult.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure.FnStructureType.TYPE, Type.I, Type.Z)) {
                    it.setReturnRef(it.target?.locateNearestStructure(
                        it.getRef(0) as Location,
                        it.getRef(1) as StructureType,
                        it.getInt(2).toInt(),
                        it.getBool(3)
                    ))
                }
                .function("locateNearestStructure",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnStructureSearchResult.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure.FnStructure.TYPE, Type.I, Type.Z)) {
                    it.setReturnRef(it.target?.locateNearestStructure(
                        it.getRef(0) as Location,
                        it.getRef(1) as Structure,
                        it.getInt(2).toInt(),
                        it.getBool(3)
                    ))
                }
                .function("locateNearestBiome",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBiomeSearchResult.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I)) {
                    it.setReturnRef(it.target?.locateNearestBiome(
                        it.getRef(0) as Location,
                        it.getInt(1).toInt()
                    ))
                }
                .function("locateNearestBiome",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBiomeSearchResult.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.locateNearestBiome(
                        it.getRef(0) as Location,
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt()
                    ))
                }
                .function("locateNearestRaid",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnRaid.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I)) {
                    it.setReturnRef(it.target?.locateNearestRaid(
                        it.getRef(0) as Location,
                        it.getInt(1).toInt()
                    ))
                }
                .function("raids", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.raids) }
                .function("enderDragonBattle", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnDragonBattle.TYPE).noParams()) { it.setReturnRef(it.target?.enderDragonBattle) }
                .function("featureFlags", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.featureFlags) }
                .function("getStructures", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getStructures(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("getStructures",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure.FnStructure.TYPE)) {
                    it.setReturnRef(it.target?.getStructures(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getRef(2) as Structure
                    ))
                }
                .function("isDay", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDay ?: false) }
                .function("isNight", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isNight ?: false) }
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

@Requires(classes = ["org.bukkit.World\$Environment"])
@PlatformSide(Platform.BUKKIT)
object FnWorldEnvironment : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.World.Environment>() {

    override val enumClass: Class<org.bukkit.World.Environment> = org.bukkit.World.Environment::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(World.Environment::class.java)
                .function("id", returns(Type.I).noParams()) { it.setReturnInt(it.target?.id ?: 0) }
                // static
                .function("getEnvironment",returns(TYPE).params(Type.I)) { it.setReturnRef(World.Environment.getEnvironment(it.getInt(0).toInt())) }
        }
    }
}
