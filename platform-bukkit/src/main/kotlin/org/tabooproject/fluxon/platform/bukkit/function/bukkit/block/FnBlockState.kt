package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.BlockState
import org.bukkit.block.data.BlockData
import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChunk
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.library.xseries.XMaterial
import kotlin.jvm.optionals.getOrNull

@Requires(classes = ["org.bukkit.block.BlockState"])
@PlatformSide(Platform.BUKKIT)
object FnBlockState {

    val TYPE = Type.fromClass(BlockState::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockState::class.java)
                .function("block", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.block) }
                .function("data", returns(FnMaterialData.TYPE).noParams()) { it.setReturnRef(it.target?.data) }
                .function("blockData", returns(FnBlockData.TYPE).noParams()) { it.setReturnRef(it.target?.blockData) }
                .function("type", returns(FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
                .function("lightLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lightLevel?.toInt() ?: 0) }
                .function("world", returns(FnWorld.TYPE).noParams()) { it.setReturnRef(it.target?.world) }
                .function("x", returns(Type.I).noParams()) { it.setReturnInt(it.target?.x ?: 0) }
                .function("y", returns(Type.I).noParams()) { it.setReturnInt(it.target?.y ?: 0) }
                .function("z", returns(Type.I).noParams()) { it.setReturnInt(it.target?.z ?: 0) }
                .function("location", returns(FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.location) }
                .function("getLocation", returns(FnLocation.TYPE).params(FnLocation.TYPE)) { it.setReturnRef(it.target?.getLocation(it.getRef(0) as Location)) }
                .function("chunk", returns(FnChunk.TYPE).noParams()) { it.setReturnRef(it.target?.chunk) }
                .function("setData", returnsVoid().params(FnMaterialData.TYPE)) { it.target?.setData(it.getRef(0) as MaterialData) }
                .function("setBlockData", returnsVoid().params(FnBlockData.TYPE)) { it.target?.setBlockData(it.getRef(0) as BlockData) }
                .function("setType", returnsVoid().params(FnMaterial.TYPE)) { it.target?.setType(it.getRef(0) as Material) }
                .function("setType", returnsVoid().params(Type.STRING)) { FnMaterial.enumValue(it.getString(0))?.let { p0 -> it.target?.setType(p0) } }
                .function("update", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.update() ?: false) }
                .function("update", returns(Type.Z).params(Type.Z)) {
                    it.setReturnBool(it.target?.update(it.getBool(0)) ?: false)
                }
                .function("update", returns(Type.Z).params(Type.Z, Type.Z)) {
                    it.setReturnBool(it.target?.update(it.getBool(0), it.getBool(1)) ?: false)
                }
                .function("rawData", returns(Type.I).noParams()) { it.setReturnInt(it.target?.rawData?.toInt() ?: 0) }
                .function("setRawData", returnsVoid().params(Type.I)) { it.target?.setRawData(it.getInt(0).toByte()) }
                .function("isPlaced", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPlaced ?: false) }
        }
    }
}
