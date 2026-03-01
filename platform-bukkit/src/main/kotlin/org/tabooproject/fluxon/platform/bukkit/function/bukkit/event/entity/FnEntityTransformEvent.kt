package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityTransformEvent
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

@Requires(classes = ["org.bukkit.event.entity.EntityTransformEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityTransformEvent {

    val TYPE = Type.fromClass(EntityTransformEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityTransformEvent::class.java)
                .function("transformedEntity",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.transformedEntity) }
                .function("transformedEntities",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.transformedEntities) }
                .function("transformReason", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnEntityTransformEventTransformReason.TYPE).noParams()) { it.setReturnRef(it.target?.transformReason) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(EntityTransformEvent.getHandlerList()) }
        }
    }
}
