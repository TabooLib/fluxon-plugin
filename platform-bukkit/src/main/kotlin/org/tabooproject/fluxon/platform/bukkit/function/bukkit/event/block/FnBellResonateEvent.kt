package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BellResonateEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BellResonateEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBellResonateEvent {

    val TYPE = Type.fromClass(BellResonateEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BellResonateEvent::class.java)
                .function("resonatedEntities", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.resonatedEntities) }
        }
    }
}
