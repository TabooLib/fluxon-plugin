package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.TabCompleteEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.server.TabCompleteEvent"])
@PlatformSide(Platform.BUKKIT)
object FnTabCompleteEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TabCompleteEvent::class.java)
                .function("sender", returnsObject().noParams()) { it.target?.sender }
                .function("buffer", returnsObject().noParams()) { it.target?.buffer }
                .function("completions", returnsObject().noParams()) { it.target?.completions }
                .function("setCompletions", returnsObject().params(Type.OBJECT)) { it.target?.setCompletions(it.getRef(0) as List<String>) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { TabCompleteEvent.getHandlerList() }
        }
    }
}
