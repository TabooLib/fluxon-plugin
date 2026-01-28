package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.HeightMap
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.RegionAccessor
import org.bukkit.block.Biome
import org.bukkit.block.data.BlockData
import org.bukkit.entity.EntityType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.RegionAccessor"])
@PlatformSide(Platform.BUKKIT)
object FnRegionAccessor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RegionAccessor::class.java)
                .function("getBiome", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getBiome(it.getRef(0) as Location)
                    } else {
                        it.target?.getBiome(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    }
                }
                .function("getBiome", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getBiome(it.getRef(0) as Location)
                    } else {
                        it.target?.getBiome(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    }
                }
                .syncFunction("setBiome", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.setBiome(
                            it.getRef(0) as Location,
                            it.getRef(1) as Biome
                        )
                    } else {
                        it.target?.setBiome(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getRef(3) as Biome
                        )
                    }
                }
                .syncFunction("setBiome", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.setBiome(
                            it.getRef(0) as Location,
                            it.getRef(1) as Biome
                        )
                    } else {
                        it.target?.setBiome(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getRef(3) as Biome
                        )
                    }
                }
                .function("getBlockState", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getBlockState(it.getRef(0) as Location)
                    } else {
                        it.target?.getBlockState(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    }
                }
                .function("getBlockState", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getBlockState(it.getRef(0) as Location)
                    } else {
                        it.target?.getBlockState(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    }
                }
                .function("getBlockData", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getBlockData(it.getRef(0) as Location)
                    } else {
                        it.target?.getBlockData(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    }
                }
                .function("getBlockData", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getBlockData(it.getRef(0) as Location)
                    } else {
                        it.target?.getBlockData(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    }
                }
                .function("getType", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getType(it.getRef(0) as Location)
                    } else {
                        it.target?.getType(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    }
                }
                .function("getType", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getType(it.getRef(0) as Location)
                    } else {
                        it.target?.getType(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    }
                }
                .syncFunction("setBlockData", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.setBlockData(
                            it.getRef(0) as Location,
                            it.getRef(1) as BlockData
                        )
                    } else {
                        it.target?.setBlockData(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getRef(3) as BlockData
                        )
                    }
                }
                .syncFunction("setBlockData", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.setBlockData(
                            it.getRef(0) as Location,
                            it.getRef(1) as BlockData
                        )
                    } else {
                        it.target?.setBlockData(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getRef(3) as BlockData
                        )
                    }
                }
                .syncFunction("setType", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.setType(
                            it.getRef(0) as Location,
                            it.getRef(1) as Material
                        )
                    } else {
                        it.target?.setType(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getRef(3) as Material
                        )
                    }
                }
                .syncFunction("setType", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.setType(
                            it.getRef(0) as Location,
                            it.getRef(1) as Material
                        )
                    } else {
                        it.target?.setType(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getRef(3) as Material
                        )
                    }
                }
                .syncFunction("generateTree", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.generateTree(
                        it.getRef(0) as Location,
                        it.getRef(1) as java.util.Random,
                        it.getRef(2) as org.bukkit.TreeType
                    )
                }
                .syncFunction("spawnEntity", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.spawnEntity(
                            it.getRef(0) as Location,
                            it.getRef(1) as EntityType
                        )
                    } else {
                        it.target?.spawnEntity(
                            it.getRef(0) as Location,
                            it.getRef(1) as EntityType,
                            it.getBool(2)
                        )
                    }
                }
                .syncFunction("spawnEntity", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.spawnEntity(
                            it.getRef(0) as Location,
                            it.getRef(1) as EntityType
                        )
                    } else {
                        it.target?.spawnEntity(
                            it.getRef(0) as Location,
                            it.getRef(1) as EntityType,
                            it.getBool(2)
                        )
                    }
                }
                .function("entities", returnsObject().noParams()) { it.target?.entities }
                .function("livingEntities", returnsObject().noParams()) { it.target?.livingEntities }
                .function("entitiesByClasses", returnsObject().noParams()) { it.target?.getEntitiesByClasses() }
                .function("getHighestBlockYAt", returnsObject().params(Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.getHighestBlockYAt(it.getRef(0) as Location)
                        2 -> when (val var1 = it.getRef(0)) {
                            is Int -> it.target?.getHighestBlockYAt(var1, it.getInt(1).toInt())
                            is Location -> it.target?.getHighestBlockYAt(var1, it.getRef(1) as HeightMap)
                            else -> throw IllegalArgumentException("参数 1 必须是 Int 或 Location 类型")
                        }

                        3 -> it.target?.getHighestBlockYAt(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getRef(2) as HeightMap
                        )
                        else -> error("RegionAccessor#highestBlockYAt 函数参数数量错误: ${"args"}")
                    }
                }
                .function("getHighestBlockYAt", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.getHighestBlockYAt(it.getRef(0) as Location)
                        2 -> when (val var1 = it.getRef(0)) {
                            is Int -> it.target?.getHighestBlockYAt(var1, it.getInt(1).toInt())
                            is Location -> it.target?.getHighestBlockYAt(var1, it.getRef(1) as HeightMap)
                            else -> throw IllegalArgumentException("参数 1 必须是 Int 或 Location 类型")
                        }

                        3 -> it.target?.getHighestBlockYAt(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getRef(2) as HeightMap
                        )
                        else -> error("RegionAccessor#highestBlockYAt 函数参数数量错误: ${"args"}")
                    }
                }
                .function("getHighestBlockYAt", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.getHighestBlockYAt(it.getRef(0) as Location)
                        2 -> when (val var1 = it.getRef(0)) {
                            is Int -> it.target?.getHighestBlockYAt(var1, it.getInt(1).toInt())
                            is Location -> it.target?.getHighestBlockYAt(var1, it.getRef(1) as HeightMap)
                            else -> throw IllegalArgumentException("参数 1 必须是 Int 或 Location 类型")
                        }

                        3 -> it.target?.getHighestBlockYAt(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getRef(2) as HeightMap
                        )
                        else -> error("RegionAccessor#highestBlockYAt 函数参数数量错误: ${"args"}")
                    }
                }
        }
    }
}
