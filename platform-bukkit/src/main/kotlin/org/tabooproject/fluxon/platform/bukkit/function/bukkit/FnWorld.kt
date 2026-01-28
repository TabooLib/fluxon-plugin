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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("world", returnsObject().params(Type.OBJECT)) {
                it.setReturnRef(when (val id = it.getRef(0)) {
                    is UUID -> Bukkit.getWorld(id)
                    is String -> Bukkit.getWorld(id)
                    else -> null
                })
            }
            registerFunction("worlds", returns(Type.LIST).noParams()) { it.setReturnRef(Bukkit.getWorlds()) }

            registerExtension(World::class.java)
                .function("getBlockAt", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.getBlockAt(it.getRef(0) as Location)
                    } else {
                        it.target?.getBlockAt(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("getBlockAt", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.getBlockAt(it.getRef(0) as Location)
                    } else {
                        it.target?.getBlockAt(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("getHighestBlockAt", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.getHighestBlockAt(it.getRef(0) as Location)
                        2 -> when (val var1 = it.getRef(0)) {
                            is Int -> it.target?.getHighestBlockAt(var1, it.getInt(1).toInt())
                            is Location -> it.target?.getHighestBlockAt(var1, it.getRef(1) as HeightMap)
                            else -> throw IllegalArgumentException("参数必须是 Int 或 Location 类型")
                        }

                        3 -> it.target?.getHighestBlockAt(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getRef(2) as HeightMap
                        )
                        else -> error("World#highestBlockAt 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getHighestBlockAt", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.getHighestBlockAt(it.getRef(0) as Location)
                        2 -> when (val var1 = it.getRef(0)) {
                            is Int -> it.target?.getHighestBlockAt(var1, it.getInt(1).toInt())
                            is Location -> it.target?.getHighestBlockAt(var1, it.getRef(1) as HeightMap)
                            else -> throw IllegalArgumentException("参数必须是 Int 或 Location 类型")
                        }

                        3 -> it.target?.getHighestBlockAt(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getRef(2) as HeightMap
                        )
                        else -> error("World#highestBlockAt 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getHighestBlockAt", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.getHighestBlockAt(it.getRef(0) as Location)
                        2 -> when (val var1 = it.getRef(0)) {
                            is Int -> it.target?.getHighestBlockAt(var1, it.getInt(1).toInt())
                            is Location -> it.target?.getHighestBlockAt(var1, it.getRef(1) as HeightMap)
                            else -> throw IllegalArgumentException("参数必须是 Int 或 Location 类型")
                        }

                        3 -> it.target?.getHighestBlockAt(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getRef(2) as HeightMap
                        )
                        else -> error("World#highestBlockAt 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getChunkAt", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> when (val var1 = it.getRef(0)) {
                            is Location -> it.target?.getChunkAt(var1)
                            is Block -> it.target?.getChunkAt(var1)
                            else -> throw IllegalArgumentException("参数必须是 Location 或 Block 类型")
                        }

                        2 -> it.target?.getChunkAt(it.getInt(0).toInt(), it.getInt(1).toInt())
                        3 -> it.target?.getChunkAt(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getBool(2)
                        )
                        else -> error("World#chunkAt 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getChunkAt", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> when (val var1 = it.getRef(0)) {
                            is Location -> it.target?.getChunkAt(var1)
                            is Block -> it.target?.getChunkAt(var1)
                            else -> throw IllegalArgumentException("参数必须是 Location 或 Block 类型")
                        }

                        2 -> it.target?.getChunkAt(it.getInt(0).toInt(), it.getInt(1).toInt())
                        3 -> it.target?.getChunkAt(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getBool(2)
                        )
                        else -> error("World#chunkAt 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getChunkAt", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> when (val var1 = it.getRef(0)) {
                            is Location -> it.target?.getChunkAt(var1)
                            is Block -> it.target?.getChunkAt(var1)
                            else -> throw IllegalArgumentException("参数必须是 Location 或 Block 类型")
                        }

                        2 -> it.target?.getChunkAt(it.getInt(0).toInt(), it.getInt(1).toInt())
                        3 -> it.target?.getChunkAt(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getBool(2)
                        )
                        else -> error("World#chunkAt 函数参数数量错误: ${"args"}")
                    })
                }
                .function("isChunkLoaded", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.isChunkLoaded(it.getRef(0) as Chunk)
                    } else {
                        it.target?.isChunkLoaded(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )
                    })
                }
                .function("isChunkLoaded", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.isChunkLoaded(it.getRef(0) as Chunk)
                    } else {
                        it.target?.isChunkLoaded(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )
                    })
                }
                .function("loadedChunks", returnsObject().noParams()) { it.setReturnRef(it.target?.loadedChunks) }
                .syncFunction("loadChunk", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.loadChunk(it.getRef(0) as Chunk)
                        2 -> it.target?.loadChunk(it.getInt(0).toInt(), it.getInt(1).toInt())
                        3 -> it.target?.loadChunk(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getBool(2)
                        )
                        else -> error("World#loadChunk 函数参数数量错误: ${"args"}")
                    })
                }
                .syncFunction("loadChunk", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.loadChunk(it.getRef(0) as Chunk)
                        2 -> it.target?.loadChunk(it.getInt(0).toInt(), it.getInt(1).toInt())
                        3 -> it.target?.loadChunk(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getBool(2)
                        )
                        else -> error("World#loadChunk 函数参数数量错误: ${"args"}")
                    })
                }
                .syncFunction("loadChunk", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.loadChunk(it.getRef(0) as Chunk)
                        2 -> it.target?.loadChunk(it.getInt(0).toInt(), it.getInt(1).toInt())
                        3 -> it.target?.loadChunk(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getBool(2)
                        )
                        else -> error("World#loadChunk 函数参数数量错误: ${"args"}")
                    })
                }
                .function("isChunkGenerated", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.isChunkGenerated(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("isChunkInUse", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.isChunkInUse(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .syncFunction("unloadChunk", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.unloadChunk(it.getRef(0) as Chunk)
                        2 -> it.target?.unloadChunk(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )

                        3 -> it.target?.unloadChunk(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getBool(2)
                        )
                        else -> error("World#unloadChunk 函数参数数量错误: ${"args"}")
                    })
                }
                .syncFunction("unloadChunk", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.unloadChunk(it.getRef(0) as Chunk)
                        2 -> it.target?.unloadChunk(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )

                        3 -> it.target?.unloadChunk(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getBool(2)
                        )
                        else -> error("World#unloadChunk 函数参数数量错误: ${"args"}")
                    })
                }
                .syncFunction("unloadChunk", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.unloadChunk(it.getRef(0) as Chunk)
                        2 -> it.target?.unloadChunk(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )

                        3 -> it.target?.unloadChunk(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getBool(2)
                        )
                        else -> error("World#unloadChunk 函数参数数量错误: ${"args"}")
                    })
                }
                .syncFunction("unloadChunkRequest", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.unloadChunkRequest(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("regenerateChunk", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.regenerateChunk(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("refreshChunk", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.refreshChunk(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("getPlayersSeeingChunk", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.getPlayersSeeingChunk(it.getRef(0) as Chunk)
                    } else {
                        it.target?.getPlayersSeeingChunk(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )
                    })
                }
                .function("getPlayersSeeingChunk", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.getPlayersSeeingChunk(it.getRef(0) as Chunk)
                    } else {
                        it.target?.getPlayersSeeingChunk(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )
                    })
                }
                .function("isChunkForceLoaded", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.isChunkForceLoaded(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("setChunkForceLoaded", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setChunkForceLoaded(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getBool(2)
                    ))
                }
                .function("forceLoadedChunks", returnsObject().noParams()) { it.setReturnRef(it.target?.forceLoadedChunks) }
                .function("addPluginChunkTicket", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.addPluginChunkTicket(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getRef(2) as Plugin
                    ))
                }
                .function("removePluginChunkTicket", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.removePluginChunkTicket(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getRef(2) as Plugin
                    ))
                }
                .function("removePluginChunkTickets", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removePluginChunkTickets(it.getRef(0) as Plugin)) }
                .function("pluginChunkTickets", returnsObject().noParams()) { it.setReturnRef(it.target?.pluginChunkTickets) }
                .function("getPluginChunkTickets", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getPluginChunkTickets(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("getIntersectingChunks", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getIntersectingChunks(it.getRef(0) as BoundingBox)) }
                .syncFunction("dropItem", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.dropItem(it.getRef(0) as Location, it.getRef(1) as ItemStack)) }
                .syncFunction("dropItemNaturally", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.dropItemNaturally(it.getRef(0) as Location, it.getRef(1) as ItemStack)) }
                .syncFunction("spawnArrow", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.spawnArrow(
                        it.getRef(0) as Location,
                        it.getRef(1) as Vector,
                        it.getFloat(2),
                        it.getFloat(3)
                    ))
                }
                .syncFunction("generateTree", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.generateTree(
                            it.getRef(0) as Location,
                            it.getRef(1) as TreeType
                        )
                    } else {
                        it.target?.generateTree(
                            it.getRef(0) as Location,
                            it.getRef(1) as TreeType,
                            it.getRef(2) as BlockChangeDelegate
                        )
                    })
                }
                .syncFunction("generateTree", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.generateTree(
                            it.getRef(0) as Location,
                            it.getRef(1) as TreeType
                        )
                    } else {
                        it.target?.generateTree(
                            it.getRef(0) as Location,
                            it.getRef(1) as TreeType,
                            it.getRef(2) as BlockChangeDelegate
                        )
                    })
                }
                .syncFunction("strikeLightning", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.strikeLightning(it.getRef(0) as Location)) }
                .syncFunction("strikeLightningEffect", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.strikeLightningEffect(it.getRef(0) as Location)) }
                .function("entities", returnsObject().noParams()) { it.setReturnRef(it.target?.entities) }
                .function("livingEntities", returnsObject().noParams()) { it.setReturnRef(it.target?.livingEntities) }
                .function("entitiesByClasses", returnsObject().noParams()) { it.setReturnRef(it.target?.getEntitiesByClasses()) }
                .function("players", returnsObject().noParams()) { it.setReturnRef(it.target?.players) }
                .function("getNearbyEntities", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.getNearbyEntities(it.getRef(0) as BoundingBox)
                    } else {
                        it.target?.getNearbyEntities(
                            it.getRef(0) as Location,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )
                    })
                }
                .function("getNearbyEntities", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.getNearbyEntities(it.getRef(0) as BoundingBox)
                    } else {
                        it.target?.getNearbyEntities(
                            it.getRef(0) as Location,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )
                    })
                }
                .function("rayTraceEntities", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 3) {
                        it.target?.rayTraceEntities(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2)
                        )
                    } else {
                        it.target?.rayTraceEntities(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )
                    })
                }
                .function("rayTraceEntities", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 3) {
                        it.target?.rayTraceEntities(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2)
                        )
                    } else {
                        it.target?.rayTraceEntities(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )
                    })
                }
                .function("rayTraceBlocks", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.rayTraceBlocks(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.rayTraceBlocks(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2),
                            it.getRef(3) as FluidCollisionMode
                        )

                        5 -> it.target?.rayTraceBlocks(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2),
                            it.getRef(3) as FluidCollisionMode,
                            it.getBool(4)
                        )
                        else -> error("World#rayTraceBlocks 函数参数数量错误: ${"args"}")
                    })
                }
                .function("rayTraceBlocks", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.rayTraceBlocks(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.rayTraceBlocks(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2),
                            it.getRef(3) as FluidCollisionMode
                        )

                        5 -> it.target?.rayTraceBlocks(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2),
                            it.getRef(3) as FluidCollisionMode,
                            it.getBool(4)
                        )
                        else -> error("World#rayTraceBlocks 函数参数数量错误: ${"args"}")
                    })
                }
                .function("rayTraceBlocks", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.rayTraceBlocks(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.rayTraceBlocks(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2),
                            it.getRef(3) as FluidCollisionMode
                        )

                        5 -> it.target?.rayTraceBlocks(
                            it.getRef(0) as Location,
                            it.getRef(1) as Vector,
                            it.getAsDouble(2),
                            it.getRef(3) as FluidCollisionMode,
                            it.getBool(4)
                        )
                        else -> error("World#rayTraceBlocks 函数参数数量错误: ${"args"}")
                    })
                }
