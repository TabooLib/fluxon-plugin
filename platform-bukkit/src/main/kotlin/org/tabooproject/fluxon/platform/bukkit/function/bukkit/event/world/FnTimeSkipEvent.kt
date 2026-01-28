package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.TimeSkipEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.world.TimeSkipEvent"])
@PlatformSide(Platform.BUKKIT)
object FnTimeSkipEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TimeSkipEvent::class.java)
                .function("skipReason", returnsObject().noParams()) { it.target?.skipReason }
                .function("skipAmount", returnsObject().noParams()) { it.target?.skipAmount }
                .function("setSkipAmount", returnsObject().params(Type.OBJECT)) { it.target?.setSkipAmount(it.getInt(0).toLong()) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { TimeSkipEvent.getHandlerList() }
        }
    }
}
