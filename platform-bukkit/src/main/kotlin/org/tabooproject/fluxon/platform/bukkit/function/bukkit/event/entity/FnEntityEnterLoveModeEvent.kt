package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityEnterLoveModeEvent
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

@Requires(classes = ["org.bukkit.event.entity.EntityEnterLoveModeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityEnterLoveModeEvent {

    val TYPE = Type.fromClass(EntityEnterLoveModeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityEnterLoveModeEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("humanEntity", returnsObject().noParams()) { it.setReturnRef(it.target?.humanEntity) }
                .function("ticksInLove", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksInLove ?: 0) }
                .function("setTicksInLove", returnsVoid().params(Type.I)) { it.target?.setTicksInLove(it.getInt(0).toInt()) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(EntityEnterLoveModeEvent.getHandlerList()) }
        }
    }
}
