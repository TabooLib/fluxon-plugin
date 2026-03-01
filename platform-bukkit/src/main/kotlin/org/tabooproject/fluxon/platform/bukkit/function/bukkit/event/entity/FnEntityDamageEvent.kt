package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityDamageEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
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
                .function("getOriginalDamage", returns(Type.D).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnEntityDamageEventDamageModifier.TYPE)) { it.setReturnDouble(it.target?.getOriginalDamage(it.getRef(0) as EntityDamageEvent.DamageModifier) ?: 0.0) }
                .function("getOriginalDamage", returns(Type.D).params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnEntityDamageEventDamageModifier.enumValue(it.getString(0))?.let { p0 -> it.setReturnDouble(it.target?.getOriginalDamage(p0) ?: 0.0) } }
                .function("setDamage", returnsVoid().params(Type.D)) {
                    it.target?.setDamage(it.getDouble(0))
                }
                .function("setDamage", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnEntityDamageEventDamageModifier.TYPE, Type.D)) {
                    it.target?.setDamage(
                        it.getRef(0) as EntityDamageEvent.DamageModifier,
                        it.getDouble(1)
                    )
                }
                .function("setDamage", returnsVoid().params(Type.STRING, Type.D)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnEntityDamageEventDamageModifier.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.setDamage(p0, it.getDouble(1))
                    }
                }
                .function("damage", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.damage ?: 0.0) }
                .function("getDamage", returns(Type.D).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnEntityDamageEventDamageModifier.TYPE)) { it.setReturnDouble(it.target?.getDamage(it.getRef(0) as EntityDamageEvent.DamageModifier) ?: 0.0) }
                .function("getDamage", returns(Type.D).params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnEntityDamageEventDamageModifier.enumValue(it.getString(0))?.let { p0 -> it.setReturnDouble(it.target?.getDamage(p0) ?: 0.0) } }
                .function("isApplicable", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnEntityDamageEventDamageModifier.TYPE)) { it.setReturnBool(it.target?.isApplicable(it.getRef(0) as EntityDamageEvent.DamageModifier) ?: false) }
                .function("isApplicable", returns(Type.Z).params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnEntityDamageEventDamageModifier.enumValue(it.getString(0))?.let { p0 -> it.setReturnBool(it.target?.isApplicable(p0) ?: false) } }
                .function("finalDamage", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.finalDamage ?: 0.0) }
                .function("cause", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnEntityDamageEventDamageCause.TYPE).noParams()) { it.setReturnRef(it.target?.cause) }
                .function("damageSource",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.damage.FnDamageSource.TYPE).noParams()) { it.setReturnRef(it.target?.damageSource) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(EntityDamageEvent.getHandlerList()) }
        }
    }
}
