package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.ArrowBodyCountChangeEvent
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

@Requires(classes = ["org.bukkit.event.entity.ArrowBodyCountChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnArrowBodyCountChangeEvent {

    val TYPE = Type.fromClass(ArrowBodyCountChangeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ArrowBodyCountChangeEvent::class.java)
                .function("isReset", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isReset ?: false) }
                .function("oldAmount", returnsObject().noParams()) { it.setReturnRef(it.target?.oldAmount) }
                .function("newAmount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.newAmount ?: 0) }
                .function("setNewAmount", returnsVoid().params(Type.I)) { it.target?.setNewAmount(it.getInt(0).toInt()) }
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(ArrowBodyCountChangeEvent.getHandlerList()) }
        }
    }
}
