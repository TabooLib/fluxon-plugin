package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityDamageEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.event.entity.EntityDamageEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityDamageEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityDamageEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelled(it.getBool(0))) }
                .function("getOriginalDamage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getOriginalDamage(it.getRef(0) as EntityDamageEvent.DamageModifier)) }
                .function("setDamage", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setDamage(it.getAsDouble(0))
                    } else {
                        it.target?.setDamage(
                            it.getRef(0) as EntityDamageEvent.DamageModifier,
                            it.getAsDouble(1)
                        )
                    })
                }
                .function("setDamage", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setDamage(it.getAsDouble(0))
                    } else {
                        it.target?.setDamage(
                            it.getRef(0) as EntityDamageEvent.DamageModifier,
                            it.getAsDouble(1)
                        )
                    })
                }
                .function("damage", returnsObject().noParams()) { it.setReturnRef(it.target?.damage) }
                .function("getDamage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getDamage(it.getRef(0) as EntityDamageEvent.DamageModifier)) }
                .function("isApplicable", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.isApplicable(it.getRef(0) as EntityDamageEvent.DamageModifier)) }
                .function("finalDamage", returnsObject().noParams()) { it.setReturnRef(it.target?.finalDamage) }
                .function("cause", returnsObject().noParams()) { it.setReturnRef(it.target?.cause) }
                .function("damageSource", returnsObject().noParams()) { it.setReturnRef(it.target?.damageSource) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(EntityDamageEvent.getHandlerList()) }
        }
    }
}
