package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.TimeSkipEvent
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

@Requires(classes = ["org.bukkit.event.world.TimeSkipEvent"])
@PlatformSide(Platform.BUKKIT)
object FnTimeSkipEvent {

    val TYPE = Type.fromClass(TimeSkipEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TimeSkipEvent::class.java)
                .function("skipReason", returnsObject().noParams()) { it.setReturnRef(it.target?.skipReason) }
                .function("skipAmount", returnsObject().noParams()) { it.setReturnRef(it.target?.skipAmount) }
                .function("setSkipAmount", returnsVoid().params(Type.J)) { it.target?.setSkipAmount(it.getLong(0)) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(TimeSkipEvent.getHandlerList()) }
        }
    }
}
