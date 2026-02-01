package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.hanging

import org.bukkit.event.hanging.HangingBreakByEntityEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.hanging.HangingBreakByEntityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnHangingBreakByEntityEvent {

    val TYPE = Type.fromClass(HangingBreakByEntityEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HangingBreakByEntityEvent::class.java)
                .function("remover", returnsObject().noParams()) { it.setReturnRef(it.target?.remover) }
        }
    }
}