//                .function("rayTrace", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
//                    it.setReturnRef(it.target?.rayTrace(
//                        it.getRef(0) as Location,
//                        it.getRef(1) as Vector,
//                        it.getAsDouble(2),
//                        it.getRef(3) as FluidCollisionMode,
//                        it.getBool(4),
//                        it.getAsDouble(5),
//                        it.getRef(6) as Predicate<Entity>
//                    ))
//                }
                .function("spawnLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnLocation) }
                .function("setSpawnLocation", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.setSpawnLocation(it.getRef(0) as Location)
                        3 -> it.target?.setSpawnLocation(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )

                        4 -> it.target?.setSpawnLocation(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getFloat(3)
                        )
                        else -> error("World#setSpawnLocation 函数参数数量错误: ${"args"}")
                    })
                }
                .function("setSpawnLocation", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.setSpawnLocation(it.getRef(0) as Location)
                        3 -> it.target?.setSpawnLocation(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )

                        4 -> it.target?.setSpawnLocation(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getFloat(3)
                        )
                        else -> error("World#setSpawnLocation 函数参数数量错误: ${"args"}")
                    })
                }
                .function("setSpawnLocation", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.setSpawnLocation(it.getRef(0) as Location)
                        3 -> it.target?.setSpawnLocation(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )

                        4 -> it.target?.setSpawnLocation(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getFloat(3)
                        )
                        else -> error("World#setSpawnLocation 函数参数数量错误: ${"args"}")
                    })
                }
                .function("time", returnsObject().noParams()) { it.setReturnRef(it.target?.time) }
                .function("setTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTime(it.getInt(0).toLong())) }
                .function("fullTime", returnsObject().noParams()) { it.setReturnRef(it.target?.fullTime) }
                .function("setFullTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFullTime(it.getInt(0).toLong())) }
                .function("gameTime", returnsObject().noParams()) { it.setReturnRef(it.target?.gameTime) }
                .function("hasStorm", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasStorm()) }
                .function("setStorm", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setStorm(it.getBool(0))) }
                .function("weatherDuration", returnsObject().noParams()) { it.setReturnRef(it.target?.weatherDuration) }
                .function("setWeatherDuration", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setWeatherDuration(it.getInt(0).toInt())) }
                .function("isThundering", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isThundering) }
                .function("setThundering", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setThundering(it.getBool(0))) }
                .function("thunderDuration", returnsObject().noParams()) { it.setReturnRef(it.target?.thunderDuration) }
                .function("setThunderDuration", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setThunderDuration(it.getInt(0).toInt())) }
                .function("isClearWeather", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isClearWeather) }
                .function("setClearWeatherDuration", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setClearWeatherDuration(it.getInt(0).toInt())) }
                .function("clearWeatherDuration", returnsObject().noParams()) { it.setReturnRef(it.target?.clearWeatherDuration) }
                .syncFunction("createExplosion", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        2 -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1)
                        )

                        3 -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1),
                            it.getBool(2)
                        )

                        4 -> when (val var1 = it.getRef(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getFloat(3)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getFloat(1),
                                it.getBool(2),
                                it.getBool(3)
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        5 -> when (val var1 = it.getRef(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getFloat(3),
                                it.getBool(4)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getFloat(1),
                                it.getBool(2),
                                it.getBool(3),
                                it.getRef(4) as Entity?
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        6 -> it.target?.createExplosion(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getFloat(3),
                            it.getBool(4),
                            it.getBool(5)
                        )

                        7 -> it.target?.createExplosion(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getFloat(3),
                            it.getBool(4),
                            it.getBool(5),
                            it.getRef(6) as Entity
                        )
                        else -> error("World#createExplosion 函数参数数量错误: ${"args"}")
                    })
                }
                .syncFunction("createExplosion", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        2 -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1)
                        )

                        3 -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1),
                            it.getBool(2)
                        )

                        4 -> when (val var1 = it.getRef(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getFloat(3)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getFloat(1),
                                it.getBool(2),
                                it.getBool(3)
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        5 -> when (val var1 = it.getRef(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getFloat(3),
                                it.getBool(4)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getFloat(1),
                                it.getBool(2),
                                it.getBool(3),
                                it.getRef(4) as Entity?
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        6 -> it.target?.createExplosion(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getFloat(3),
                            it.getBool(4),
                            it.getBool(5)
                        )

                        7 -> it.target?.createExplosion(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getFloat(3),
                            it.getBool(4),
                            it.getBool(5),
                            it.getRef(6) as Entity
                        )
                        else -> error("World#createExplosion 函数参数数量错误: ${"args"}")
                    })
                }
                .syncFunction("createExplosion", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        2 -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1)
                        )

                        3 -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1),
                            it.getBool(2)
                        )

                        4 -> when (val var1 = it.getRef(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getFloat(3)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getFloat(1),
                                it.getBool(2),
                                it.getBool(3)
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        5 -> when (val var1 = it.getRef(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getFloat(3),
                                it.getBool(4)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getFloat(1),
                                it.getBool(2),
                                it.getBool(3),
                                it.getRef(4) as Entity?
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        6 -> it.target?.createExplosion(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getFloat(3),
                            it.getBool(4),
                            it.getBool(5)
                        )

                        7 -> it.target?.createExplosion(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getFloat(3),
                            it.getBool(4),
                            it.getBool(5),
                            it.getRef(6) as Entity
                        )
                        else -> error("World#createExplosion 函数参数数量错误: ${"args"}")
                    })
                }
                .syncFunction("createExplosion", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        2 -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1)
                        )

                        3 -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1),
                            it.getBool(2)
                        )

                        4 -> when (val var1 = it.getRef(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getFloat(3)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getFloat(1),
                                it.getBool(2),
                                it.getBool(3)
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        5 -> when (val var1 = it.getRef(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getFloat(3),
                                it.getBool(4)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getFloat(1),
                                it.getBool(2),
                                it.getBool(3),
                                it.getRef(4) as Entity?
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        6 -> it.target?.createExplosion(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getFloat(3),
                            it.getBool(4),
                            it.getBool(5)
                        )

                        7 -> it.target?.createExplosion(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getFloat(3),
                            it.getBool(4),
                            it.getBool(5),
                            it.getRef(6) as Entity
                        )
                        else -> error("World#createExplosion 函数参数数量错误: ${"args"}")
                    })
                }
                .syncFunction("createExplosion", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        2 -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1)
                        )

                        3 -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1),
                            it.getBool(2)
                        )

                        4 -> when (val var1 = it.getRef(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getFloat(3)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getFloat(1),
                                it.getBool(2),
                                it.getBool(3)
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        5 -> when (val var1 = it.getRef(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getFloat(3),
                                it.getBool(4)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getFloat(1),
                                it.getBool(2),
                                it.getBool(3),
                                it.getRef(4) as Entity?
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        6 -> it.target?.createExplosion(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getFloat(3),
                            it.getBool(4),
                            it.getBool(5)
                        )

                        7 -> it.target?.createExplosion(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getFloat(3),
                            it.getBool(4),
                            it.getBool(5),
                            it.getRef(6) as Entity
                        )
                        else -> error("World#createExplosion 函数参数数量错误: ${"args"}")
                    })
                }
                .syncFunction("createExplosion", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        2 -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1)
                        )

                        3 -> it.target?.createExplosion(
                            it.getRef(0) as Location,
                            it.getFloat(1),
                            it.getBool(2)
                        )

                        4 -> when (val var1 = it.getRef(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getFloat(3)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getFloat(1),
                                it.getBool(2),
                                it.getBool(3)
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        5 -> when (val var1 = it.getRef(0)) {
                            is Double -> it.target?.createExplosion(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getFloat(3),
                                it.getBool(4)
                            )

                            is Location -> it.target?.createExplosion(
                                var1,
                                it.getFloat(1),
                                it.getBool(2),
                                it.getBool(3),
                                it.getRef(4) as Entity?
                            )

                            else -> throw IllegalArgumentException("参数必须是 Double 或 Location 类型")
                        }

                        6 -> it.target?.createExplosion(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getFloat(3),
                            it.getBool(4),
                            it.getBool(5)
                        )

                        7 -> it.target?.createExplosion(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getFloat(3),
                            it.getBool(4),
                            it.getBool(5),
                            it.getRef(6) as Entity
                        )
                        else -> error("World#createExplosion 函数参数数量错误: ${"args"}")
                    })
                }
                .function("pvp", returnsObject().noParams()) { it.setReturnRef(it.target?.pvp) }
                .function("setPVP", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPVP(it.getBool(0))) }
                .function("generator", returnsObject().noParams()) { it.setReturnRef(it.target?.generator) }
                .function("biomeProvider", returnsObject().noParams()) { it.setReturnRef(it.target?.biomeProvider) }
                .syncFunction("save", returnsObject().noParams()) { it.setReturnRef(it.target?.save()) }
                .function("populators", returnsObject().noParams()) { it.setReturnRef(it.target?.populators) }
                .syncFunction("spawnFallingBlock", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        when (val var2 = it.getRef(1)) {
                            is MaterialData -> it.target?.spawnFallingBlock(it.getRef(0) as Location, var2)
                            is BlockData -> it.target?.spawnFallingBlock(it.getRef(0) as Location, var2)
                            else -> throw IllegalArgumentException("参数必须是 MaterialData 或 BlockData 类型")
                        }
                    } else {
                        it.target?.spawnFallingBlock(
                            it.getRef(0) as Location,
                            it.getRef(1) as Material,
                            it.getInt(2).toByte()
                        )
                    })
                }
                .syncFunction("spawnFallingBlock", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        when (val var2 = it.getRef(1)) {
                            is MaterialData -> it.target?.spawnFallingBlock(it.getRef(0) as Location, var2)
                            is BlockData -> it.target?.spawnFallingBlock(it.getRef(0) as Location, var2)
                            else -> throw IllegalArgumentException("参数必须是 MaterialData 或 BlockData 类型")
                        }
                    } else {
                        it.target?.spawnFallingBlock(
                            it.getRef(0) as Location,
                            it.getRef(1) as Material,
                            it.getInt(2).toByte()
                        )
                    })
                }
                .function("playEffect", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 3) {
                        it.target?.playEffect(
                            it.getRef(0) as Location,
                            it.getRef(1) as Effect,
                            it.getInt(2).toInt()
                        )
                    } else {
                        it.target?.playEffect(
                            it.getRef(0) as Location,
                            it.getRef(1) as Effect,
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt()
                        )
                    })
                }
                .function("playEffect", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 3) {
                        it.target?.playEffect(
                            it.getRef(0) as Location,
                            it.getRef(1) as Effect,
                            it.getInt(2).toInt()
                        )
                    } else {
                        it.target?.playEffect(
                            it.getRef(0) as Location,
                            it.getRef(1) as Effect,
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt()
                        )
                    })
                }
                .function("getEmptyChunkSnapshot", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getEmptyChunkSnapshot(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getBool(2),
                        it.getBool(3)
                    ))
                }
                .function("setSpawnFlags", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.setSpawnFlags(it.getBool(0), it.getBool(1))) }
                .function("allowAnimals", returnsObject().noParams()) { it.setReturnRef(it.target?.allowAnimals) }
                .function("allowMonsters", returnsObject().noParams()) { it.setReturnRef(it.target?.allowMonsters) }
                .function("getBiome", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.getBiome(it.getInt(0).toInt(), it.getInt(1).toInt())) }
                .syncFunction("setBiome", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setBiome(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getRef(2) as Biome
                    ))
                }
                .function("getTemperature", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.getTemperature(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )
                    } else {
                        it.target?.getTemperature(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("getTemperature", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.getTemperature(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )
                    } else {
                        it.target?.getTemperature(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("getHumidity", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.getHumidity(it.getInt(0).toInt(), it.getInt(1).toInt())
                    } else {
                        it.target?.getHumidity(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("getHumidity", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.getHumidity(it.getInt(0).toInt(), it.getInt(1).toInt())
                    } else {
                        it.target?.getHumidity(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("logicalHeight", returnsObject().noParams()) { it.setReturnRef(it.target?.logicalHeight) }
                .function("isNatural", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isNatural) }
                .function("isBedWorks", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isBedWorks) }
                .function("hasSkyLight", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasSkyLight()) }
                .function("hasCeiling", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasCeiling()) }
                .function("isPiglinSafe", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isPiglinSafe) }
                .function("isRespawnAnchorWorks", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isRespawnAnchorWorks) }
                .function("hasRaids", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasRaids()) }
                .function("isUltraWarm", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isUltraWarm) }
                .function("seaLevel", returnsObject().noParams()) { it.setReturnRef(it.target?.seaLevel) }
                .function("keepSpawnInMemory", returnsObject().noParams()) { it.setReturnRef(it.target?.keepSpawnInMemory) }
                .function("setKeepSpawnInMemory", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setKeepSpawnInMemory(it.getBool(0))) }
                .function("isAutoSave", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isAutoSave) }
                .function("setAutoSave", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAutoSave(it.getBool(0))) }
                .function("setDifficulty", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDifficulty(it.getRef(0) as Difficulty)) }
                .function("difficulty", returnsObject().noParams()) { it.setReturnRef(it.target?.difficulty) }
                .function("viewDistance", returnsObject().noParams()) { it.setReturnRef(it.target?.viewDistance) }
                .function("simulationDistance", returnsObject().noParams()) { it.setReturnRef(it.target?.simulationDistance) }
                .function("worldFolder", returnsObject().noParams()) { it.setReturnRef(it.target?.worldFolder) }
                .function("worldType", returnsObject().noParams()) { it.setReturnRef(it.target?.worldType) }
                .function("canGenerateStructures", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.canGenerateStructures()) }
                .function("isHardcore", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isHardcore) }
                .function("setHardcore", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setHardcore(it.getBool(0))) }
                .function("ticksPerAnimalSpawns", returnsObject().noParams()) { it.setReturnRef(it.target?.ticksPerAnimalSpawns) }
                .function("setTicksPerAnimalSpawns", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTicksPerAnimalSpawns(it.getInt(0).toInt())) }
                .function("ticksPerMonsterSpawns", returnsObject().noParams()) { it.setReturnRef(it.target?.ticksPerMonsterSpawns) }
                .function("setTicksPerMonsterSpawns", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.setTicksPerMonsterSpawns(
                        it.getInt(0).toInt()
                    ))
                }
                .function("ticksPerWaterSpawns", returnsObject().noParams()) { it.setReturnRef(it.target?.ticksPerWaterSpawns) }
                .function("setTicksPerWaterSpawns", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTicksPerWaterSpawns(it.getInt(0).toInt())) }
                .function("ticksPerWaterAmbientSpawns", returnsObject().noParams()) { it.setReturnRef(it.target?.ticksPerWaterAmbientSpawns) }
                .function("setTicksPerWaterAmbientSpawns", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.setTicksPerWaterAmbientSpawns(
                        it.getInt(0).toInt()
                    ))
                }
                .function("ticksPerWaterUndergroundCreatureSpawns", returnsObject().noParams()) { it.setReturnRef(it.target?.ticksPerWaterUndergroundCreatureSpawns) }
                .function("setTicksPerWaterUndergroundCreatureSpawns", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTicksPerWaterUndergroundCreatureSpawns(it.getInt(0).toInt())) }
                .function("ticksPerAmbientSpawns", returnsObject().noParams()) { it.setReturnRef(it.target?.ticksPerAmbientSpawns) }
                .function("setTicksPerAmbientSpawns", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.setTicksPerAmbientSpawns(
                        it.getInt(0).toInt()
                    ))
                }
                .function("getTicksPerSpawns", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getTicksPerSpawns(it.getRef(0) as SpawnCategory)) }
                .function("setTicksPerSpawns", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setTicksPerSpawns(
                        it.getRef(0) as SpawnCategory,
                        it.getInt(1).toInt()
                    ))
                }
                .function("monsterSpawnLimit", returnsObject().noParams()) { it.setReturnRef(it.target?.monsterSpawnLimit) }
                .function("setMonsterSpawnLimit", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMonsterSpawnLimit(it.getInt(0).toInt())) }
                .function("animalSpawnLimit", returnsObject().noParams()) { it.setReturnRef(it.target?.animalSpawnLimit) }
                .function("setAnimalSpawnLimit", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAnimalSpawnLimit(it.getInt(0).toInt())) }
                .function("waterAnimalSpawnLimit", returnsObject().noParams()) { it.setReturnRef(it.target?.waterAnimalSpawnLimit) }
                .function("setWaterAnimalSpawnLimit", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.setWaterAnimalSpawnLimit(
                        it.getInt(0).toInt()
                    ))
                }
                .function("waterUndergroundCreatureSpawnLimit", returnsObject().noParams()) { it.setReturnRef(it.target?.waterUndergroundCreatureSpawnLimit) }
                .function("setWaterUndergroundCreatureSpawnLimit", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setWaterUndergroundCreatureSpawnLimit(it.getInt(0).toInt())) }
                .function("waterAmbientSpawnLimit", returnsObject().noParams()) { it.setReturnRef(it.target?.waterAmbientSpawnLimit) }
                .function("setWaterAmbientSpawnLimit", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.setWaterAmbientSpawnLimit(
                        it.getInt(0).toInt()
                    ))
                }
                .function("ambientSpawnLimit", returnsObject().noParams()) { it.setReturnRef(it.target?.ambientSpawnLimit) }
                .function("setAmbientSpawnLimit", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAmbientSpawnLimit(it.getInt(0).toInt())) }
                .function("getSpawnLimit", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getSpawnLimit(it.getRef(0) as SpawnCategory)) }
                .function("setSpawnLimit", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setSpawnLimit(
                        it.getRef(0) as SpawnCategory,
                        it.getInt(1).toInt()
                    ))
                }
                .syncFunction("playNote", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.playNote(
                        it.getRef(0) as Location,
                        it.getRef(1) as Instrument,
                        it.getRef(2) as Note
                    ))
                }
                .syncFunction("playSound", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        4 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("第一个参数必须是 Location 或 Entity 类型")
                        }

                        5 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4)
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4)
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("第一个参数必须是 Location 或 Entity 类型")
                        }

                        6 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("第一个参数必须是 Location 或 Entity 类型")
                        }
                        else -> error("World#playSound 函数参数数量错误: ${"args"}")
                    })
                }
                .syncFunction("playSound", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        4 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("第一个参数必须是 Location 或 Entity 类型")
                        }

                        5 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4)
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4)
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("第一个参数必须是 Location 或 Entity 类型")
                        }

                        6 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("第一个参数必须是 Location 或 Entity 类型")
                        }
                        else -> error("World#playSound 函数参数数量错误: ${"args"}")
                    })
                }
                .syncFunction("playSound", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        4 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("第一个参数必须是 Location 或 Entity 类型")
                        }

                        5 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4)
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4)
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("第一个参数必须是 Location 或 Entity 类型")
                        }

                        6 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                else -> throw IllegalArgumentException("第二个参数必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("第一个参数必须是 Location 或 Entity 类型")
                        }
                        else -> error("World#playSound 函数参数数量错误: ${"args"}")
                    })
                }
                .function("gameRules", returnsObject().noParams()) { it.setReturnRef(it.target?.gameRules) }
                .function("getGameRuleValue", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getGameRuleValue(it.getString(0))) }
                .function("setGameRuleValue", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.setGameRuleValue(it.getString(0)!!, it.getString(1)!!)) }
                .function("isGameRule", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.isGameRule(it.getString(0)!!)) }
                .function("worldBorder", returnsObject().noParams()) { it.setReturnRef(it.target?.worldBorder) }
                .function("spawnParticle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )

                        7 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getAsDouble(6)
                        )

                        8 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7)
                        )

                        9 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7),
                            it.getAsDouble(8)
                        )
                        else -> error("World#spawnParticle 函数参数数量错误: ${"args"}")
                    })
                }
                .function("spawnParticle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )

                        7 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getAsDouble(6)
                        )

                        8 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7)
                        )

                        9 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7),
                            it.getAsDouble(8)
                        )
                        else -> error("World#spawnParticle 函数参数数量错误: ${"args"}")
                    })
                }
                .function("spawnParticle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )

                        7 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getAsDouble(6)
                        )

                        8 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7)
                        )

                        9 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7),
                            it.getAsDouble(8)
                        )
                        else -> error("World#spawnParticle 函数参数数量错误: ${"args"}")
                    })
                }
                .function("spawnParticle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )

                        7 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getAsDouble(6)
                        )

                        8 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7)
                        )

                        9 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7),
                            it.getAsDouble(8)
                        )
                        else -> error("World#spawnParticle 函数参数数量错误: ${"args"}")
                    })
                }
                .function("spawnParticle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )

                        7 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getAsDouble(6)
                        )

                        8 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7)
                        )

                        9 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7),
                            it.getAsDouble(8)
                        )
                        else -> error("World#spawnParticle 函数参数数量错误: ${"args"}")
                    })
                }
                .function("spawnParticle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )

                        7 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getAsDouble(6)
                        )

                        8 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7)
                        )

                        9 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7),
                            it.getAsDouble(8)
                        )
                        else -> error("World#spawnParticle 函数参数数量错误: ${"args"}")
                    })
                }
                .function("locateNearestStructure", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var2 = it.getRef(1)) {
                        is StructureType -> it.target?.locateNearestStructure(
                            it.getRef(0) as Location,
                            var2,
                            it.getInt(2).toInt(),
                            it.getBool(3)
                        )

                        is Structure -> it.target?.locateNearestStructure(
                            it.getRef(0) as Location,
                            var2,
                            it.getInt(2).toInt(),
                            it.getBool(3)
                        )

                        else -> throw IllegalArgumentException("第二个参数必须是 StructureType 或 Structure 类型")
                    })
                }
                .function("locateNearestBiome", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.locateNearestBiome(
                            it.getRef(0) as Location,
                            it.getInt(1).toInt()
                        )
                    } else {
                        it.target?.locateNearestBiome(
                            it.getRef(0) as Location,
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt()
                        )
                    })
                }
                .function("locateNearestBiome", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.locateNearestBiome(
                            it.getRef(0) as Location,
                            it.getInt(1).toInt()
                        )
                    } else {
                        it.target?.locateNearestBiome(
                            it.getRef(0) as Location,
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt()
                        )
                    })
                }
                .function("locateNearestRaid", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.locateNearestRaid(
                        it.getRef(0) as Location,
                        it.getInt(1).toInt()
                    ))
                }
                .function("raids", returnsObject().noParams()) { it.setReturnRef(it.target?.raids) }
                .function("enderDragonBattle", returnsObject().noParams()) { it.setReturnRef(it.target?.enderDragonBattle) }
                .function("featureFlags", returnsObject().noParams()) { it.setReturnRef(it.target?.featureFlags) }
                .function("getStructures", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.getStructures(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )
                    } else {
                        it.target?.getStructures(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getRef(2) as Structure
                        )
                    })
                }
                .function("getStructures", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.getStructures(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt()
                        )
                    } else {
                        it.target?.getStructures(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getRef(2) as Structure
                        )
                    })
                }
                .function("isDay", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isDay) }
                .function("isNight", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isNight) }
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

@Requires(classes = ["org.bukkit.World.Environment"])
@PlatformSide(Platform.BUKKIT)
object FnWorldEnvironment {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(World.Environment::class.java)
                .function("id", returnsObject().noParams()) { it.setReturnRef(it.target?.id) }
                // static
                .function("getEnvironment", returnsObject().params(Type.OBJECT)) { it.setReturnRef(World.Environment.getEnvironment(it.getInt(0).toInt())) }
        }
    }
}
