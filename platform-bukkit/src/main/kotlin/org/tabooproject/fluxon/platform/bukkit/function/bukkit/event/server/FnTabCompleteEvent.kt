package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.TabCompleteEvent
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

@Requires(classes = ["org.bukkit.event.server.TabCompleteEvent"])
@PlatformSide(Platform.BUKKIT)
object FnTabCompleteEvent {

    val TYPE = Type.fromClass(TabCompleteEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TabCompleteEvent::class.java)
                .function("sender",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE).noParams()) { it.setReturnRef(it.target?.sender) }
                .function("buffer",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.buffer) }
                .function("completions",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.completions) }
                .function("setCompletions",returnsVoid().params(Type.LIST)) { it.target?.setCompletions(it.getRef(0) as List<String>) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(TabCompleteEvent.getHandlerList()) }
        }
    }
}
