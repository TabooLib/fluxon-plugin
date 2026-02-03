package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockPistonRetractEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockPistonRetractEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockPistonRetractEvent {

    val TYPE = Type.fromClass(BlockPistonRetractEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPistonRetractEvent::class.java)
                .function("retractLocation", returns(FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.retractLocation) }
                .function("blocks", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.blocks) }
        }
    }
}
