package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.entity.Entity
import org.bukkit.event.entity.EntityShootBowEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.event.entity.EntityShootBowEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityShootBowEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityShootBowEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.target?.getEntity() }
                .function("bow", returnsObject().noParams()) { it.target?.bow }
                .function("consumable", returnsObject().noParams()) { it.target?.consumable }
                .function("projectile", returnsObject().noParams()) { it.target?.projectile }
                .function("setProjectile", returnsObject().params(Type.OBJECT)) { it.target?.setProjectile(it.getRef(0) as Entity) }
                .function("hand", returnsObject().noParams()) { it.target?.hand }
                .function("force", returnsObject().noParams()) { it.target?.force }
                .function("setConsumeItem", returnsObject().params(Type.OBJECT)) { it.target?.setConsumeItem(it.getBool(0)) }
                .function("shouldConsumeItem", returns(Type.Z).noParams()) { it.target?.shouldConsumeItem() }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { EntityShootBowEvent.getHandlerList() }
        }
    }
}
