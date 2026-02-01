package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.ExpBottleEvent
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

@Requires(classes = ["org.bukkit.event.entity.ExpBottleEvent"])
@PlatformSide(Platform.BUKKIT)
object FnExpBottleEvent {

    val TYPE = Type.fromClass(ExpBottleEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExpBottleEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("showEffect", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.showEffect ?: false) }
                .function("setShowEffect", returnsVoid().params(Type.Z)) { it.target?.setShowEffect(it.getBool(0)) }
                .function("experience", returns(Type.I).noParams()) { it.setReturnInt(it.target?.experience ?: 0) }
                .function("setExperience", returnsVoid().params(Type.I)) { it.target?.setExperience(it.getInt(0).toInt()) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(ExpBottleEvent.getHandlerList()) }
        }
    }
}
