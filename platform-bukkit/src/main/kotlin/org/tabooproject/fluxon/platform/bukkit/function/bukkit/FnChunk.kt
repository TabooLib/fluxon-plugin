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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.Chunk"])
@PlatformSide(Platform.BUKKIT)
object FnChunk {

    val TYPE = Type.fromClass(Chunk::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Chunk::class.java)
                .function("x", returns(Type.I).noParams()) { it.setReturnInt(it.target?.x ?: 0) }
                .function("z", returns(Type.I).noParams()) { it.setReturnInt(it.target?.z ?: 0) }
                .function("world", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE).noParams()) { it.setReturnRef(it.target?.world) }
                .function("getBlock", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBlock(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("chunkSnapshot", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunkSnapshot.TYPE).noParams()) { it.setReturnRef(it.target?.chunkSnapshot) }
                .function("getChunkSnapshot", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunkSnapshot.TYPE).params(Type.Z, Type.Z, Type.Z)) {
                    it.setReturnRef(it.target?.getChunkSnapshot(
                        it.getBool(0),
                        it.getBool(1),
                        it.getBool(2)
                    ))
                }
                .function("isEntitiesLoaded", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEntitiesLoaded ?: false) }
                .function("entities", returns(Type.fromClass(Array<org.bukkit.entity.Entity>::class.java)).noParams()) { it.setReturnRef(it.target?.entities) }
                .function("tileEntities", returns(Type.fromClass(Array<org.bukkit.block.BlockState>::class.java)).noParams()) { it.setReturnRef(it.target?.tileEntities) }
                .function("isGenerated", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isGenerated ?: false) }
                .function("isLoaded", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLoaded ?: false) }
                .function("load", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.load() ?: false) }
                .function("load", returns(Type.Z).params(Type.Z)) { it.setReturnBool(it.target?.load(it.getBool(0)) ?: false) }
                .function("unload", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.unload() ?: false) }
                .function("unload", returns(Type.Z).params(Type.Z)) { it.setReturnBool(it.target?.unload(it.getBool(0)) ?: false) }
                .function("isSlimeChunk", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSlimeChunk ?: false) }
                .function("isForceLoaded", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isForceLoaded ?: false) }
                .function("setForceLoaded", returnsVoid().params(Type.Z)) { it.target?.setForceLoaded(it.getBool(0)) }
                .function("addPluginChunkTicket",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.setReturnBool(it.target?.addPluginChunkTicket(it.getRef(0) as Plugin) ?: false)
                }
                .function("removePluginChunkTicket",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.setReturnBool(it.target?.removePluginChunkTicket(it.getRef(0) as Plugin) ?: false)
                }
                .function("pluginChunkTickets", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.pluginChunkTickets) }
                .function("inhabitedTime", returns(Type.J).noParams()) { it.setReturnLong(it.target?.inhabitedTime ?: 0L) }
                .function("setInhabitedTime", returnsVoid().params(Type.J)) { it.target?.setInhabitedTime(it.getLong(0)) }
                .function("contains", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE)) { it.setReturnBool(it.target?.contains(it.getRef(0) as BlockData) ?: false) }
                .function("contains", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.TYPE)) { it.setReturnBool(it.target?.contains(it.getRef(0) as Biome) ?: false) }
                .function("contains", returns(Type.Z).params(Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.enumValue(it.getString(0))?.let { p0 ->
                        it.setReturnBool(it.target?.contains(p0) ?: false)
                    }
                }
                .function("loadLevel", returns(FnChunkLoadLevel.TYPE).noParams()) { it.setReturnRef(it.target?.loadLevel) }
                .function("structures", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.structures) }
                .function("getStructures",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure.FnStructure.TYPE)) { it.setReturnRef(it.target?.getStructures(it.getRef(0) as Structure)) }
                .function("playersSeeingChunk", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.playersSeeingChunk) }
        }
    }
}
