package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockCanBuildEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.event.block.BlockCanBuildEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockCanBuildEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockCanBuildEvent::class.java)
                .function("isBuildable", returns(Type.Z).noParams()) { it.target?.isBuildable }
                .function("setBuildable", returnsObject().params(Type.OBJECT)) { it.target?.setBuildable(it.getBool(0)) }
                .function("material", returnsObject().noParams()) { it.target?.material }
                .function("blockData", returnsObject().noParams()) { it.target?.blockData }
                .function("player", returnsObject().noParams()) { it.target?.player }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { BlockCanBuildEvent.getHandlerList() }
        }
    }
}
