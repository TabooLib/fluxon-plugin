package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityPortalEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.entity.EntityPortalEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityPortalEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityPortalEvent::class.java)
                .function("setSearchRadius", returnsObject().params(Type.OBJECT)) { it.target?.setSearchRadius(it.getInt(0).toInt()) }
                .function("searchRadius", returnsObject().noParams()) { it.target?.searchRadius }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { EntityPortalEvent.getHandlerList() }
        }
    }
}
