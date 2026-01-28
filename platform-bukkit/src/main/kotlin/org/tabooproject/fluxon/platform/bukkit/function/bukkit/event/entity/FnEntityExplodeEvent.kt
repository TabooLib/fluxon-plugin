package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityExplodeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.EntityExplodeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityExplodeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityExplodeEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelled(it.getBool(0))) }
                .function("blockList", returnsObject().noParams()) { it.setReturnRef(it.target?.blockList()) }
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
                .function("yield", returnsObject().noParams()) { it.setReturnRef(it.target?.yield) }
                .function("setYield", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setYield(it.getFloat(0))) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(EntityExplodeEvent.getHandlerList()) }
        }
    }
}
