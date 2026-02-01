package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.SignChangeEvent
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

@Requires(classes = ["org.bukkit.event.block.SignChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnSignChangeEvent {

    val TYPE = Type.fromClass(SignChangeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SignChangeEvent::class.java)
                .function("player", returnsObject().noParams()) { it.setReturnRef(it.target?.player) }
                .function("lines", returnsObject().noParams()) { it.setReturnRef(it.target?.lines) }
                .function("getLine", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getLine(it.getInt(0).toInt())) }
                .function("setLine", returnsVoid().params(Type.I, Type.STRING)) { it.target?.setLine(it.getInt(0).toInt(), it.getString(1)) }
                .function("side", returnsObject().noParams()) { it.setReturnRef(it.target?.side) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(SignChangeEvent.getHandlerList()) }
        }
    }
}
