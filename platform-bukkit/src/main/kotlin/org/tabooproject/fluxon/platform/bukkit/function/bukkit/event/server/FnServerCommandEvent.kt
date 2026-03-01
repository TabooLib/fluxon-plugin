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
                .function("command",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.command) }
                .function("setCommand", returnsVoid().params(Type.STRING)) { it.target?.setCommand(it.getString(0)!!) }
                .function("sender",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE).noParams()) { it.setReturnRef(it.target?.sender) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(ServerCommandEvent.getHandlerList()) }
        }
    }
}
