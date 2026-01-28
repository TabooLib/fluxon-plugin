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
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.entity.EntityPortalExitEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityPortalExitEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityPortalExitEvent::class.java)
                .function("before", returnsObject().noParams()) { it.target?.before }
                .function("after", returnsObject().noParams()) { it.target?.after }
                .function("setAfter", returnsObject().params(Type.OBJECT)) { it.target?.setAfter(it.getRef(0) as Vector) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { EntityPortalExitEvent.getHandlerList() }
        }
    }
}
