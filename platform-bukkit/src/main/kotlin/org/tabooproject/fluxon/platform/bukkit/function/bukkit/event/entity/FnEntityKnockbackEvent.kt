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
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.EntityKnockbackEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityKnockbackEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityKnockbackEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.target?.getEntity() }
                .function("cause", returnsObject().noParams()) { it.target?.cause }
                .function("force", returnsObject().noParams()) { it.target?.force }
                .function("knockback", returnsObject().noParams()) { it.target?.knockback }
                .function("finalKnockback", returnsObject().noParams()) { it.target?.finalKnockback }
                .function("setFinalKnockback", returnsObject().params(Type.OBJECT)) { it.target?.setFinalKnockback(it.getRef(0) as Vector) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { EntityKnockbackEvent.getHandlerList() }
        }
    }
}
