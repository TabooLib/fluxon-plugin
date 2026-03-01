package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.ServiceRegisterEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.server.ServiceRegisterEvent"])
@PlatformSide(Platform.BUKKIT)
object FnServiceRegisterEvent {

    val TYPE = Type.fromClass(ServiceRegisterEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServiceRegisterEvent::class.java)
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(ServiceRegisterEvent.getHandlerList()) }
        }
    }
}
