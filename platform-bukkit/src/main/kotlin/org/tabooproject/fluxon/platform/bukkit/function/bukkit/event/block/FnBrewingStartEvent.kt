package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BrewingStartEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.block.BrewingStartEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBrewingStartEvent {

    val TYPE = Type.fromClass(BrewingStartEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewingStartEvent::class.java)
                .function("totalBrewTime", returnsObject().noParams()) { it.setReturnRef(it.target?.totalBrewTime) }
                .function("setTotalBrewTime", returnsVoid().params(Type.I)) { it.target?.setTotalBrewTime(it.getInt(0).toInt()) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(BrewingStartEvent.getHandlerList()) }
        }
    }
}
