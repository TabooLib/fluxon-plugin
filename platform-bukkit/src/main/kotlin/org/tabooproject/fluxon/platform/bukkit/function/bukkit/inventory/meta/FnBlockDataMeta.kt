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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.BlockDataMeta"])
@PlatformSide(Platform.BUKKIT)
object FnBlockDataMeta {

    val TYPE = Type.fromClass(BlockDataMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDataMeta::class.java)
                .function("hasBlockData", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasBlockData() ?: false) }
                .function("getBlockData",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnRef(it.target?.getBlockData(it.getRef(0) as Material)) }
                .function("setBlockData",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE)) { it.target?.setBlockData(it.getRef(0) as BlockData) }
        }
    }
}
