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
                .function("blockList",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.blockList()) }
                .function("location",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.location) }
                .function("yield", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.yield ?: 0f) }
                .function("setYield", returnsVoid().params(Type.F)) { it.target?.setYield(it.getFloat(0)) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(EntityExplodeEvent.getHandlerList()) }
        }
    }
}
