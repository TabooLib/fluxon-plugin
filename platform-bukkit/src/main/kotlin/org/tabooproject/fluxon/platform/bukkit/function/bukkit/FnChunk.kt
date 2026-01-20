package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Chunk
import org.bukkit.block.Biome
import org.bukkit.block.data.BlockData
import org.bukkit.generator.structure.Structure
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnChunk {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Chunk::class.java)
                .function("x", 0) { it.target?.x }
                .function("z", 0) { it.target?.z }
                .function("world", 0) { it.target?.world }
                .function("block", 3) {
                    it.target?.getBlock(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt()
                    )
                }
                .function("chunkSnapshot", listOf(0, 3)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.chunkSnapshot
                    } else {
                        it.target?.getChunkSnapshot(
                            it.getBoolean(0),
                            it.getBoolean(1),
                            it.getBoolean(2)
                        )
                    }
                }
                .function("isEntitiesLoaded", 0) { it.target?.isEntitiesLoaded }
                .function("entities", 0) { it.target?.entities }
                .function("tileEntities", 0) { it.target?.tileEntities }
                .function("isGenerated", 0) { it.target?.isGenerated }
                .function("isLoaded", 0) { it.target?.isLoaded }
                .function("load", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.load()
                    } else {
                        it.target?.load(it.getBoolean(0))
                    }
                }
                .function("unload", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.unload()
                    } else {
                        it.target?.unload(it.getBoolean(0))
                    }
                }
                .function("isSlimeChunk", 0) { it.target?.isSlimeChunk }
                .function("isForceLoaded", 0) { it.target?.isForceLoaded }
                .function("setForceLoaded", 1) { it.target?.setForceLoaded(it.getBoolean(0)) }
                .function("addPluginChunkTicket", 1) { it.target?.addPluginChunkTicket(it.getArgument(0) as Plugin) }
                .function(
                    "removePluginChunkTicket",
                    1
                ) { it.target?.removePluginChunkTicket(it.getArgument(0) as Plugin) }
                .function("pluginChunkTickets", 0) { it.target?.pluginChunkTickets }
                .function("inhabitedTime", 0) { it.target?.inhabitedTime }
                .function("setInhabitedTime", 1) { it.target?.setInhabitedTime(it.getNumber(0).toLong()) }
                .function("contains", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is BlockData -> it.target?.contains(var1)
                        is Biome -> it.target?.contains(var1)
                        else -> throw IllegalArgumentException("参数必须是 BlockData 或 Biome 类型")
                    }
                }
                .function("loadLevel", 0) { it.target?.loadLevel }
                .function("structures", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.structures
                    } else {
                        it.target?.getStructures(it.getArgument(0) as Structure)
                    }
                }
                .function("playersSeeingChunk", 0) { it.target?.playersSeeingChunk }
        }
    }
}
