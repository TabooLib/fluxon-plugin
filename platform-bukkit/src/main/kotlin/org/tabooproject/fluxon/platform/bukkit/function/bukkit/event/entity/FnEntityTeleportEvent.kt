package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.Location
import org.bukkit.event.entity.EntityTeleportEvent
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

@Requires(classes = ["org.bukkit.event.entity.EntityTeleportEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityTeleportEvent {

    val TYPE = Type.fromClass(EntityTeleportEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityTeleportEvent::class.java)
                .function("from",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.from) }
                .function("setFrom",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.target?.setFrom(it.getRef(0) as Location) }
                .function("to",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.to) }
                .function("setTo",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.target?.setTo(it.getRef(0) as Location) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(EntityTeleportEvent.getHandlerList()) }
        }
    }
}
