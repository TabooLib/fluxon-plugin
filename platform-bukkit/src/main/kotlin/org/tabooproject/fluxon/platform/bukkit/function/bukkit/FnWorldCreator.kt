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
                .function("copy", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) { it.setReturnRef(it.target?.copy(it.getRef(0) as World)) }
                .function("copy", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE)) { it.setReturnRef(it.target?.copy(it.getRef(0) as WorldCreator)) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name()) }
                // static
                .function("name",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(Type.STRING)) { it.setReturnRef(WorldCreator.name(it.getString(0)!!)) }
                .function("seed", returns(Type.J).noParams()) { it.setReturnLong(it.target?.seed() ?: 0L) }
                .function("seed",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(Type.J)) { it.setReturnRef(it.target?.seed(it.getLong(0))) }
                .function("environment", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldEnvironment.TYPE).noParams()) { it.setReturnRef(it.target?.environment()) }
                .function("environment",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldEnvironment.TYPE)) {
                    it.setReturnRef(it.target?.environment(it.getRef(0) as World.Environment))
                }
                .function("type",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldType.TYPE).noParams()) { it.setReturnRef(it.target?.type()) }
                .function("type",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldType.TYPE)) {
                    it.setReturnRef(it.target?.type(it.getRef(0) as WorldType))
                }
                .function("generator",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnChunkGenerator.TYPE).noParams()) { it.setReturnRef(it.target?.generator()) }
                .function("generator",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnChunkGenerator.TYPE)) { it.setReturnRef(it.target?.generator(it.getRef(0) as ChunkGenerator)) }
                .function("generator",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.generator(it.getString(0))) }
                .function("generator",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE)) {
                    it.setReturnRef(it.target?.generator(it.getString(0), it.getRef(1) as CommandSender))
                }
                .function("biomeProvider",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnBiomeProvider.TYPE).noParams()) { it.setReturnRef(it.target?.biomeProvider()) }
                .function("biomeProvider",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnBiomeProvider.TYPE)) { it.setReturnRef(it.target?.biomeProvider(it.getRef(0) as BiomeProvider)) }
                .function("biomeProvider",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.biomeProvider(it.getString(0))) }
                .function("biomeProvider",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE)) {
                    it.setReturnRef(it.target?.biomeProvider(
                        it.getString(0),
                        it.getRef(1) as CommandSender
                    ))
                }
                .function("generatorSettings", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.generatorSettings()) }
                .function("generatorSettings",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(Type.STRING)) {
                    it.setReturnRef(it.target?.generatorSettings(it.getString(0)!!))
                }
                .function("generateStructures", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.generateStructures() ?: false) }
                .function("generateStructures",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(Type.Z)) {
                    it.setReturnRef(it.target?.generateStructures(it.getBool(0)))
                }
                .function("hardcore", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hardcore() ?: false) }
                .function("hardcore",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldCreator.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.hardcore(it.getBool(0))) }
                .function("keepSpawnInMemory", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.keepSpawnInMemory() ?: false) }
                .function("keepSpawnInMemory", returns(TYPE).params(Type.Z)) {
                    it.setReturnRef(it.target?.keepSpawnInMemory(it.getBool(0)))
                }
                .function("createWorld", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE).noParams()) { it.setReturnRef(it.target?.createWorld()) }
                // static
                .function("getGeneratorForName",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnChunkGenerator.TYPE).params(Type.STRING, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE)) {
                    it.setReturnRef(WorldCreator.getGeneratorForName(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getRef(2) as CommandSender
                    ))
                }
                // static
                .function("getBiomeProviderForName",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnBiomeProvider.TYPE).params(Type.STRING, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE)) {
                    it.setReturnRef(WorldCreator.getBiomeProviderForName(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getRef(2) as CommandSender
                    ))
                }
        }
    }
}
