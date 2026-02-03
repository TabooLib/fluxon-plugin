package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.MoistureChangeEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.MoistureChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnMoistureChangeEvent {

    val TYPE = Type.fromClass(MoistureChangeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MoistureChangeEvent::class.java)
                .function("newState", returns(FnBlockState.TYPE).noParams()) { it.setReturnRef(it.target?.newState) }
        }
    }
}
