package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.ArrowBodyCountChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.ArrowBodyCountChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnArrowBodyCountChangeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ArrowBodyCountChangeEvent::class.java)
                .function("isReset", returns(Type.Z).noParams()) { it.target?.isReset }
                .function("oldAmount", returnsObject().noParams()) { it.target?.oldAmount }
                .function("newAmount", returnsObject().noParams()) { it.target?.newAmount }
                .function("setNewAmount", returnsObject().params(Type.OBJECT)) { it.target?.setNewAmount(it.getInt(0).toInt()) }
                .function("entity", returnsObject().noParams()) { it.target?.getEntity() }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { ArrowBodyCountChangeEvent.getHandlerList() }
        }
    }
}
