package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.ServerCommandEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.server.ServerCommandEvent"])
@PlatformSide(Platform.BUKKIT)
object FnServerCommandEvent {

    val TYPE = Type.fromClass(ServerCommandEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServerCommandEvent::class.java)
                .function("command", returnsObject().noParams()) { it.setReturnRef(it.target?.command) }
                .function("setCommand", returnsVoid().params(Type.STRING)) { it.target?.setCommand(it.getString(0)!!) }
                .function("sender", returnsObject().noParams()) { it.setReturnRef(it.target?.sender) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(ServerCommandEvent.getHandlerList()) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
        }
    }
}
