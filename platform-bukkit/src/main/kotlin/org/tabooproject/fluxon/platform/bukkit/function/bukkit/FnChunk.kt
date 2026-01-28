package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Chunk
import org.bukkit.block.Biome
import org.bukkit.block.data.BlockData
import org.bukkit.generator.structure.Structure
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.Chunk"])
@PlatformSide(Platform.BUKKIT)
object FnChunk {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Chunk::class.java)
                .function("x", returnsObject().noParams()) { it.target?.x }
                .function("z", returnsObject().noParams()) { it.target?.z }
                .function("world", returnsObject().noParams()) { it.target?.world }
                .function("getBlock", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.getBlock(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    )
                }
                .function("chunkSnapshot", returnsObject().noParams()) { it.target?.chunkSnapshot }
                .function("getChunkSnapshot", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.getChunkSnapshot(
                        it.getBool(0),
                        it.getBool(1),
                        it.getBool(2)
                    )
                }
                .function("isEntitiesLoaded", returns(Type.Z).noParams()) { it.target?.isEntitiesLoaded }
                .function("entities", returnsObject().noParams()) { it.target?.entities }
                .function("tileEntities", returnsObject().noParams()) { it.target?.tileEntities }
                .function("isGenerated", returns(Type.Z).noParams()) { it.target?.isGenerated }
                .function("isLoaded", returns(Type.Z).noParams()) { it.target?.isLoaded }
                .function("load", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.load()
                    } else {
                        it.target?.load(it.getBool(0))
                    }
                }
                .function("load", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.load()
                    } else {
                        it.target?.load(it.getBool(0))
                    }
                }
                .function("unload", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.unload()
                    } else {
                        it.target?.unload(it.getBool(0))
                    }
                }
                .function("unload", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.unload()
                    } else {
                        it.target?.unload(it.getBool(0))
                    }
                }
                .function("isSlimeChunk", returns(Type.Z).noParams()) { it.target?.isSlimeChunk }
                .function("isForceLoaded", returns(Type.Z).noParams()) { it.target?.isForceLoaded }
                .function("setForceLoaded", returnsObject().params(Type.OBJECT)) { it.target?.setForceLoaded(it.getBool(0)) }
                .function("addPluginChunkTicket", returnsObject().params(Type.OBJECT)) { it.target?.addPluginChunkTicket(it.getRef(0) as Plugin) }
                .function("removePluginChunkTicket", returnsObject().params(Type.OBJECT)) { it.target?.removePluginChunkTicket(it.getRef(0) as Plugin) }
                .function("pluginChunkTickets", returnsObject().noParams()) { it.target?.pluginChunkTickets }
                .function("inhabitedTime", returnsObject().noParams()) { it.target?.inhabitedTime }
                .function("setInhabitedTime", returnsObject().params(Type.OBJECT)) { it.target?.setInhabitedTime(it.getInt(0).toLong()) }
                .function("contains", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is BlockData -> it.target?.contains(var1)
                        is Biome -> it.target?.contains(var1)
                        else -> throw IllegalArgumentException("参数必须是 BlockData 或 Biome 类型")
                    }
                }
                .function("loadLevel", returnsObject().noParams()) { it.target?.loadLevel }
                .function("structures", returnsObject().noParams()) { it.target?.structures }
                .function("getStructures", returnsObject().params(Type.OBJECT)) { it.target?.getStructures(it.getRef(0) as Structure) }
                .function("playersSeeingChunk", returnsObject().noParams()) { it.target?.playersSeeingChunk }
        }
    }
}
