package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.BlockChangeDelegate
import org.bukkit.block.data.BlockData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.BlockChangeDelegate"])
@PlatformSide(Platform.BUKKIT)
object FnBlockChangeDelegate {

    val TYPE = Type.fromClass(BlockChangeDelegate::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockChangeDelegate::class.java)
                .function("setBlockData",returns(Type.Z).params(Type.I, Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE)) {
                    it.setReturnBool(it.target?.setBlockData(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getRef(3) as BlockData
                    ) ?: false)
                }
                .function("getBlockData",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBlockData(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("height", returns(Type.I).noParams()) { it.setReturnInt(it.target?.height ?: 0) }
                .function("isEmpty", returns(Type.Z).params(Type.I, Type.I, Type.I)) {
                    it.setReturnBool(it.target?.isEmpty(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ) ?: false)
                }
        }
    }
}
