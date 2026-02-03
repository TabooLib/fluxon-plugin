package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockMultiPlaceEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockMultiPlaceEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockMultiPlaceEvent {

    val TYPE = Type.fromClass(BlockMultiPlaceEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockMultiPlaceEvent::class.java)
                .function("replacedBlockStates", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.replacedBlockStates) }
        }
    }
}
