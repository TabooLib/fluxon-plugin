package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.World
import org.bukkit.WorldCreator
import org.bukkit.WorldType
import org.bukkit.command.CommandSender
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnWorldCreator {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WorldCreator::class.java)
                .function("copy", 1) {
                    // WorldCreator copy(@NotNull World world)
                    // WorldCreator copy(@NotNull WorldCreator creator)
                    TODO()
                }
                .function("name", 0) { it.target?.name() }
                .function("seed", 0) { it.target?.seed() }
                .function("seed", 1) { it.target?.seed(it.getNumber(0).toLong()) }
                .function("environment", 1) { it.target?.environment(it.getArgument(0) as World.Environment) }
                .function("type", 0) { it.target?.type() }
                .function("type", 1) { it.target?.type(it.getArgument(0) as WorldType) }
                .function("generator", 0) { it.target?.generator() }
                .function("generator", 1) {
                    // WorldCreator generator(@Nullable ChunkGenerator generator)
                    // WorldCreator generator(@Nullable String generator)
                    TODO()
                }
                .function("generator", 2) { it.target?.generator(it.getString(0), it.getArgument(1) as CommandSender) }
                .function("biomeProvider", 0) { it.target?.biomeProvider() }
                .function("biomeProvider", 1) {
                    // WorldCreator biomeProvider(@Nullable BiomeProvider biomeProvider)
                    // WorldCreator biomeProvider(@Nullable String biomeProvider)
                    TODO()
                }
                .function("biomeProvider", 2) {
                    it.target?.biomeProvider(
                        it.getString(0),
                        it.getArgument(1) as CommandSender
                    )
                }
                .function("generatorSettings", 1) { it.target?.generatorSettings(it.getString(0)!!) }
                .function("generatorSettings", 0) { it.target?.generatorSettings() }
                .function("generateStructures", 1) { it.target?.generateStructures(it.getBoolean(0)) }
                .function("generateStructures", 0) { it.target?.generateStructures() }
                .function("hardcore", 1) { it.target?.hardcore(it.getBoolean(0)) }
                .function("hardcore", 0) { it.target?.hardcore() }
                .function("keepSpawnInMemory", 1) { it.target?.keepSpawnInMemory(it.getBoolean(0)) }
                .function("keepSpawnInMemory", 0) { it.target?.keepSpawnInMemory() }
                .function("createWorld", 0) { it.target?.createWorld() }
                // static
                .function("name", 1) { WorldCreator.name(it.getString(0)!!) }
                // static
                .function("generatorForName", 3) {
                    WorldCreator.getGeneratorForName(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getArgument(2) as CommandSender
                    )
                }
                // static
                .function("biomeProviderForName", 3) {
                    WorldCreator.getBiomeProviderForName(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getArgument(2) as CommandSender
                    )
                }
        }
    }
}
