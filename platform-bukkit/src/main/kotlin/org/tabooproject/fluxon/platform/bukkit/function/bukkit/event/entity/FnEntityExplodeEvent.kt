package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityExplodeEvent
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

@Requires(classes = ["org.bukkit.event.entity.EntityExplodeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityExplodeEvent {

    val TYPE = Type.fromClass(EntityExplodeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityExplodeEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("blockList", returnsObject().noParams()) { it.setReturnRef(it.target?.blockList()) }
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
                .function("yield", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.yield ?: 0f) }
                .function("setYield", returnsVoid().params(Type.F)) { it.target?.setYield(it.getFloat(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(EntityExplodeEvent.getHandlerList()) }
        }
    }
}
