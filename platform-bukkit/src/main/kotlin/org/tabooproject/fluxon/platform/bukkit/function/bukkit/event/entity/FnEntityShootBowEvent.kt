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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.event.entity.EntityShootBowEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityShootBowEvent {

    val TYPE = Type.fromClass(EntityShootBowEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityShootBowEvent::class.java)
                .function("entity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("bow",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.bow) }
                .function("consumable",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.consumable) }
                .function("projectile",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.projectile) }
                .function("setProjectile",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.target?.setProjectile(it.getRef(0) as Entity) }
                .function("hand",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE).noParams()) { it.setReturnRef(it.target?.hand) }
                .function("force", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.force ?: 0f) }
                .function("setConsumeItem", returnsVoid().params(Type.Z)) { it.target?.setConsumeItem(it.getBool(0)) }
                .function("shouldConsumeItem", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.shouldConsumeItem() ?: false) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(EntityShootBowEvent.getHandlerList()) }
        }
    }
}
