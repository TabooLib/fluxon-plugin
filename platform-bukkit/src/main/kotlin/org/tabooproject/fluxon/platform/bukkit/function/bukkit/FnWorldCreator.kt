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

@Requires(classes = ["org.bukkit.WorldCreator"])
@PlatformSide(Platform.BUKKIT)
object FnWorldCreator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WorldCreator::class.java)
                .function("copy", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is World -> it.target?.copy(var1)
                        is WorldCreator -> it.target?.copy(var1)
                        else -> throw IllegalArgumentException("参数必须是 World 或 WorldCreator 类型")
                    }
                }
                .function("name", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.name()
                    } else {
                        WorldCreator.name(it.getString(0)!!)
                    }
                }
                .function("seed", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.seed()
                    } else {
                        it.target?.seed(it.getNumber(0).toLong())
                    }
                }
                .function("environment", 1) { it.target?.environment(it.getArgument(0) as World.Environment) }
                .function("type", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.type()
                    } else {
                        it.target?.type(it.getArgument(0) as WorldType)
                    }
                }
                .function("generator", listOf(0, 1, 2)) {
                    when (it.arguments.size) {
                        0 -> it.target?.generator()
                        1 -> when (val var1 = it.getArgument(0)) {
                            is ChunkGenerator -> it.target?.generator(var1)
                            is String -> it.target?.generator(var1)
                            else -> throw IllegalArgumentException("参数必须是 ChunkGenerator 或 String 类型")
                        }

                        2 -> it.target?.generator(it.getString(0), it.getArgument(1) as CommandSender)
                        else -> error("WorldCreator#generator 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("biomeProvider", listOf(0, 1, 2)) {
                    when (it.arguments.size) {
                        0 -> it.target?.biomeProvider()
                        1 -> when (val var1 = it.getArgument(0)) {
                            is BiomeProvider -> it.target?.biomeProvider(var1)
                            is String -> it.target?.biomeProvider(var1)
                            else -> throw IllegalArgumentException("参数必须是 BiomeProvider 或 String 类型")
                        }

                        2 -> it.target?.biomeProvider(
                            it.getString(0),
                            it.getArgument(1) as CommandSender
                        )
                        else -> error("WorldCreator#biomeProvider 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("generatorSettings", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.generatorSettings()
                    } else {
                        it.target?.generatorSettings(it.getString(0)!!)
                    }
                }
                .function("generateStructures", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.generateStructures()
                    } else {
                        it.target?.generateStructures(it.getBoolean(0))
                    }
                }
                .function("hardcore", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.hardcore()
                    } else {
                        it.target?.hardcore(it.getBoolean(0))
                    }
                }
                .function("keepSpawnInMemory", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.keepSpawnInMemory()
                    } else {
                        it.target?.keepSpawnInMemory(it.getBoolean(0))
                    }
                }
                .function("createWorld", 0) { it.target?.createWorld() }
                // static
                .function("getGeneratorForName", 3) {
                    WorldCreator.getGeneratorForName(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getArgument(2) as CommandSender
                    )
                }
                // static
                .function("getBiomeProviderForName", 3) {
                    WorldCreator.getBiomeProviderForName(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getArgument(2) as CommandSender
                    )
                }
        }
    }
}
