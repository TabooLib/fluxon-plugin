package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.PortalCreateEvent
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

@Requires(classes = ["org.bukkit.event.world.PortalCreateEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPortalCreateEvent {

    val TYPE = Type.fromClass(PortalCreateEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PortalCreateEvent::class.java)
                .function("blocks",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.blocks) }
                .function("entity",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.entity) }
                .function("reason", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world.FnPortalCreateEventCreateReason.TYPE).noParams()) { it.setReturnRef(it.target?.reason) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PortalCreateEvent.getHandlerList()) }
        }
    }
}
