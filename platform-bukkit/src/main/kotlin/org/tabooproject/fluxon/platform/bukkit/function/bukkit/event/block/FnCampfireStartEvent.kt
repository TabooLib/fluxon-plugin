package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.CampfireStartEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.block.CampfireStartEvent"])
@PlatformSide(Platform.BUKKIT)
object FnCampfireStartEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CampfireStartEvent::class.java)
                .function("recipe", returnsObject().noParams()) { it.setReturnRef(it.target?.recipe) }
                .function("totalCookTime", returnsObject().noParams()) { it.setReturnRef(it.target?.totalCookTime) }
                .function("setTotalCookTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTotalCookTime(it.getInt(0).toInt())) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(CampfireStartEvent.getHandlerList()) }
        }
    }
}
