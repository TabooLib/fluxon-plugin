package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.ExpBottleEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.entity.ExpBottleEvent"])
@PlatformSide(Platform.BUKKIT)
object FnExpBottleEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExpBottleEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.target?.getEntity() }
                .function("showEffect", returnsObject().noParams()) { it.target?.showEffect }
                .function("setShowEffect", returnsObject().params(Type.OBJECT)) { it.target?.setShowEffect(it.getBool(0)) }
                .function("experience", returnsObject().noParams()) { it.target?.experience }
                .function("setExperience", returnsObject().params(Type.OBJECT)) { it.target?.setExperience(it.getInt(0).toInt()) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { ExpBottleEvent.getHandlerList() }
        }
    }
}
