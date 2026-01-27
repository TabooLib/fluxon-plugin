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

@Requires(classes = ["org.bukkit.block.BlockState"])
@PlatformSide(Platform.BUKKIT)
object FnBlockState {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockState::class.java)
                .function("block", 0) { it.target?.block }
                .function("data", 0) { it.target?.data }
                .function("blockData", 0) { it.target?.blockData }
                .function("type", 0) { it.target?.type }
                .function("lightLevel", 0) { it.target?.lightLevel }
                .function("world", 0) { it.target?.world }
                .function("x", 0) { it.target?.x }
                .function("y", 0) { it.target?.y }
                .function("z", 0) { it.target?.z }
                .function("location", 0) { it.target?.location }
                .function("getLocation", 1) { it.target?.getLocation(it.getArgument(0) as Location) }
                .function("chunk", 0) { it.target?.chunk }
                .function("setData", 1) { it.target?.setData(it.getArgument(0) as MaterialData) }
                .function("setBlockData", 1) { it.target?.setBlockData(it.getArgument(0) as BlockData) }
                .function("setType", 1) { it.target?.setType(it.getArgument(0) as Material) }
                .function("update", listOf(0, 1, 2)) {
                    when (it.arguments.size) {
                        0 -> it.target?.update()
                        1 -> it.target?.update(it.getBoolean(0))
                        2 -> it.target?.update(it.getBoolean(0), it.getBoolean(1))
                        else -> error("BlockState#update 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("rawData", 0) { it.target?.rawData }
                .function("setRawData", 1) { it.target?.setRawData(it.getNumber(0).toByte()) }
                .function("isPlaced", 0) { it.target?.isPlaced }
        }
    }
}
