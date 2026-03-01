package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityKnockbackEvent
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

@Requires(classes = ["org.bukkit.event.entity.EntityKnockbackEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityKnockbackEvent {

    val TYPE = Type.fromClass(EntityKnockbackEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityKnockbackEvent::class.java)
                .function("entity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("cause", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnEntityKnockbackEventKnockbackCause.TYPE).noParams()) { it.setReturnRef(it.target?.cause) }
                .function("force",returns(Type.D).noParams()) { it.setReturnRef(it.target?.force) }
                .function("knockback",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.knockback) }
                .function("finalKnockback",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.finalKnockback) }
                .function("setFinalKnockback",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.target?.setFinalKnockback(it.getRef(0) as Vector) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(EntityKnockbackEvent.getHandlerList()) }
        }
    }
}
