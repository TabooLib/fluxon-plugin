package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.hanging

import org.bukkit.event.hanging.HangingBreakEvent
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.hanging.HangingBreakEvent"])
@PlatformSide(Platform.BUKKIT)
object FnHangingBreakEvent {

    val TYPE = Type.fromClass(HangingBreakEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HangingBreakEvent::class.java)
                .function("cause", returns(FnHangingBreakEventRemoveCause.TYPE).noParams()) { it.setReturnRef(it.target?.cause) }
        }
    }
}

@Requires(classes = ["org.bukkit.event.hanging.HangingBreakEvent.RemoveCause"])
@PlatformSide(Platform.BUKKIT)
object FnHangingBreakEventRemoveCause : FnEnumGetter<HangingBreakEvent.RemoveCause>() {

    override val enumClass: Class<HangingBreakEvent.RemoveCause> = HangingBreakEvent.RemoveCause::class.java
}
