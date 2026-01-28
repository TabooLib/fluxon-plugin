package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.SignChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.block.SignChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnSignChangeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SignChangeEvent::class.java)
                .function("player", returnsObject().noParams()) { it.target?.player }
                .function("lines", returnsObject().noParams()) { it.target?.lines }
                .function("getLine", returnsObject().params(Type.OBJECT)) { it.target?.getLine(it.getInt(0).toInt()) }
                .function("setLine", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.setLine(it.getInt(0).toInt(), it.getString(1)) }
                .function("side", returnsObject().noParams()) { it.target?.side }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { SignChangeEvent.getHandlerList() }
        }
    }
}
