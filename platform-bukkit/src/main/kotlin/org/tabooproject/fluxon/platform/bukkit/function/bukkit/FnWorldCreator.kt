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

    val TYPE = Type.fromClass(WorldCreator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WorldCreator::class.java)
                .function("copy", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is World -> it.target?.copy(var1)
                        is WorldCreator -> it.target?.copy(var1)
                        else -> throw IllegalArgumentException("参数必须是 World 或 WorldCreator 类型")
                    })
                }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name()) }
                // static
                .function("name", returnsObject().params(Type.STRING)) { it.setReturnRef(WorldCreator.name(it.getString(0)!!)) }
                .function("seed", returns(Type.J).noParams()) { it.setReturnLong(it.target?.seed() ?: 0L) }
                .function("seed", returnsObject().params(Type.J)) { it.setReturnRef(it.target?.seed(it.getLong(0))) }
                .function("environment", returnsObject().noParams()) { it.setReturnRef(it.target?.environment()) }
                .function("environment", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.environment(it.getRef(0) as World.Environment))
                }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type()) }
                .function("type", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.type(it.getRef(0) as WorldType))
                }
                .function("generator", returnsObject().noParams()) { it.setReturnRef(it.target?.generator()) }
                .function("generator", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is ChunkGenerator -> it.target?.generator(var1)
                        is String -> it.target?.generator(var1)
                        else -> throw IllegalArgumentException("参数必须是 ChunkGenerator 或 String 类型")
                    })
                }
                .function("generator", returnsObject().params(Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(it.target?.generator(it.getString(0), it.getRef(1) as CommandSender))
                }
                .function("biomeProvider", returnsObject().noParams()) { it.setReturnRef(it.target?.biomeProvider()) }
                .function("biomeProvider", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is BiomeProvider -> it.target?.biomeProvider(var1)
                        is String -> it.target?.biomeProvider(var1)
                        else -> throw IllegalArgumentException("参数必须是 BiomeProvider 或 String 类型")
                    })
                }
                .function("biomeProvider", returnsObject().params(Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(it.target?.biomeProvider(
                        it.getString(0),
                        it.getRef(1) as CommandSender
                    ))
                }
                .function("generatorSettings", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.generatorSettings()) }
                .function("generatorSettings", returnsObject().params(Type.STRING)) {
                    it.setReturnRef(it.target?.generatorSettings(it.getString(0)!!))
                }
                .function("generateStructures", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.generateStructures() ?: false) }
                .function("generateStructures", returnsObject().params(Type.Z)) {
                    it.setReturnRef(it.target?.generateStructures(it.getBool(0)))
                }
                .function("hardcore", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hardcore() ?: false) }
                .function("hardcore", returnsObject().params(Type.Z)) { it.setReturnRef(it.target?.hardcore(it.getBool(0))) }
                .function("keepSpawnInMemory", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.keepSpawnInMemory() ?: false) }
                .function("keepSpawnInMemory", returnsObject().params(Type.Z)) {
                    it.setReturnRef(it.target?.keepSpawnInMemory(it.getBool(0)))
                }
                .function("createWorld", returnsObject().noParams()) { it.setReturnRef(it.target?.createWorld()) }
                // static
                .function("getGeneratorForName", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(WorldCreator.getGeneratorForName(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getRef(2) as CommandSender
                    ))
                }
                // static
                .function("getBiomeProviderForName", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(WorldCreator.getBiomeProviderForName(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getRef(2) as CommandSender
                    ))
                }
        }
    }
}
