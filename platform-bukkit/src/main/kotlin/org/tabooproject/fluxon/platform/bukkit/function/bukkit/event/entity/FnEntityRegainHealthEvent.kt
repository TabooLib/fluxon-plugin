package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityRegainHealthEvent
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


@Requires(classes = ["org.bukkit.event.entity.EntityRegainHealthEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityRegainHealthEvent {

    val TYPE = Type.fromClass(EntityRegainHealthEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityRegainHealthEvent::class.java)
                .function("amount", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.amount ?: 0.0) }
                .function("setAmount", returnsVoid().params(Type.D)) { it.target?.setAmount(it.getDouble(0)) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("regainReason", returnsObject().noParams()) { it.setReturnRef(it.target?.regainReason) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(EntityRegainHealthEvent.getHandlerList()) }
        }
    }
}
