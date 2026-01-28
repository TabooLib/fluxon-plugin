package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.Material
import org.bukkit.block.data.BlockData
import org.bukkit.inventory.meta.BlockDataMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.BlockDataMeta"])
@PlatformSide(Platform.BUKKIT)
object FnBlockDataMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDataMeta::class.java)
                .function("hasBlockData", returns(Type.Z).noParams()) { it.target?.hasBlockData() }
                .function("getBlockData", returnsObject().params(Type.OBJECT)) { it.target?.getBlockData(it.getRef(0) as Material) }
                .function("setBlockData", returnsObject().params(Type.OBJECT)) { it.target?.setBlockData(it.getRef(0) as BlockData) }
        }
    }
}
