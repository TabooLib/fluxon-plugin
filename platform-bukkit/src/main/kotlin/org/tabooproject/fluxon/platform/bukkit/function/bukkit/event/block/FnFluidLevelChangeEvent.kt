package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.block.data.BlockData
import org.bukkit.event.block.FluidLevelChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.block.FluidLevelChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnFluidLevelChangeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FluidLevelChangeEvent::class.java)
                .function("newData", returnsObject().noParams()) { it.target?.newData }
                .function("setNewData", returnsObject().params(Type.OBJECT)) { it.target?.setNewData(it.getRef(0) as BlockData) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { FluidLevelChangeEvent.getHandlerList() }
        }
    }
}
