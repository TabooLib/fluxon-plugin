package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityDamageEvent
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


@Requires(classes = ["org.bukkit.event.entity.EntityDamageEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityDamageEvent {

    val TYPE = Type.fromClass(EntityDamageEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityDamageEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("getOriginalDamage", returns(Type.D).params(Type.OBJECT)) {
                    it.setReturnDouble(it.target?.getOriginalDamage(it.getRef(0) as EntityDamageEvent.DamageModifier) ?: 0.0)
                }
                .function("setDamage", returnsVoid().params(Type.D)) {
                    it.target?.setDamage(it.getDouble(0))
                }
                .function("setDamage", returnsVoid().params(Type.OBJECT, Type.D)) {
                    it.target?.setDamage(
                        it.getRef(0) as EntityDamageEvent.DamageModifier,
                        it.getDouble(1)
                    )
                }
                .function("damage", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.damage ?: 0.0) }
                .function("getDamage", returns(Type.D).params(Type.OBJECT)) {
                    it.setReturnDouble(it.target?.getDamage(it.getRef(0) as EntityDamageEvent.DamageModifier) ?: 0.0)
                }
                .function("isApplicable", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.isApplicable(it.getRef(0) as EntityDamageEvent.DamageModifier) ?: false)
                }
                .function("finalDamage", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.finalDamage ?: 0.0) }
                .function("cause", returnsObject().noParams()) { it.setReturnRef(it.target?.cause) }
                .function("damageSource", returnsObject().noParams()) { it.setReturnRef(it.target?.damageSource) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(EntityDamageEvent.getHandlerList()) }
        }
    }
}
