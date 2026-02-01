package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type


@Requires(classes = ["org.bukkit.event.block.BlockEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockEvent {

    val TYPE = Type.fromClass(BlockEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockEvent::class.java)
                .function("block", returnsObject().noParams()) { it.setReturnRef(it.target?.getBlock()) }
        }
    }
}
