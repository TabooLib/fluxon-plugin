package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityPortalEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.entity.EntityPortalEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityPortalEvent {

    val TYPE = Type.fromClass(EntityPortalEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityPortalEvent::class.java)
                .function("setSearchRadius", returnsVoid().params(Type.I)) { it.target?.setSearchRadius(it.getInt(0).toInt()) }
                .function("searchRadius", returns(Type.I).noParams()) { it.setReturnInt(it.target?.searchRadius ?: 0) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(EntityPortalEvent.getHandlerList()) }
        }
    }
}
