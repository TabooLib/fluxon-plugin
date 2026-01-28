package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.bukkit.event.server.BroadcastMessageEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.server.BroadcastMessageEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBroadcastMessageEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BroadcastMessageEvent::class.java)
                .function("message", returnsObject().noParams()) { it.target?.message }
                .function("setMessage", returnsObject().params(Type.OBJECT)) { it.target?.setMessage(it.getString(0)!!) }
                .function("recipients", returnsObject().noParams()) { it.target?.recipients }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { BroadcastMessageEvent.getHandlerList() }
        }
    }
}
