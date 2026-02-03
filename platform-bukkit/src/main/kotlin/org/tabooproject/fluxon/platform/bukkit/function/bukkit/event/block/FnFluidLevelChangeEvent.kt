package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.block.data.BlockData
import org.bukkit.event.block.FluidLevelChangeEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.FluidLevelChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnFluidLevelChangeEvent {

    val TYPE = Type.fromClass(FluidLevelChangeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FluidLevelChangeEvent::class.java)
                .function("newData", returns(FnBlockData.TYPE).noParams()) { it.setReturnRef(it.target?.newData) }
                .function("setNewData", returnsVoid().params(FnBlockData.TYPE)) { it.target?.setNewData(it.getRef(0) as BlockData) }
        }
    }
}
