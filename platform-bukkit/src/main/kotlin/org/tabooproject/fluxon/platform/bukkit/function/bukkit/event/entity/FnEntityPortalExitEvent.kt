package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityPortalExitEvent
import org.bukkit.util.Vector
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

@Requires(classes = ["org.bukkit.event.entity.EntityPortalExitEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityPortalExitEvent {

    val TYPE = Type.fromClass(EntityPortalExitEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityPortalExitEvent::class.java)
                .function("before",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.before) }
                .function("after",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.after) }
                .function("setAfter",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.target?.setAfter(it.getRef(0) as Vector) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(EntityPortalExitEvent.getHandlerList()) }
        }
    }
}
