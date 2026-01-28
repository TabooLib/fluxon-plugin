package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.BlockState
import org.bukkit.block.data.BlockData
import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.BlockState"])
@PlatformSide(Platform.BUKKIT)
object FnBlockState {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockState::class.java)
                .function("block", returnsObject().noParams()) { it.setReturnRef(it.target?.block) }
                .function("data", returnsObject().noParams()) { it.setReturnRef(it.target?.data) }
                .function("blockData", returnsObject().noParams()) { it.setReturnRef(it.target?.blockData) }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                .function("lightLevel", returnsObject().noParams()) { it.setReturnRef(it.target?.lightLevel) }
                .function("world", returnsObject().noParams()) { it.setReturnRef(it.target?.world) }
                .function("x", returnsObject().noParams()) { it.setReturnRef(it.target?.x) }
                .function("y", returnsObject().noParams()) { it.setReturnRef(it.target?.y) }
                .function("z", returnsObject().noParams()) { it.setReturnRef(it.target?.z) }
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
                .function("getLocation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getLocation(it.getRef(0) as Location)) }
                .function("chunk", returnsObject().noParams()) { it.setReturnRef(it.target?.chunk) }
                .function("setData", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setData(it.getRef(0) as MaterialData)) }
                .function("setBlockData", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBlockData(it.getRef(0) as BlockData)) }
                .function("setType", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setType(it.getRef(0) as Material)) }
                .function("update", returnsObject().noParams()) {
                    it.setReturnRef(when (it.argumentCount) {
                        0 -> it.target?.update()
                        1 -> it.target?.update(it.getBool(0))
                        2 -> it.target?.update(it.getBool(0), it.getBool(1))
                        else -> error("BlockState#update 函数参数数量错误: ${"args"}")
                    })
                }
                .function("update", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        0 -> it.target?.update()
                        1 -> it.target?.update(it.getBool(0))
                        2 -> it.target?.update(it.getBool(0), it.getBool(1))
                        else -> error("BlockState#update 函数参数数量错误: ${"args"}")
                    })
                }
                .function("update", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        0 -> it.target?.update()
                        1 -> it.target?.update(it.getBool(0))
                        2 -> it.target?.update(it.getBool(0), it.getBool(1))
                        else -> error("BlockState#update 函数参数数量错误: ${"args"}")
                    })
                }
                .function("rawData", returnsObject().noParams()) { it.setReturnRef(it.target?.rawData) }
                .function("setRawData", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRawData(it.getInt(0).toByte())) }
                .function("isPlaced", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isPlaced) }
        }
    }
}
