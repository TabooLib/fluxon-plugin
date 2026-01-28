package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event

import org.bukkit.event.Event
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.event.Event"])
@PlatformSide(Platform.BUKKIT)
object FnEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Event::class.java)
                .function("eventName", returnsObject().noParams()) { it.setReturnRef(it.target?.eventName) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                .function("isAsynchronous", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isAsynchronous) }
        }
    }
}
