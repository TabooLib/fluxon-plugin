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
                .function("entity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("humanEntity",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHumanEntity.TYPE).noParams()) { it.setReturnRef(it.target?.humanEntity) }
                .function("ticksInLove", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksInLove ?: 0) }
                .function("setTicksInLove", returnsVoid().params(Type.I)) { it.target?.setTicksInLove(it.getInt(0).toInt()) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(EntityEnterLoveModeEvent.getHandlerList()) }
        }
    }
}
