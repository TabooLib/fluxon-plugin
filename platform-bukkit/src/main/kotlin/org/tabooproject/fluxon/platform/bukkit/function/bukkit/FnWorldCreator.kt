package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.World
import org.bukkit.WorldCreator
import org.bukkit.WorldType
import org.bukkit.command.CommandSender
import org.bukkit.generator.BiomeProvider
import org.bukkit.generator.ChunkGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.WorldCreator"])
@PlatformSide(Platform.BUKKIT)
object FnWorldCreator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WorldCreator::class.java)
                .function("copy", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is World -> it.target?.copy(var1)
                        is WorldCreator -> it.target?.copy(var1)
                        else -> throw IllegalArgumentException("参数必须是 World 或 WorldCreator 类型")
                    }
                }
                .function("name", returns(Type.STRING).noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.name()
                    } else {
                        WorldCreator.name(it.getString(0)!!)
                    }
                }
                .function("name", returns(Type.STRING).params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.name()
                    } else {
                        WorldCreator.name(it.getString(0)!!)
                    }
                }
                .function("seed", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.seed()
                    } else {
                        it.target?.seed(it.getInt(0).toLong())
                    }
                }
                .function("seed", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.seed()
                    } else {
                        it.target?.seed(it.getInt(0).toLong())
                    }
                }
                .function("environment", returnsObject().params(Type.OBJECT)) { it.target?.environment(it.getRef(0) as World.Environment) }
                .function("type", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.type()
                    } else {
                        it.target?.type(it.getRef(0) as WorldType)
                    }
                }
                .function("type", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.type()
                    } else {
                        it.target?.type(it.getRef(0) as WorldType)
                    }
                }
                .function("generator", returnsObject().noParams()) {
                    when (it.argumentCount) {
                        0 -> it.target?.generator()
                        1 -> when (val var1 = it.getRef(0)) {
                            is ChunkGenerator -> it.target?.generator(var1)
                            is String -> it.target?.generator(var1)
                            else -> throw IllegalArgumentException("参数必须是 ChunkGenerator 或 String 类型")
                        }

                        2 -> it.target?.generator(it.getString(0), it.getRef(1) as CommandSender)
                        else -> error("WorldCreator#generator 函数参数数量错误: ${"args"}")
                    }
                }
                .function("generator", returnsObject().params(Type.OBJECT)) {
                    when (it.argumentCount) {
                        0 -> it.target?.generator()
                        1 -> when (val var1 = it.getRef(0)) {
                            is ChunkGenerator -> it.target?.generator(var1)
                            is String -> it.target?.generator(var1)
                            else -> throw IllegalArgumentException("参数必须是 ChunkGenerator 或 String 类型")
                        }

                        2 -> it.target?.generator(it.getString(0), it.getRef(1) as CommandSender)
                        else -> error("WorldCreator#generator 函数参数数量错误: ${"args"}")
                    }
                }
                .function("generator", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        0 -> it.target?.generator()
                        1 -> when (val var1 = it.getRef(0)) {
                            is ChunkGenerator -> it.target?.generator(var1)
                            is String -> it.target?.generator(var1)
                            else -> throw IllegalArgumentException("参数必须是 ChunkGenerator 或 String 类型")
                        }

                        2 -> it.target?.generator(it.getString(0), it.getRef(1) as CommandSender)
                        else -> error("WorldCreator#generator 函数参数数量错误: ${"args"}")
                    }
                }
                .function("biomeProvider", returnsObject().noParams()) {
                    when (it.argumentCount) {
                        0 -> it.target?.biomeProvider()
                        1 -> when (val var1 = it.getRef(0)) {
                            is BiomeProvider -> it.target?.biomeProvider(var1)
                            is String -> it.target?.biomeProvider(var1)
                            else -> throw IllegalArgumentException("参数必须是 BiomeProvider 或 String 类型")
                        }

                        2 -> it.target?.biomeProvider(
                            it.getString(0),
                            it.getRef(1) as CommandSender
                        )
                        else -> error("WorldCreator#biomeProvider 函数参数数量错误: ${"args"}")
                    }
                }
                .function("biomeProvider", returnsObject().params(Type.OBJECT)) {
                    when (it.argumentCount) {
                        0 -> it.target?.biomeProvider()
                        1 -> when (val var1 = it.getRef(0)) {
                            is BiomeProvider -> it.target?.biomeProvider(var1)
                            is String -> it.target?.biomeProvider(var1)
                            else -> throw IllegalArgumentException("参数必须是 BiomeProvider 或 String 类型")
                        }

                        2 -> it.target?.biomeProvider(
                            it.getString(0),
                            it.getRef(1) as CommandSender
                        )
                        else -> error("WorldCreator#biomeProvider 函数参数数量错误: ${"args"}")
                    }
                }
                .function("biomeProvider", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        0 -> it.target?.biomeProvider()
                        1 -> when (val var1 = it.getRef(0)) {
                            is BiomeProvider -> it.target?.biomeProvider(var1)
                            is String -> it.target?.biomeProvider(var1)
                            else -> throw IllegalArgumentException("参数必须是 BiomeProvider 或 String 类型")
                        }

                        2 -> it.target?.biomeProvider(
                            it.getString(0),
                            it.getRef(1) as CommandSender
                        )
                        else -> error("WorldCreator#biomeProvider 函数参数数量错误: ${"args"}")
                    }
                }
                .function("generatorSettings", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.generatorSettings()
                    } else {
                        it.target?.generatorSettings(it.getString(0)!!)
                    }
                }
                .function("generatorSettings", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.generatorSettings()
                    } else {
                        it.target?.generatorSettings(it.getString(0)!!)
                    }
                }
                .function("generateStructures", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.generateStructures()
                    } else {
                        it.target?.generateStructures(it.getBool(0))
                    }
                }
                .function("generateStructures", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.generateStructures()
                    } else {
                        it.target?.generateStructures(it.getBool(0))
                    }
                }
                .function("hardcore", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.hardcore()
                    } else {
                        it.target?.hardcore(it.getBool(0))
                    }
                }
                .function("hardcore", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.hardcore()
                    } else {
                        it.target?.hardcore(it.getBool(0))
                    }
                }
                .function("keepSpawnInMemory", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.keepSpawnInMemory()
                    } else {
                        it.target?.keepSpawnInMemory(it.getBool(0))
                    }
                }
                .function("keepSpawnInMemory", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.keepSpawnInMemory()
                    } else {
                        it.target?.keepSpawnInMemory(it.getBool(0))
                    }
                }
                .function("createWorld", returnsObject().noParams()) { it.target?.createWorld() }
                // static
                .function("getGeneratorForName", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    WorldCreator.getGeneratorForName(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getRef(2) as CommandSender
                    )
                }
                // static
                .function("getBiomeProviderForName", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    WorldCreator.getBiomeProviderForName(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getRef(2) as CommandSender
                    )
                }
        }
    }
}
